package me.scape.ti.ro;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 发布新的需求信息.
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 上午11:35:31
 */
public class PublishRequirementsRequest extends PrivilegedRequest {

	private static final long serialVersionUID = 8433629238227391557L;

    @NotEmpty
	private String title;// 需求信息标题

	private String conent;// 需求信息内容

	@NotNull
	private Integer province_id;// 省

	@NotNull
	private Integer city_id;// 市

	private Integer region_id;// 区

	@NotNull
	private Integer top_cat_id;// 一级分类ID

	@NotNull
	private Integer sec_cat_id;// 二级分类ID

	@NotEmpty
	private String mobile;// 手机

	private String media;// 图片

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConent() {
		return conent;
	}

	public void setConent(String conent) {
		this.conent = conent;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}
}