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
 * 景观规划设计赛事专家团队.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午11:01:28
 */
@Entity
@Table(name = "design_contest_judges", catalog = "scape")
public class DesignContestJudgesDO implements Serializable {

	private static final long serialVersionUID = 3583788182271951731L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "match_id", nullable = false)
	private Integer match_id;// 赛事ID

	@Column(name = "name", nullable = false, length = 64)
	private String name;// 姓名

	@Column(name = "title", nullable = false, length = 64)
	private String title;// 职称

	@Column(name = "avatar", nullable = false, length = 255)
	private String avatar;// 头像

	@Column(name = "profile", nullable = false, length = 1024)
	private String profile;// 简介

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = true)
	private Date gmt_modified;
}