package me.scape.ti.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PlantDetailVO implements Serializable {

    private static final long serialVersionUID = -4458371032046722446L;

    private Integer id;

    private Integer cat_id;

    private String name_cn;

    private String name_en;

    private String alias_name;

    private String genus;

    private String habits;

    private String garden_utilization;

    private String area_applicable;

    private Date gmt_created;

    private MediaVO cover_media;

    private List<MediaVO> medias;

    private List<PlantColorListVO> colors;

    private List<PlantPeriodListVO> periods;

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

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public String getGarden_utilization() {
        return garden_utilization;
    }

    public void setGarden_utilization(String garden_utilization) {
        this.garden_utilization = garden_utilization;
    }

    public String getArea_applicable() {
        return area_applicable;
    }

    public void setArea_applicable(String area_applicable) {
        this.area_applicable = area_applicable;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    public MediaVO getCover_media() {
        return cover_media;
    }

    public void setCover_media(MediaVO cover_media) {
        this.cover_media = cover_media;
    }

    public List<MediaVO> getMedias() {
        return medias;
    }

    public void setMedias(List<MediaVO> medias) {
        this.medias = medias;
    }

    public List<PlantColorListVO> getColors() {
        return colors;
    }

    public void setColors(List<PlantColorListVO> colors) {
        this.colors = colors;
    }

    public List<PlantPeriodListVO> getPeriods() {
        return periods;
    }

    public void setPeriods(List<PlantPeriodListVO> periods) {
        this.periods = periods;
    }

}
