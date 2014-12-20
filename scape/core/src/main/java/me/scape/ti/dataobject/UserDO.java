package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户信息。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月17日 下午11:55:39
 */
@Entity(name = "ls_user")
@Table(name = "ls_user", catalog = "scape")
public class UserDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	@Column(name = "nick", nullable = false, length = 128)
	private String nick;// 昵称

	@Column(name = "name", nullable = false, length = 128)
	private String name;// 真实姓名

	@Column(name = "avatar", nullable = false, length = 256)
	private String avatar;// 头像

	@Column(name = "passwd", nullable = false, length = 256)
	private String passwd;

	@Column(name = "email", nullable = true, length = 64)
	private String email;

	@Column(name = "mobile", nullable = true, length = 64)
	private String mobile;

	@Column(name = "phone", nullable = true, length = 64)
	private String phone;

	@Column(name = "weixin", nullable = true, length = 128)
	private String weixin;

	@Column(name = "idNo", nullable = true, length = 128)
	private String idNo;// 身份证号

	@Column(name = "address", nullable = true, length = 512)
	private String address;// 地址

	@Column(name = "province", nullable = true, length = 64)
	private String province;// 所在省

	@Column(name = "city", nullable = true, length = 64)
	private String city;// 所在市

	@Column(name = "extend", nullable = true, length = 512)
	private String extend;// 扩展信息

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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar
	 *            the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the weixin
	 */
	public String getWeixin() {
		return weixin;
	}

	/**
	 * @param weixin
	 *            the weixin to set
	 */
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	/**
	 * @return the idNo
	 */
	public String getIdNo() {
		return idNo;
	}

	/**
	 * @param idNo
	 *            the idNo to set
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the extend
	 */
	public String getExtend() {
		return extend;
	}

	/**
	 * @param extend
	 *            the extend to set
	 */
	public void setExtend(String extend) {
		this.extend = extend;
	}
}