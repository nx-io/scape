package me.scape.ti.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 任务.
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 *
 * @version 1.0.0
 * @since 2015年10月13日 下午6:32:05
 */
@Entity
@Table(name = "task", catalog = "scape")
public class TaskDO implements Serializable {

	private static final long serialVersionUID = 4184747991081019232L;

    /**1待招标*/
    public static final Byte NEED_BIDS = 1;
    /**2招标中*/
    public static final Byte BIDDING = 2;
    /**3结束*/
    public static final Byte BID_END = 3;
    
    /**1建筑设计*/
    public static final Byte TYPE_ARCH = 1;
    /**2室内设计*/
    public static final Byte TYPE_INTERIOR = 2;
    /**3景观设计*/
    public static final Byte TYPE_LANDSCAPE = 3;
    /**4家具设计*/
    public static final Byte TYPE_FURNITURE = 4;
    /**5平面设计*/
    public static final Byte TYPE_GRAPHIC = 5;
    /**6工业设计*/
    public static final Byte TYPE_INDUSTRIAL = 6;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

    @Column(name = "title", nullable = false, length = 256)
    private String title;// 标题

	@Column(name = "type", nullable = false)
	private Byte type;// 任务类型（1建筑设计、2室内设计、3景观设计、4家具设计、5平面设计、6工业设计）

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;// 详细描述

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false)
    private Date start_date;// 启动时间

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false)
    private Date end_date;// 招标截止时间

    @Column(name = "reward", precision = 19, scale = 2)
//    @Column(name = "reward")
    private BigDecimal reward;// 任务金额

    @Column(name = "user_id", nullable = false)
    private Long user_id;// 发布者
    
    @Column(name = "status", nullable = false)
    private Byte status;// 状态，(1待招标，2招标中, 3结束)
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = false)
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
        result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
        result = prime * result + ((gmt_modified == null) ? 0 : gmt_modified.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((reward == null) ? 0 : reward.hashCode());
        result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TaskDO other = (TaskDO) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (end_date == null) {
            if (other.end_date != null)
                return false;
        } else if (!end_date.equals(other.end_date))
            return false;
        if (gmt_created == null) {
            if (other.gmt_created != null)
                return false;
        } else if (!gmt_created.equals(other.gmt_created))
            return false;
        if (gmt_modified == null) {
            if (other.gmt_modified != null)
                return false;
        } else if (!gmt_modified.equals(other.gmt_modified))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (reward == null) {
            if (other.reward != null)
                return false;
        } else if (!reward.equals(other.reward))
            return false;
        if (start_date == null) {
            if (other.start_date != null)
                return false;
        } else if (!start_date.equals(other.start_date))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (user_id == null) {
            if (other.user_id != null)
                return false;
        } else if (!user_id.equals(other.user_id))
            return false;
        return true;
    }
}