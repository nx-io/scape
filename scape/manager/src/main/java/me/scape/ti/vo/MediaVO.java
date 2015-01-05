package me.scape.ti.vo;

import java.io.Serializable;

public class MediaVO implements Serializable {

    private static final long serialVersionUID = 2993934324821205310L;

    private String path;

    private String url;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
