package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 设计师信息。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月17日 下午11:47:45
 */
@Entity(name = "ls_designer")
@Table(name = "ls_designer", catalog = "scape")
public class DesignerDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", nullable = false, unique = true)
	private Long user_id;// 用户ID

	@Column(name = "profile", nullable = false, length = 512)
	private String profile;// 个人简介

	@Column(name = "organization", nullable = true, length = 128)
	private String organization;// 组织、团队或者公司名称

	@Column(name = "nick", nullable = false, length = 128)
	private String nick;// 设计师昵称

	/**
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization
	 *            the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick
	 *            the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
}