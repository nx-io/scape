package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 收藏的用户。
 * 
 * @author WangJianZheng E-mail:zing.wang@look.com
 * @version 1.0.0
 * @since 2014年12月21日 上午01:30:00
 */
@Entity
@Table(name = "user_favorite", catalog = "scape")
public class UserFavoriteDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", nullable = false)
	private Long user_id;// 用户ID

	@Column(name = "favorite_id", nullable = false)
	private Long favorite_id;// 被收藏的用户ID

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((favorite_id == null) ? 0 : favorite_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		UserFavoriteDO other = (UserFavoriteDO) obj;
		if (favorite_id == null) {
			if (other.favorite_id != null)
				return false;
		} else if (!favorite_id.equals(other.favorite_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

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
	 * @return the favorite_id
	 */
	public Long getFavorite_id() {
		return favorite_id;
	}

	/**
	 * @param favorite_id
	 *            the favorite_id to set
	 */
	public void setFavorite_id(Long favorite_id) {
		this.favorite_id = favorite_id;
	}
}