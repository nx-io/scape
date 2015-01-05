package me.scape.ti.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import me.scape.ti.constant.CommonConstant;
import me.scape.ti.constant.ResponseCode;
import me.scape.ti.exception.CPException;
import me.scape.ti.exception.CPExceptionFactory;
import me.scape.ti.service.MediaService;
import me.scape.ti.utils.CDNUtil;
import me.scape.ti.utils.FileUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MediaServiceImpl implements MediaService {

    @Override
    public Map<String, String> uploadImage(final MultipartFile image) throws CPException {
        String fileType = FileUtil.getFileType(image.getOriginalFilename());
        String fileName = new StringBuilder().append(UUID.randomUUID()).append(".").append(fileType).toString();
        String path = null;
        try {
            path = CDNUtil.uploadFile(image.getInputStream(), fileName);
        } catch (Exception e) {
            throw CPExceptionFactory.getException(CPException.class, ResponseCode.FILE_UPLOAD_ERROR);
        }

        Map<String, String> result = new HashMap<String, String>();
        result.put(CommonConstant.IMAGE_PATH, path);
        result.put(CommonConstant.ORIGINAL_IMAGE_URL, CDNUtil.getFullPath(path));
        return result;
    }

    @Override
    public boolean deleteImage(final String image) throws CPException {
        return CDNUtil.deleteFile(image);
    }

}
