package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 相关展示图片, 视频。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月18日 上午12:41:16
 */
@Entity(name = "ls_stories_avatar")
@Table(name = "ls_stories_avatar", catalog = "scape")
public class StoriesAvatarDO extends BaseDO {

	private static final long serialVersionUID = 1L;

    @Column(name = "stories_id", nullable = false)
	private Long stories_id;// 案例ID

    @Column(name = "avatar", nullable = false, length = 256)
	private String avatar;// 图片, 视频地址

    @Column(name = "status", nullable = false)
	private Integer status;// 评论状态 默认0表示正常，1表示已经删除

    @Column(name = "type", nullable = false)
	private Integer type;// 类型 1:图片, 2:视频

	/**
	 * @return the stories_id
	 */
	public Long getStories_id() {
		return stories_id;
	}

	/**
	 * @param stories_id
	 *            the stories_id to set
	 */
	public void setStories_id(Long stories_id) {
		this.stories_id = stories_id;
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
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
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