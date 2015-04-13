package me.scape.ti.vo;

import me.scape.ti.dataobject.RequirementsTopCategoryDO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 下午3:14:04
 */
public class RequirementsTopCategoryVO {
	private Integer id;

	private String name;// 一级分类名称
	
	public static RequirementsTopCategoryVO newInstance(RequirementsTopCategoryDO category) {
		if(category == null) {
			return null;
		}
		RequirementsTopCategoryVO vo = new RequirementsTopCategoryVO();
		vo.setId(category.getId());
		vo.setName(category.getName());
		return vo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}