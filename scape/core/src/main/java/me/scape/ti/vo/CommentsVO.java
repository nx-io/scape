package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.CommentsDO;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午5:30:04
 */
public class CommentsVO {

	private Long id;

	private Long ref_id;// 引用的父评论ID

	private Long item_id;// 案例ID

	private Long user_id;// 用户ID, 评论人ID

	private String user_name;// 冗余的设计师/企业名称

	private String content;// 评论内容

	private Byte status;// 状态，1可用，0不可用，-1删除

	private Date gmt_created;
	
	public static CommentsVO newInstance(CommentsDO _do) {
		if(_do == null) {
			return null;
		}
		return new CommentsVO().toComments(_do);
	}
	
	public static List<CommentsVO> newInstance(List<CommentsDO> doList) {
		List<CommentsVO> voList = new ArrayList<CommentsVO>();
		for (CommentsDO commentsDO : doList) {
			CommentsVO vo = newInstance(commentsDO);
			if(vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return voList;
	}
	
	private final CommentsVO toComments(CommentsDO _do) {
		setContent(_do.getContent());
		setGmt_created(_do.getGmt_created());
		setId(_do.getId());
		setItem_id(_do.getItem_id());
		setStatus(_do.getStatus());
		setUser_id(_do.getUser_id());
		setUser_name(_do.getUser_name());
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}
}