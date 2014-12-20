package me.scape.ti.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月17日 下午11:41:04
 */
public class BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	protected Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created")
	protected Date gmt_created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified")
	protected Date gmt_modified;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the gmt_created
	 */
	public Date getGmt_created() {
		return gmt_created;
	}

	/**
	 * @param gmt_created
	 *            the gmt_created to set
	 */
	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}

	/**
	 * @return the gmt_modified
	 */
	public Date getGmt_modified() {
		return gmt_modified;
	}

	/**
	 * @param gmt_modified
	 *            the gmt_modified to set
	 */
	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
}