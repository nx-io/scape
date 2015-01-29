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
@Table(name = "design_match_expert_team", catalog = "scape")
public class DesignMatchExpertTeamDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "match_id", nullable = false)
	private Long match_id;//赛事ID
	
	@Column(name = "expert", nullable = false, length = 64)
	private String expert;//赛事专家名
	
	@Column(name = "title", nullable = false, length = 64)
	private String title;//赛事专家职称
	
	@Column(name = "image", nullable = false, length = 255)
	private String image;//赛事专家头像
	
	@Column(name = "profile", nullable = false, length = 1024)
	private String profile;//赛事专家简介

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = false)
	private Date gmt_modified;

}