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
@Table(name = "design_match", catalog = "scape")
public class DesignMatchDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "question", nullable = true, length = 512)
	private String question;// 大赛题目

	@Column(name = "question_require", nullable = true, length = 1024)
	private String question_require;// 大赛题目要求

	@Column(name = "process", nullable = true, length = 1024)
	private String process;// 大赛流程

	@Column(name = "prize", nullable = true, length = 2048)
	private String prize;// 大赛奖项设置

	@Column(name = "production_require", nullable = true, length = 2048)
	private String production_require;// 大赛作品要求

	@Column(name = "background", nullable = true, length = 2048)
	private String background;// 大赛背景

	@Column(name = "importance", nullable = true, length = 2048)
	private String importance;// 大赛意义

	@Column(name = "status", nullable = false)
	private Byte status;// 大赛的进度状态
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time", nullable = false)
	private Date start_time;//比赛开始时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time", nullable = false)
	private Date end_time;//比赛结束时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = false)
	private Date gmt_modified;
}