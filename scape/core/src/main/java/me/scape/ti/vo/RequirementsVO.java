package me.scape.ti.vo;

import java.util.Date;

import me.scape.ti.dataobject.RequirementsDO;
import me.scape.ti.utils.ImageUtils;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 下午1:59:20
 */
public class RequirementsVO {
	
	private Long id;

	private String title;// 需求信息标题

	private String conent;// 需求信息内容

	private UserVO user;// 发布者

	private Integer province_id;// 省
	private String province;

	private Integer city_id;// 市
	private String city;

	private Integer region_id;// 区
	private String region;

	private Integer top_cat_id;// 一级分类ID
	private String top_cat;

	private Integer sec_cat_id;// 二级分类ID
	private String sec_cat;

	private String mobile;// 手机

	private String media;// 图片

	private Date gmt_created;
	
	public static RequirementsVO newInstance(RequirementsDO _do) {
		if(_do == null) {
			return null;
		}
		RequirementsVO requirements = new RequirementsVO();
		requirements.setId(_do.getId());
		requirements.setTitle(_do.getTitle());
		requirements.setConent(_do.getConent());
		requirements.setGmt_created(_do.getGmt_created());
		requirements.setMedia(ImageUtils.urlWrapper(_do.getMedia()));
		requirements.setMobile(_do.getMobile());
		requirements.setCity(_do.getCity());
		requirements.setCity_id(_do.getCity_id());
		requirements.setProvince(_do.getProvince());
		requirements.setProvince_id(_do.getProvince_id());
		requirements.setRegion(_do.getRegion());
		requirements.setRegion_id(_do.getRegion_id());
		requirements.setSec_cat(_do.getSec_cat());
		requirements.setSec_cat_id(_do.getSec_cat_id());
		requirements.setTop_cat(_do.getTop_cat());
		requirements.setTop_cat_id(_do.getTop_cat_id());
		return requirements;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public Integer getProvince_id() {
		return province_id;
	}

	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getTop_cat_id() {
		return top_cat_id;
	}

	public void setTop_cat_id(Integer top_cat_id) {
		this.top_cat_id = top_cat_id;
	}

	public String getTop_cat() {
		return top_cat;
	}

	public void setTop_cat(String top_cat) {
		this.top_cat = top_cat;
	}

	public Integer getSec_cat_id() {
		return sec_cat_id;
	}

	public void setSec_cat_id(Integer sec_cat_id) {
		this.sec_cat_id = sec_cat_id;
	}

	public String getSec_cat() {
		return sec_cat;
	}

	public void setSec_cat(String sec_cat) {
		this.sec_cat = sec_cat;
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

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}
}