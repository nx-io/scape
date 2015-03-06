package me.scape.ti.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.scape.ti.constant.CommonConstant;
import me.scape.ti.constant.ResponseStatus;
import me.scape.ti.exception.CPException;
import me.scape.ti.service.MediaService;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@Controller
@RequestMapping(value = "/image")
public class ImageController extends BaseController {

	@Resource
	private MediaService mediaService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void uploadImg(
			@RequestParam(value = "Filedata", required = true) MultipartFile image,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			Map<String, String> result = mediaService.uploadImage(image);
			map.put("status", ResponseStatus.SUCCEED.getValue());
			map.put("body", result);
		} catch (CPException e) {
			map.put("status", ResponseStatus.FAILED.getValue());
			map.put("error_code", e.getCode().getValue());
		}

		response.setContentType("application/json,charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();

		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			String json = mapper.writeValueAsString(map);
			out.print(json);
			out.flush();
		} catch (IOException e) {
			// NULL
		} finally {
			try {
				if (null != out) {
					out.close();
				}
			} catch (IOException e) {
				// NULL
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "file_upload", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> fileUploadForKindeditor(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, FileUploadException {

		Map<String, Object> msg = new HashMap<String, Object>();

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}

		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

		// 最大文件大小
		long maxSize = 1000000;

		response.setContentType("text/plain;charset=UTF-8");

		if (!ServletFileUpload.isMultipartContent(request)) {
			return getError("请选择文件。");
		}

		DefaultMultipartHttpServletRequest mrequest = (DefaultMultipartHttpServletRequest) request;

		Map map = mrequest.getFileMap();
		Collection<MultipartFile> c = map.values();
		Iterator it = c.iterator();
		for (; it.hasNext();) {
			MultipartFile file = (MultipartFile) it.next();
			if (!file.isEmpty()) {
				long fileSize = file.getSize();
				String fileName = file.getOriginalFilename();
				String fileExt = fileName.substring(
						fileName.lastIndexOf(".") + 1).toLowerCase();

				if (fileSize > maxSize) {
					return getError("上传文件大小超过限制。");
				}
				if (!Arrays.<String> asList(extMap.get(dirName).split(","))
						.contains(fileExt)) {
					return getError("上传文件扩展名是不允许的扩展名。\n只允许"
							+ extMap.get(dirName) + "格式。");
				}

				try {
					Map<String, String> result = mediaService.uploadImage(file);
					msg.put("error", 0);
					msg.put("url",
							result.get(CommonConstant.ORIGINAL_IMAGE_URL));
				} catch (CPException e) {
					msg.put("error", 1);
					msg.put("message", "上传文件失败。");
				}

				return msg;
			}
		}

		return msg;
	}

	private Map<String, Object> getError(String message) {
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("error", 1);
		obj.put("message", message);
		return obj;
	}

}
