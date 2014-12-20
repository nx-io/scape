package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 收藏数据。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:03:07
 */
@Entity(name = "ls_collect")
@Table(name = "ls_collect", catalog = "scape")
public class CollectDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", nullable = false)
	private Long user_id;// 用户ID

	@Column(name = "target_id", nullable = false)
	private Long target_id;// 收藏的对象ID

	@Column(name = "type", nullable = false)
	private Integer type;// 收藏类型 1:收藏的案例, 2:收藏的设计师

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
	 * @return the target_id
	 */
	public Long getTarget_id() {
		return target_id;
	}

	/**
	 * @param target_id
	 *            the target_id to set
	 */
	public void setTarget_id(Long target_id) {
		this.target_id = target_id;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
}