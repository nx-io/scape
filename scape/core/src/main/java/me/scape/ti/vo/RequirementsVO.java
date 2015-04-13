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
	
	private UserVO user;
	
	private ProviceVO province;
	
	private CityVO city;
	
	private RegionVO region;
	
	private RequirementsTopCategoryVO top_cat;// 一级分类ID
	
	private RequirementsSecondCategoryVO sec_cat;// 二级分类ID
	
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

	public ProviceVO getProvince() {
		return province;
	}

	public void setProvince(ProviceVO province) {
		this.province = province;
	}

	public CityVO getCity() {
		return city;
	}

	public void setCity(CityVO city) {
		this.city = city;
	}

	public RegionVO getRegion() {
		return region;
	}

	public void setRegion(RegionVO region) {
		this.region = region;
	}

	public RequirementsTopCategoryVO getTop_cat() {
		return top_cat;
	}

	public void setTop_cat(RequirementsTopCategoryVO top_cat) {
		this.top_cat = top_cat;
	}

	public RequirementsSecondCategoryVO getSec_cat() {
		return sec_cat;
	}

	public void setSec_cat(RequirementsSecondCategoryVO sec_cat) {
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