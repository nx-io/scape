package me.scape.ti.ro;

/**
 * 搜索需求信息.
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 上午11:35:31
 */
public class RequirementsSearchRequest extends PageRequest {

	private String title;// 需求信息标题

	private Integer province_id;// 省

	private Integer city_id;// 市

	private Integer region_id;// 区

	private Integer top_cat_id;// 一级分类ID

	private Integer sec_cat_id;// 二级分类ID

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getProvince_id() {
		return province_id;
	}

	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public Integer getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}

	public Integer getTop_cat_id() {
		return top_cat_id;
	}

	public void setTop_cat_id(Integer top_cat_id) {
		this.top_cat_id = top_cat_id;
	}

	public Integer getSec_cat_id() {
		return sec_cat_id;
	}

	public void setSec_cat_id(Integer sec_cat_id) {
		this.sec_cat_id = sec_cat_id;
	}
}