package me.scape.ti.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 景观规划设计赛事.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午10:30:02
 */
@Entity
@Table(name = "design_contest", catalog = "scape")
@NamedQueries({
        @NamedQuery(name = "DesignContestDO.getContestsByIds", query = "FROM DesignContestDO WHERE id IN :ids"),
        @NamedQuery(name = "DesignContestDO.getAllEnabledContests", query = "FROM DesignContestDO WHERE id != 3") })
public class DesignContestDO implements Serializable {

	private static final long serialVersionUID = -4286930921212697495L;

	/** 筹备中 */
	public static final byte BEGINING = 1;

	/** 进行中 (可以展示) */
	public static final byte IN_PROGRESS = 2;

	/** 已经结束 */
	public static final byte ENDED = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "title", nullable = false, length = 256)
	private String title;// 大赛标题

	@Column(name = "description", nullable = false, length = 1024)
	private String description;// 大赛简介

	@Column(name = "topic", nullable = false, length = 256)
	private String topic;// 大赛题目

	@Column(name = "requirements", nullable = false, length = 1024)
	private String requirements;// 大赛要求

	@Column(name = "timetable", nullable = false, length = 1024)
	private String timetable;// 大赛流程

	@Column(name = "prizes", nullable = false, length = 1024)
	private String prizes;// 奖项设置

	@Column(name = "committee", nullable = false, length = 1024)
	private String committee;// 组委会

	@Column(name = "host_organizers", nullable = false, length = 1024)
	private String host_organizers;// 主办

	@Column(name = "organizers", nullable = false, length = 1024)
	private String organizers;// 承办

	@Column(name = "co_organizers", nullable = false, length = 1024)
	private String co_organizers;// 协办

	@Column(name = "status", nullable = false)
	private Byte status;// 状态

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time", nullable = false)
	private Date start_time;// 开始时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time", nullable = false)
	private Date end_time;// 结束时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = true)
	private Date gmt_modified;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getTimetable() {
		return timetable;
	}

	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}

	public String getPrizes() {
		return prizes;
	}

	public void setPrizes(String prizes) {
		this.prizes = prizes;
	}

	public String getCommittee() {
		return committee;
	}

	public void setCommittee(String committee) {
		this.committee = committee;
	}

	public String getHost_organizers() {
		return host_organizers;
	}

	public void setHost_organizers(String host_organizers) {
		this.host_organizers = host_organizers;
	}

	public String getOrganizers() {
		return organizers;
	}

	public void setOrganizers(String organizers) {
		this.organizers = organizers;
	}

	public String getCo_organizers() {
		return co_organizers;
	}

	public void setCo_organizers(String co_organizers) {
		this.co_organizers = co_organizers;
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
		result = prime * result + ((co_organizers == null) ? 0 : co_organizers.hashCode());
		result = prime * result + ((committee == null) ? 0 : committee.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((end_time == null) ? 0 : end_time.hashCode());
		result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
		result = prime * result + ((gmt_modified == null) ? 0 : gmt_modified.hashCode());
		result = prime * result + ((host_organizers == null) ? 0 : host_organizers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((organizers == null) ? 0 : organizers.hashCode());
		result = prime * result + ((prizes == null) ? 0 : prizes.hashCode());
		result = prime * result + ((requirements == null) ? 0 : requirements.hashCode());
		result = prime * result + ((start_time == null) ? 0 : start_time.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timetable == null) ? 0 : timetable.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
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
		DesignContestDO other = (DesignContestDO) obj;
		if (co_organizers == null) {
			if (other.co_organizers != null)
				return false;
		} else if (!co_organizers.equals(other.co_organizers))
			return false;
		if (committee == null) {
			if (other.committee != null)
				return false;
		} else if (!committee.equals(other.committee))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (end_time == null) {
			if (other.end_time != null)
				return false;
		} else if (!end_time.equals(other.end_time))
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
		if (host_organizers == null) {
			if (other.host_organizers != null)
				return false;
		} else if (!host_organizers.equals(other.host_organizers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (organizers == null) {
			if (other.organizers != null)
				return false;
		} else if (!organizers.equals(other.organizers))
			return false;
		if (prizes == null) {
			if (other.prizes != null)
				return false;
		} else if (!prizes.equals(other.prizes))
			return false;
		if (requirements == null) {
			if (other.requirements != null)
				return false;
		} else if (!requirements.equals(other.requirements))
			return false;
		if (start_time == null) {
			if (other.start_time != null)
				return false;
		} else if (!start_time.equals(other.start_time))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timetable == null) {
			if (other.timetable != null)
				return false;
		} else if (!timetable.equals(other.timetable))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}

}