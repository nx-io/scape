package me.scape.ti.vo;

import java.io.Serializable;
import java.util.Date;

public class ContestListVO implements Serializable {

    private static final long serialVersionUID = 4755097592390424309L;

    private Integer id;

    private String title;// 大赛标题

    private Byte status;// 状态

    private Date start_time;// 开始时间

    private Date end_time;// 结束时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

}
