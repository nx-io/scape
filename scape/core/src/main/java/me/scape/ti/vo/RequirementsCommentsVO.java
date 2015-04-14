package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.RequirementsCommentsDO;
import me.scape.ti.utils.ImageUtils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月14日 下午10:45:16
 */
public class RequirementsCommentsVO {
	
	private Long id;

	private Long user_id;// 用户ID, 评论人ID

	private String user_name;// 冗余的设计师/企业名称
	
	private String avatar;// 头像

	private String content;// 评论内容

	private Date gmt_created;
	
	private List<RequirementsCommentsVO> childComments;
	
	public static RequirementsCommentsVO newInstance(RequirementsCommentsDO comments) {
		if(comments == null) {
			return null;
		}
		RequirementsCommentsVO vo = new RequirementsCommentsVO();
		vo.setContent(comments.getContent());
		vo.setGmt_created(comments.getGmt_created());
		vo.setId(comments.getId());
		vo.setUser_id(comments.getUser_id());
		vo.setUser_name(comments.getUser_name());
		vo.setAvatar(ImageUtils.urlWrapper(comments.getAvatar()));
		return vo;
	}

	public static List<RequirementsCommentsVO> newInstance(List<RequirementsCommentsDO> doList) {
		List<RequirementsCommentsVO> voList = new ArrayList<RequirementsCommentsVO>();
		for (RequirementsCommentsDO comments : doList) {
			RequirementsCommentsVO vo = newInstance(comments);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return voList;
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

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}

	public List<RequirementsCommentsVO> getChildComments() {
		return childComments;
	}

	public void setChildComments(List<RequirementsCommentsVO> childComments) {
		this.childComments = childComments;
	}
}