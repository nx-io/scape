package me.scape.ti.criteria;

public class ItemQueryCriteria extends PaginationCriteria {

    private String title;

    private Integer type;

    private Long category_id;

    private Long area_category_id;

    private Long style_id;

    private Integer status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
