package me.scape.ti.vo;

import me.scape.ti.dataobject.StyleDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月28日 上午11:03:21
 */
public class StyleVO {
	private String name;// 风格名称

	private String description;// 风格描述

	private String icon;// 风格图标

	private Byte display;// 是否展示

	private Long id;

	public static StyleVO newInstance(StyleDO _do) {
		if (_do == null) {
			return null;
		}
		StyleVO vo = new StyleVO();
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