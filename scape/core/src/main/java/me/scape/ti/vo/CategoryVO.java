package me.scape.ti.vo;

import me.scape.ti.dataobject.CategoryDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月28日 上午11:01:39
 */
public class CategoryVO {
	private String name;// 分类名称

	private String description;// 分类描述

	private String icon;// 分类图标

	private Byte display;// 是否展示 1展示 0不展示 -1删除

	private Long id;

	public static CategoryVO newInstance(CategoryDO _do) {
		if (_do == null) {
			return null;
		}
		return new CategoryVO().toCategory(_do);
	}

	private final CategoryVO toCategory(CategoryDO _do) {
		setDescription(_do.getDescription());
		setDisplay(_do.getDisplay());
		setIcon(_do.getIcon());
		setId(_do.getId());
		setName(_do.getName());
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Byte getDisplay() {
		return display;
	}

	public void setDisplay(Byte display) {
		this.display = display;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}