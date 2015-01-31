package me.scape.ti.vo;

import java.io.Serializable;
import java.util.Date;

public class PlantColorListVO implements Serializable {

    private static final long serialVersionUID = 998698587708654399L;

    private Integer id;

    private String color;

    private String icon;

    private Byte display;

    private Date gmt_created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Byte getDisplay() {
        return display;
    }

    public void setDisplay(Byte display) {
        this.display = display;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

}