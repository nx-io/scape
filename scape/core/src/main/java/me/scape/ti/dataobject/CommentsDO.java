package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 景观案例评论。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月18日 上午12:12:15
 */
@Entity(name = "ls_comments")
@Table(name = "ls_comments", catalog = "scape")
public class CommentsDO extends BaseDO {

	private static final long serialVersionUID = 1L;
	
    @Column(name = "ref_id", nullable = false)
	private Long ref_id;// 该评论引用的评论ID

    @Column(name = "user_id", nullable = false)
	private Long user_id;// 用户ID, 评论人ID

    @Column(name = "nick", nullable = false, length = 128)
	private String nick;// 冗余的用户昵称

    @Column(name = "stories_id", nullable = false)
	private Long stories_id;// 案例ID

    @Column(name = "comments", nullable = false)
	private String comments;// 评论内容

    @Column(name = "status", nullable = false)
	private Integer status;// 评论状态 默认0表示正常，1表示已经删除

	/**
	 * @return the ref_id
	 */
	public Long getRef_id() {
		return ref_id;
	}

	/**
	 * @param ref_id
	 *            the ref_id to set
	 */
	public void setRef_id(Long ref_id) {
		this.ref_id = ref_id;
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
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
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
}