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
 * 景观规划设计赛事组委会部门架构.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午10:48:33
 */
@Entity
@Table(name = "design_match_committee_member", catalog = "scape")
public class DesignMatchCommitteeDepartmentDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "match_id", nullable = false)
	private Long match_id;//赛事ID

	@Column(name = "department_name", nullable = false, length = 64)
	private String department_name;//赛事组委会部门名称
	
	@Column(name = "department_description", nullable = false, length = 128)
	private String department_description;// 赛事组委会部门简述

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = false)
	private Date gmt_modified;
}
