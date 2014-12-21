package me.scape.ti.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 管理员。
 * 
 * @author WangJianZheng E-mail:zing.wang@look.com
 * @version 1.0.0
 * @since 2014年12月21日 上午01:30:00
 */
@Entity
@Table(name = "manager", catalog = "scape")
public class ManagerDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false)
	private String name;// 用户名

	@Column(name = "email", unique = true, nullable = false)
	private String email;// 邮箱/账号

	@Column(name = "avatar")
	private String avatar;// 头像

	@Column(name = "status", nullable = false)
	private Byte status;// 状态，1:可用，0:不可用，-1:删除

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login")
	private Date last_login;// 最后一次登录的时间

	@Column(name = "last_ip", nullable = false)
	private long last_ip;// 最后一次登录的IP

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (last_ip ^ (last_ip >>> 32));
		result = prime * result + ((last_login == null) ? 0 : last_login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManagerDO other = (ManagerDO) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (last_ip != other.last_ip)
			return false;
		if (last_login == null) {
			if (other.last_login != null)
				return false;
		} else if (!last_login.equals(other.last_login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
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
	 * @return the status
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * @return the last_login
	 */
	public Date getLast_login() {
		return last_login;
	}

	/**
	 * @param last_login
	 *            the last_login to set
	 */
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	/**
	 * @return the last_ip
	 */
	public long getLast_ip() {
		return last_ip;
	}

	/**
	 * @param last_ip
	 *            the last_ip to set
	 */
	public void setLast_ip(long last_ip) {
		this.last_ip = last_ip;
	}
}