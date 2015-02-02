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
 * 景观规划设计赛事.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午10:30:02
 */
@Entity
@Table(name = "design_contest", catalog = "scape")
public class DesignContestDO implements Serializable {

	private static final long serialVersionUID = -4286930921212697495L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "title", nullable = false)
	private String title;// 大赛标题

	@Column(name = "description", nullable = false)
	private String description;// 大赛简介

	@Column(name = "topic", nullable = false)
	private String topic;// 大赛题目

	@Column(name = "requirements", nullable = false)
	private String requirements;// 大赛要求

	@Column(name = "timetable", nullable = false)
	private String timetable;// 大赛流程

	@Column(name = "prizes", nullable = false)
	private String prizes;// 奖项设置

	@Column(name = "committee", nullable = false)
	private String committee;// 组委会

	@Column(name = "organizers", nullable = false)
	private String organizers;// 承办、主办、协办

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

}