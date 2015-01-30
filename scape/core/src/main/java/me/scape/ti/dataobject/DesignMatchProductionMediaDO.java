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
 * 景观规划设计赛事参赛作品.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午11:03:23
 */
@Entity
@Table(name = "design_match_production", catalog = "scape")
public class DesignMatchProductionMediaDO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final byte Available = 1;
	public static final byte Strike_out = -1;

	public static final byte IMG = 1;
	public static final byte VIDEO = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "production_id", nullable = false)
	private Long production_id;// 作品ID

	@Column(name = "url", nullable = false, length = 255)
	private String url;// 图片, 视频地址

	@Column(name = "description", nullable = false, length = 512)
	private String description;// 参赛作品图片说明

	@Column(name = "status", nullable = false)
	private Byte status;// 状态， 1:可用， -1:删除

	@Column(name = "type", nullable = false)
	private Byte type;// 类型 1:图片, 2:视频

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = false)
	private Date gmt_modified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduction_id() {
		return production_id;
	}

	public void setProduction_id(Long production_id) {
		this.production_id = production_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}

	public Date getGmt_modified() {
		return gmt_modified;
	}

	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}

	public static byte getStrikeOut() {
		return Strike_out;
	}

	public static byte getVideo() {
		return VIDEO;
	}
}