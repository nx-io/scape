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
 * 景观规划设计赛事动态.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午10:45:54
 */
@Entity
@Table(name = "design_match_dynamic", catalog = "scape")
public class DesignMatchDynamicDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "match_id", nullable = false)
	private Long match_id;// 赛事ID

	@Column(name = "description", nullable = false, length = 64)
	private String description;// 赛事动态简述

	@Column(name = "content", nullable = false, length = 256)
	private String content;// 赛事动态内容

	@Column(name = "status", nullable = false)
	private Boolean status;// 动态状态 0:删除 1:活跃

	@Column(name = "level", nullable = false)
	private Integer level;// 动态等级 1:表示最新动态 2:次之 以此类推(等级为1最高)

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = false)
	private Date gmt_modified;

}
