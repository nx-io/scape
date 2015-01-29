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
 * 景观规划设计赛事举办单位.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午10:52:19
 */
@Entity
@Table(name = "design_match_organizers", catalog = "scape")
public class DesignMatchOrganizersDO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final byte HoOrganizerType = 1;// 举办单位
	public static final byte MoOrganizerType = 2;// 主办单位
	public static final byte CoOrganizerType = 3;// 协办单位

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "match_id", nullable = false)
	private Long match_id;// 赛事ID

	@Column(name = "type", nullable = false)
	private Byte type;// 1:举办单位 2:主办单位 3:协办单位

	@Column(name = "organizer", nullable = false, length = 64)
	private String organizer;// 赛事举办单位名

	@Column(name = "icon", nullable = false, length = 255)
	private String icon;// 赛事举办单位图标

	@Column(name = "profile", nullable = false, length = 1024)
	private String profile;// 赛事举办单位简介

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = false)
	private Date gmt_modified;
}