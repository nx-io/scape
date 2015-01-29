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
 * 景观规划设计赛事组委会部门成员架构.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午10:48:33
 */
@Entity
@Table(name = "design_match_committee_member", catalog = "scape")
public class DesignMatchCommitteeMemberDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "department_id", nullable = false)
	private Long department_id;//赛事组委会部门ID
	
	@Column(name = "member", nullable = false, length = 64)
	private String member;//赛事组委会部门成员名
	
	@Column(name = "title", nullable = false, length = 64)
	private String title;//赛事组委会部门成员职称
	
	@Column(name = "image", nullable = false, length = 255)
	private String image;//赛事组委会部门成员头像
	
	@Column(name = "profile", nullable = false, length = 256)
	private String profile;//赛事组委会部门成员简介

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = false)
	private Date gmt_modified;
}
