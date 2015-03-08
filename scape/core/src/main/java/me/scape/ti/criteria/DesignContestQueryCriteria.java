package me.scape.ti.criteria;

public class DesignContestQueryCriteria extends PaginationCriteria {

    private String title;

    private Integer status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
