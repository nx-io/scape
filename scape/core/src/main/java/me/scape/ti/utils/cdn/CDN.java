package me.scape.ti.utils.cdn;

import java.io.InputStream;

public interface CDN {

    String uploadFile(InputStream in, String fileName) throws Exception;

    boolean deleteFile(String path);

    String getHttpPath(String path);
}
