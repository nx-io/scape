package me.scape.ti.criteria;

import java.math.BigDecimal;
import java.util.Date;

public class TaskQueryCriteria extends PaginationCriteria {

    private Long publishUserId;// 发布者

    private Byte type;// 任务类型（1建筑设计、2室内设计、3景观设计、4家具设计、5平面设计、6工业设计）

    private Byte status;// 状态，(1待招标，2招标中, 3结束)

    private String title;// 详细描述

    private BigDecimal fromReward;// 任务金额
    private BigDecimal toReward;// 任务金额

    private Date fromCreated;
    private Date toCreated;

    private Date fromStartDate;
    private Date toStartDate;

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getFromReward() {
        return fromReward;
    }

    public void setFromReward(BigDecimal fromReward) {
        this.fromReward = fromReward;
    }

    public BigDecimal getToReward() {
        return toReward;
    }

    public void setToReward(BigDecimal toReward) {
        this.toReward = toReward;
    }

    public Date getFromCreated() {
        return fromCreated;
    }

    public void setFromCreated(Date fromCreated) {
        this.fromCreated = fromCreated;
    }

    public Date getToCreated() {
        return toCreated;
    }

    public void setToCreated(Date toCreated) {
        this.toCreated = toCreated;
    }

    public Date getFromStartDate() {
        return fromStartDate;
    }

    public void setFromStartDate(Date fromStartDate) {
        this.fromStartDate = fromStartDate;
    }

    public Date getToStartDate() {
        return toStartDate;
    }

    public void setToStartDate(Date toStartDate) {
        this.toStartDate = toStartDate;
    }
}
