package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 管理员拥有的角色。
 * 
 * @author WangJianZheng E-mail:zing.wang@look.com
 * @version 1.0.0
 * @since 2014年12月21日 上午01:30:00
 */
@Entity
@Table(name = "manager_roles", catalog = "scape")
public class ManagerRolesDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	@Column(name = "manager_id", nullable = false)
	private Long manager_id;

	@Column(name = "role_id", nullable = false)
	private Long role_id;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((manager_id == null) ? 0 : manager_id.hashCode());
		result = prime * result + ((role_id == null) ? 0 : role_id.hashCode());
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
		ManagerRolesDO other = (ManagerRolesDO) obj;
		if (manager_id == null) {
			if (other.manager_id != null)
				return false;
		} else if (!manager_id.equals(other.manager_id))
			return false;
		if (role_id == null) {
			if (other.role_id != null)
				return false;
		} else if (!role_id.equals(other.role_id))
			return false;
		return true;
	}

	/**
	 * @return the manager_id
	 */
	public Long getManager_id() {
		return manager_id;
	}

	/**
	 * @param manager_id
	 *            the manager_id to set
	 */
	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}

	/**
	 * @return the role_id
	 */
	public Long getRole_id() {
		return role_id;
	}

	/**
	 * @param role_id
	 *            the role_id to set
	 */
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
}
