package me.scape.ti.utils;

public final class FileUtil {

    public static String getFileType(final String fileName) {
        String fileType = "";
        int index = fileName.lastIndexOf(".");
        if (index != -1) {
            fileType = fileName.substring(index + 1);
        }
        return fileType;
    }

}
