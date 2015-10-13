package me.scape.ti.vo;

import java.math.BigDecimal;
import java.util.Date;

import me.scape.ti.dataobject.TaskDO;
import me.scape.ti.dataobject.TaskUserDO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 下午2:56:26
 */
public class ApplyTaskVO {

    private Long id;

    private Byte type;// 任务类型（1建筑设计、2室内设计、3景观设计、4家具设计、5平面设计、6工业设计）

    private String description;// 详细描述

    private Date start_date;// 启动时间

    private Date end_date;// 招标截止时间

    private BigDecimal reward;// 任务金额

    private Long published_user_id;// 发布者

    private Long apply_user_id;// 申请人

    private Byte status;// 状态，(1待招标，2招标中, 3结束)
    
    private Byte isBid;// 是否中标(1是, 2否)
    
    private Date gmt_created;
	
	public static ApplyTaskVO newInstance(TaskDO task) {
		if(task == null) {
			return null;
		}
		ApplyTaskVO vo = new ApplyTaskVO();
		vo.setDescription(task.getDescription());
		vo.setEnd_date(task.getEnd_date());
		vo.setGmt_created(task.getGmt_created());
		vo.setId(task.getId());
		vo.setReward(task.getReward());
		vo.setStart_date(task.getStart_date());
		vo.setStatus(task.getStatus());
		vo.setType(task.getType());
		vo.setPublished_user_id(task.getUser_id());
		return vo;
	}
	
	public ApplyTaskVO applyTask(TaskUserDO task) {
	    setGmt_created(task.getGmt_created());
	    setIsBid(task.getIsBid());
	    setApply_user_id(task.getUser_id());
	    return this;
	}

    public Long getPublished_user_id() {
        return published_user_id;
    }

    public void setPublished_user_id(Long published_user_id) {
        this.published_user_id = published_user_id;
    }

    public Long getApply_user_id() {
        return apply_user_id;
    }

    public void setApply_user_id(Long apply_user_id) {
        this.apply_user_id = apply_user_id;
    }

    public Byte getIsBid() {
        return isBid;
    }

    public void setIsBid(Byte isBid) {
        this.isBid = isBid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }
}