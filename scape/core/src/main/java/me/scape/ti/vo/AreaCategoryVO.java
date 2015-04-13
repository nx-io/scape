package me.scape.ti.vo;

import me.scape.ti.dataobject.AreaCategoryDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月28日 上午11:00:00
 */
public class AreaCategoryVO {
	private String name;// 区域分类名称

	private String description;// 区域分类描述

	private String icon;// 区域分类图标

	private Byte display;// 是否展示 1展示 0不展示 -1删除

	private Long id;

	public static AreaCategoryVO newInstance(AreaCategoryDO _do) {
		if (_do == null) {
			return null;
		}
		AreaCategoryVO vo = new AreaCategoryVO();
		vo.setDescription(_do.getDescription());
		vo.setDisplay(_do.getDisplay());
		vo.setIcon(_do.getIcon());
		vo.setId(_do.getId());
		vo.setName(_do.getName());
		return vo;
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