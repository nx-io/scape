package me.scape.ti.vo;

import me.scape.ti.dataobject.RequirementsSecondCategoryDO;


/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 下午3:20:34
 */
public class RequirementsSecondCategoryVO {

	private Integer id;

	private RequirementsTopCategoryVO top_cat;// 一级分类ID

	private String name;// 二级分类名称
	
	public static RequirementsSecondCategoryVO newInstance(RequirementsSecondCategoryDO category) {
		if(category == null) {
			return null;
		}
		RequirementsSecondCategoryVO vo = new RequirementsSecondCategoryVO();
		vo.setId(category.getId());
		vo.setName(category.getName());
		return vo;
	}
	
	public RequirementsSecondCategoryVO topCategory(RequirementsTopCategoryVO category) {
		setTop_cat(category);
		return this;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RequirementsTopCategoryVO getTop_cat() {
		return top_cat;
	}

	public void setTop_cat(RequirementsTopCategoryVO top_cat) {
		this.top_cat = top_cat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
