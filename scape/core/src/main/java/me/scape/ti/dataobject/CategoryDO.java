package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 案例场景, 景观分类。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月18日 下午10:33:37
 */
@Entity(name = "ls_category")
@Table(name = "ls_category", catalog = "scape")
public class CategoryDO extends BaseDO {

	private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false, length = 64, unique = true)
	private String name;// 分类名称
    
    @Column(name = "description", nullable = true, length = 256)
	private String description;// 分类描述
    
    @Column(name = "icon", nullable = true, length = 256)
	private String icon;// 分类图标

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