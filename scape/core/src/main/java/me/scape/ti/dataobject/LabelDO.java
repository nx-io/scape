package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 景观案例标签。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月18日 下午11:43:12
 */
@Entity(name = "ls_label")
@Table(name = "ls_label", catalog = "scape")
public class LabelDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false, length = 64, unique = true)
	private String name;// 标签名称

	@Column(name = "description", nullable = true, length = 256)
	private String description;// 标签描述

	@Column(name = "icon", nullable = true, length = 256)
	private String icon;// 标签图标

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
}