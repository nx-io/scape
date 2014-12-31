package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 收藏/赞景观请求
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午5:59:29
 */
public class ItemFavoriteRequest {
	
	@NotEmpty
	private Long user_id;// 用户ID

	@NotEmpty
	private Long item_id;// 案例ID

	@NotEmpty
	private Byte type;// 1:赞，2:收藏

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}
}