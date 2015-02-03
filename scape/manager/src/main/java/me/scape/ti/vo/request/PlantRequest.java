package me.scape.ti.vo.request;

import java.io.Serializable;
import java.util.List;

public class PlantRequest implements Serializable {

    private static final long serialVersionUID = -964705619985955844L;

    private Integer cat_id;

    private String name_cn;

    private String name_en;

    private String alias_name;

    private String genus;

    private String habits;

    private String garden_utilization;

    private String area_applicable;

    private String cover_media;

    private List<String> medias;

    private List<Integer> colors;

    private List<Integer> periods;

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

    public String getCover_media() {
        return cover_media;
    }

    public void setCover_media(String cover_media) {
        this.cover_media = cover_media;
    }

    public List<String> getMedias() {
        return medias;
    }

    public void setMedias(List<String> medias) {
        this.medias = medias;
    }

    public List<Integer> getColors() {
        return colors;
    }

    public void setColors(List<Integer> colors) {
        this.colors = colors;
    }

    public List<Integer> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Integer> periods) {
        this.periods = periods;
    }

}
