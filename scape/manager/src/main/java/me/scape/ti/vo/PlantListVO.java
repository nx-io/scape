package me.scape.ti.vo;

import java.io.Serializable;
import java.util.Date;

public class PlantListVO implements Serializable {

    private static final long serialVersionUID = -8762486454317939463L;

    private Integer id;

    private Integer cat_id;

    private String category;

    private String name_cn;// 中文名

    private String name_en;// 英文名

    private String alias_name;// 别名

    private String cover_media;// 植物封皮

    private String genus;// 科属

    private Date gmt_created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName_cn() {
        return name_cn;
    }

    public void setName_cn(String name_cn) {
        this.name_cn = name_cn;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getAlias_name() {
        return alias_name;
    }

    public void setAlias_name(String alias_name) {
        this.alias_name = alias_name;
    }

    public String getCover_media() {
        return cover_media;
    }

    public void setCover_media(String cover_media) {
        this.cover_media = cover_media;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

}
