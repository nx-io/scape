package me.scape.ti.vo;

import java.io.Serializable;
import java.util.Date;

public class ContestJudgeListVO implements Serializable {

    private static final long serialVersionUID = -1272423103227222780L;

    private Long id;

    private Integer contest_id;

    private String contest_title;

    private String name;

    private String title;

    private String avatar;

    private Date gmt_created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getContest_id() {
        return contest_id;
    }

    public void setContest_id(Integer contest_id) {
        this.contest_id = contest_id;
    }

    public String getContest_title() {
        return contest_title;
    }

    public void setContest_title(String contest_title) {
        this.contest_title = contest_title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

}
