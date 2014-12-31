package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月31日 下午11:30:32
 */
public class UserFavoriteRequest {

	@NotEmpty
	private Long user_id;// 用户ID

	@NotEmpty
	private Long favorite_id;// 被收藏的用户ID

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(Long favorite_id) {
		this.favorite_id = favorite_id;
	}
}