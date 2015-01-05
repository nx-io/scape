package me.scape.ti.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import me.scape.ti.constant.ResponseStatus;
import me.scape.ti.exception.CPException;
import me.scape.ti.service.MediaService;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/image")
public class ImageController extends BaseController {

    @Resource
    private MediaService mediaService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void uploadImg(@RequestParam(value = "Filedata", required = true) MultipartFile image,
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

}
