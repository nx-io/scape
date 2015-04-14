package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.CommentsDO;
import me.scape.ti.utils.ImageUtils;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午5:30:04
 */
public class CommentsVO {

	private Long id;

	private Long item_id;// 案例ID

	private String user_name;// 冗余的设计师/企业名称
	
	private String avatar;// 头像

	private String content;// 评论内容

	private Date gmt_created;
	
	private List<CommentsVO> childComments;

	public static CommentsVO newInstance(CommentsDO _do) {
		if (_do == null) {
			return null;
		}
		CommentsVO vo = new CommentsVO();
		vo.setContent(_do.getContent());
		vo.setGmt_created(_do.getGmt_created());
		vo.setId(_do.getId());
		vo.setItem_id(_do.getItem_id());
		vo.setUser_name(_do.getUser_name());
		vo.setAvatar(ImageUtils.urlWrapper(_do.getAvatar()));
		return vo;
	}

	public static List<CommentsVO> newInstance(List<CommentsDO> doList) {
		List<CommentsVO> voList = new ArrayList<CommentsVO>();
		for (CommentsDO commentsDO : doList) {
			CommentsVO vo = newInstance(commentsDO);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return voList;
	}

	public List<CommentsVO> getChildComments() {
		return childComments;
	}

	public void setChildComments(List<CommentsVO> childComments) {
		this.childComments = childComments;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
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

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}
}