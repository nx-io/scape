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
 * 新闻、通知.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午10:45:54
 */
@Entity
@Table(name = "news", catalog = "scape")
public class NewsDO implements Serializable {

	private static final long serialVersionUID = 6231946420748426743L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "content", nullable = false, length = 2048)
	private String content;// 内容

	@Column(name = "status", nullable = false)
	private Byte status;// 状态，1:可用，0:不可用，-1:删除

	@Column(name = "type", nullable = false)
	private Byte type;// 类型，1:新闻，2:通知

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = true)
	private Date gmt_modified;
}
