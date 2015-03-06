package me.scape.ti.vo;

import java.io.Serializable;
import java.util.Date;

public class ContestDetailNewsVO implements Serializable {

    private static final long serialVersionUID = -8091076014256766556L;

    private Long id;

    private String title;

    private Integer contest_id;

    private String content;

    private Date gmt_created;

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

    public Integer getContest_id() {
        return contest_id;
    }

    public void setContest_id(Integer contest_id) {
        this.contest_id = contest_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

}
