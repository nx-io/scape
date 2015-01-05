package me.scape.ti.service;

import java.util.Map;

import me.scape.ti.exception.CPException;

import org.springframework.web.multipart.MultipartFile;

public interface MediaService {

    Map<String, String> uploadImage(MultipartFile image) throws CPException;

    boolean deleteImage(String image) throws CPException;
}
