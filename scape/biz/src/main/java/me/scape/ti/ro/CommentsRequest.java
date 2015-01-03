package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 评论请求
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午3:33:06
 */
public class CommentsRequest {
	private Long ref_id;// 引用的父评论ID

	@NotEmpty
	private Long item_id;// 案例ID

	@NotEmpty
	private Long user_id;// 用户ID, 评论人ID

	@NotEmpty
	private String user_name;// 冗余的设计师/企业名称

	@NotEmpty
	private String content;// 评论内容

	public Long getRef_id() {
		return ref_id;
	}

	public void setRef_id(Long ref_id) {
		this.ref_id = ref_id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}