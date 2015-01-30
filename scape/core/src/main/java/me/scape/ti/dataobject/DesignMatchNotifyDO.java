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
 * 景观规划设计赛事通知.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午10:47:12
 */
@Entity
@Table(name = "design_match_notification", catalog = "scape")
public class DesignMatchNotifyDO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final byte DEFAULT_ALL = -1;
	public static final byte DEFAULT_SOUND = 1; // 使用默认提示音提示
	public static final byte DEFAULT_VIBRATE = 2; // 使用默认震动提示

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "match_id", nullable = false)
	private Long match_id;// 赛事ID

	@Column(name = "title", nullable = false, length = 16)
	private String title;// 赛事通知标题

	@Column(name = "description", nullable = false, length = 128)
	private String description;// 赛事通知简述

	@Column(name = "payload", nullable = false, length = 256)
	private String payload;// 赛事通知内容

	@Column(name = "notifyType", nullable = false)
	private Byte notifyType;// 1:使用默认提示音提示, 2:使用默认震动提示

	@Column(name = "timeToLive", nullable = false)
	private Integer timeToLive;// 消息保存时间

	@Column(name = "passThrough", nullable = false)
	private Boolean passThrough;// 透传方式 1表示透传消息，0表示通知栏消息。

	@Column(name = "status", nullable = false)
	private Boolean status;// 通知状态 0:删除 1:活跃

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

	public Long getMatch_id() {
		return match_id;
	}

	public void setMatch_id(Long match_id) {
		this.match_id = match_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public Byte getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(Byte notifyType) {
		this.notifyType = notifyType;
	}

	public Integer getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(Integer timeToLive) {
		this.timeToLive = timeToLive;
	}

	public Boolean getPassThrough() {
		return passThrough;
	}

	public void setPassThrough(Boolean passThrough) {
		this.passThrough = passThrough;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
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
}