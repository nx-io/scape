package me.scape.ti.vo;

import java.util.Date;

import me.scape.ti.dataobject.UserDO;
import me.scape.ti.utils.WebUtils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午7:21:05
 */
public class TalentsVO {
	
	private String guid;

	private String name;// 设计师/企业名称

	private String fullname;// 真实姓名

	private Byte status;// 状态，1:可用，0:不可用，-1:删除

	private String avatar;// 头像

	private String email;// 邮箱

	private String mobile;// 手机

	private String contact;// 联系方式

	private Long category_id;// 特长

	private String profile;// 简介

	private Boolean is_email_verified;// 邮箱是否验证

	private Boolean is_mobile_verified;// 手机是否验证

	private Date last_login;// 最后一次登录的时间

	private String last_ip;// 最后一次登录的IP

	private Date gmt_created;

	private Integer province_id;// 省

	private String province;

	private Integer city_id;// 市

	private String city;

	private Long attention_count;

	private Long item_count;

	public static TalentsVO newInstance(UserDO _do) {
		if (_do == null) {
			return null;
		}
		TalentsVO vo = new TalentsVO();
		vo.setGuid(_do.getGuid());
		vo.setAvatar(_do.getAvatar());
		vo.setCategory_id(_do.getCategory_id());
		vo.setContact(_do.getContact());
		vo.setEmail(_do.getEmail());
		vo.setFullname(_do.getFullname());
		vo.setGmt_created(_do.getGmt_created());
		vo.setIs_email_verified(_do.getIs_email_verified());
		vo.setIs_mobile_verified(_do.getIs_mobile_verified());
		vo.setLast_ip(WebUtils.lngToIp(_do.getLast_ip()));
		vo.setLast_login(_do.getLast_login());
		vo.setMobile(_do.getMobile());
		vo.setName(_do.getName());
		vo.setProfile(_do.getProfile());
		vo.setStatus(_do.getStatus());
		vo.setProvince_id(_do.getProvince_id());
		vo.setProvince(_do.getProvince());
		vo.setCity_id(_do.getCity_id());
		vo.setCity(_do.getCity());
		return vo;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Boolean getIs_email_verified() {
		return is_email_verified;
	}

	public void setIs_email_verified(Boolean is_email_verified) {
		this.is_email_verified = is_email_verified;
	}

	public Boolean getIs_mobile_verified() {
		return is_mobile_verified;
	}

	public void setIs_mobile_verified(Boolean is_mobile_verified) {
		this.is_mobile_verified = is_mobile_verified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public String getLast_ip() {
		return last_ip;
	}

	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
	}

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
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

	public Long getAttention_count() {
		return attention_count;
	}

	public void setAttention_count(Long attention_count) {
		this.attention_count = attention_count;
	}

	public Long getItem_count() {
		return item_count;
	}

	public void setItem_count(Long item_count) {
		this.item_count = item_count;
	}
}