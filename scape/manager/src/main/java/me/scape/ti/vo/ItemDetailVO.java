package me.scape.ti.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ItemDetailVO implements Serializable {

    private static final long serialVersionUID = -488376024706684229L;

    private Long id;

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

    private Integer media_count;

    private Integer comment_count;

    private Integer praise_count;

    private Integer like_count;

    private Long user_id;

    private Date gmt_modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getMedia_count() {
        return media_count;
    }

    public void setMedia_count(Integer media_count) {
        this.media_count = media_count;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getPraise_count() {
        return praise_count;
    }

    public void setPraise_count(Integer praise_count) {
        this.praise_count = praise_count;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

}