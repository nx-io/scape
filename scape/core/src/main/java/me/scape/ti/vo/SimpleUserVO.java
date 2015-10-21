package me.scape.ti.vo;

import me.scape.ti.dataobject.UserDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午7:21:05
 */
public class SimpleUserVO {

	private String name;// 设计师/企业名称

	private String fullname;// 真实姓名

	private String avatar;// 头像

	private String email;// 邮箱

	private String mobile;// 手机

	private String contact;// 联系方式

	private String guid;

	public static SimpleUserVO newInstance(UserDO _do) {
		if (_do == null) {
			return null;
		}
		SimpleUserVO vo = new SimpleUserVO();
		vo.setAvatar(_do.getAvatar());
		vo.setContact(_do.getContact());
		vo.setEmail(_do.getEmail());
		vo.setFullname(_do.getFullname());
		vo.setMobile(_do.getMobile());
		vo.setName(_do.getName());
		vo.setGuid(_do.getGuid());
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
}