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
 * 景观规划设计赛事通知.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午10:47:12
 */
@Entity
@Table(name = "design_match_notification", catalog = "scape")
public class DesignMatchNotifyDO implements Serializable {

	private static final long serialVersionUID = 1L;

    public static final byte DEFAULT_ALL = -1;
    public static final byte DEFAULT_SOUND  = 1;   // 使用默认提示音提示
    public static final byte DEFAULT_VIBRATE = 2;   // 使用默认震动提示

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "match_id", nullable = false)
	private Long match_id;// 赛事ID
	
	@Column(name = "title", nullable = false, length = 16)
	private String title;// 赛事通知标题

	@Column(name = "description", nullable = false, length = 128)
	private String description;// 赛事通知简述

	@Column(name = "payload", nullable = false, length = 256)
	private String payload;// 赛事通知内容
	
	@Column(name = "notifyType", nullable = false)
	private Byte notifyType;//1:使用默认提示音提示, 2:使用默认震动提示

	@Column(name = "timeToLive", nullable = false)
	private Integer timeToLive;//消息保存时间

	@Column(name = "passThrough", nullable = false)
	private Boolean passThrough;// 透传方式 1表示透传消息，0表示通知栏消息。

	@Column(name = "status", nullable = false)
	private Boolean status;// 通知状态 0:删除 1:活跃

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = false)
	private Date gmt_modified;
}