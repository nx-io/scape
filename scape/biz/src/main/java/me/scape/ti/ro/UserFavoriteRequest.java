package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月31日 下午11:30:32
 */
public class UserFavoriteRequest extends PrivilegedRequest {

	private static final long serialVersionUID = 5894736402154429732L;
    @NotEmpty
	private Long favorite_id;// 被收藏的用户ID

	public Long getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(Long favorite_id) {
		this.favorite_id = favorite_id;
	}
}