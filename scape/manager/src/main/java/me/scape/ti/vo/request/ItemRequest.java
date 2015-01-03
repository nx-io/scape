package me.scape.ti.vo.request;

import java.util.List;

public class ItemRequest {

    private String title;

    private Byte type;

    private Long category_id;

    private Long area_category_id;

    private Long style_id;

    private Byte status;

    private String description;

    private String designer;

    private String designer_contact;

    private String constructor;

    private String constructor_contact;

    private String cover_media;

    private List<String> medias;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getArea_category_id() {
        return area_category_id;
    }

    public void setArea_category_id(Long area_category_id) {
        this.area_category_id = area_category_id;
    }

    public Long getStyle_id() {
        return style_id;
    }

    public void setStyle_id(Long style_id) {
        this.style_id = style_id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getDesigner_contact() {
        return designer_contact;
    }

    public void setDesigner_contact(String designer_contact) {
        this.designer_contact = designer_contact;
    }

    public String getConstructor() {
        return constructor;
    }

    public void setConstructor(String constructor) {
        this.constructor = constructor;
    }

    public String getConstructor_contact() {
        return constructor_contact;
    }

    public void setConstructor_contact(String constructor_contact) {
        this.constructor_contact = constructor_contact;
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

}
