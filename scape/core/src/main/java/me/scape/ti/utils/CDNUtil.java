package me.scape.ti.utils;

import java.io.InputStream;

import me.scape.ti.utils.cdn.CDN;
import me.scape.ti.utils.cdn.QiniuCDN;

public final class CDNUtil {

    private static CDN cdn;

    static {
        cdn = new QiniuCDN();
    }

    public static String uploadFile(InputStream in, String fileName) throws Exception {
        return cdn.uploadFile(in, fileName);
    }

    public static boolean deleteFile(String path) {
        return cdn.deleteFile(path);
    }

    public static String getFullPath(String path) {
        return cdn.getHttpPath(path);
    }
}
