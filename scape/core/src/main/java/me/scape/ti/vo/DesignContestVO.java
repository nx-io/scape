package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.DesignContestDO;

import org.springframework.util.CollectionUtils;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:20:30
 */
public class DesignContestVO {

	private Integer id;

	private String title;// 大赛标题

	private String description;// 大赛简介

	private String topic;// 大赛题目

	private String requirements;// 大赛要求

	private String timetable;// 大赛流程

	private String prizes;// 奖项设置

	private String committee;// 组委会

	private String host_organizers;// 主办

	private String organizers;// 承办

	private String co_organizers;// 协办

	private Byte status;// 状态

	private Date start_time;// 开始时间

	private Date end_time;// 结束时间
	
	public static List<DesignContestVO> newInstance(List<DesignContestDO> doList) {
		if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<DesignContestVO> voList = new ArrayList<DesignContestVO>();
		for (DesignContestDO designContest : doList) {
			DesignContestVO vo = newInstance(designContest);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return voList;
	}
	
	public static DesignContestVO newInstance(DesignContestDO _do) {
		if (_do == null) {
			return null;
		}
		return new DesignContestVO().toDesignContest(_do);
	}

	private final DesignContestVO toDesignContest(DesignContestDO _do) {
		setCo_organizers(_do.getCo_organizers());
		setCommittee(_do.getCommittee());
		setDescription(_do.getDescription());
		setEnd_time(_do.getEnd_time());
		setHost_organizers(_do.getHost_organizers());
		setId(_do.getId());
		setOrganizers(_do.getOrganizers());
		setPrizes(_do.getPrizes());
		setRequirements(_do.getRequirements());
		setStart_time(_do.getStart_time());
		setStatus(_do.getStatus());
		setTimetable(_do.getTimetable());
		setTitle(_do.getTitle());
		setTopic(_do.getTopic());
		return this;
	}

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
}