package me.scape.ti.vo;

import java.io.Serializable;
import java.util.Date;

public class PlantCategoryListVO implements Serializable {

    private static final long serialVersionUID = -5362240778321442021L;

    private Integer id;

    private String name;

    private String icon;

    private Byte display;

    private Date gmt_created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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