package me.scape.ti.dataobject;

import java.io.Serializable;
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
 * 任务申请表.
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 *
 * @version 1.0.0
 * @since 2015年10月13日 下午6:32:05
 */
@Entity
@Table(name = "task_user", catalog = "scape")
public class TaskUserDO implements Serializable {
	
	private static final long serialVersionUID = -4362982702467367102L;

    /**1没有中标*/
    public static final Byte BIDS = 1;
    /**2中标*/
    public static final Byte WIN_BIDS = 2;
    /**3没有中标*/
    public static final Byte FAILURE_BIDS = 3;
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

    @Column(name = "task_id", nullable = false)
    private Long task_id;// 任务

    @Column(name = "user_id", nullable = false)
    private Long user_id;// 申请人

	@Column(name = "is_bid", nullable = false)
	private Byte isBid;// 是否中标(1审核中, 2是, 3否)
    
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

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Byte getIsBid() {
        return isBid;
    }

    public void setIsBid(Byte isBid) {
        this.isBid = isBid;
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
        result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
        result = prime * result + ((gmt_modified == null) ? 0 : gmt_modified.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((isBid == null) ? 0 : isBid.hashCode());
        result = prime * result + ((task_id == null) ? 0 : task_id.hashCode());
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
        TaskUserDO other = (TaskUserDO) obj;
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
        if (isBid == null) {
            if (other.isBid != null)
                return false;
        } else if (!isBid.equals(other.isBid))
            return false;
        if (task_id == null) {
            if (other.task_id != null)
                return false;
        } else if (!task_id.equals(other.task_id))
            return false;
        if (user_id == null) {
            if (other.user_id != null)
                return false;
        } else if (!user_id.equals(other.user_id))
            return false;
        return true;
    }
}