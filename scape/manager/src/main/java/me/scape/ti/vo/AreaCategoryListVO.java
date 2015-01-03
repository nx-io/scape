package me.scape.ti.vo;

import java.io.Serializable;
import java.util.Date;

public class AreaCategoryListVO implements Serializable {

    private static final long serialVersionUID = 1950719595601875261L;

    private Long id;

    private String name;

    private String icon;

    private Date gmt_created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

}
