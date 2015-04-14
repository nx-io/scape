package me.scape.ti.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 需求信息评论。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月18日 上午12:12:15
 */
@Entity
@Table(name = "requirements_comments", catalog = "scape")
public class RequirementsCommentsDO implements Serializable {

	private static final long serialVersionUID = 973425091883987786L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "ref_id", nullable = false)
	private Long ref_id;// 引用的父评论ID

	@Column(name = "requirements_id", nullable = false)
	private Long requirements_id;// 需求信息ID

	@Column(name = "user_id", nullable = false)
	private Long user_id;// 用户ID, 评论人ID

	@Column(name = "user_name", nullable = false, length = 64)
	private String user_name;// 冗余的设计师/企业名称
	
	@Column(name = "avatar", length = 255)
	private String avatar;// 头像

	@Column(name = "content", nullable = false, length = 255)
	private String content;// 评论内容

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

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

	public Long getRequirements_id() {
		return requirements_id;
	}

	public void setRequirements_id(Long requirements_id) {
		this.requirements_id = requirements_id;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ref_id == null) ? 0 : ref_id.hashCode());
		result = prime * result + ((requirements_id == null) ? 0 : requirements_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequirementsCommentsDO other = (RequirementsCommentsDO) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (gmt_created == null) {
			if (other.gmt_created != null)
				return false;
		} else if (!gmt_created.equals(other.gmt_created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ref_id == null) {
			if (other.ref_id != null)
				return false;
		} else if (!ref_id.equals(other.ref_id))
			return false;
		if (requirements_id == null) {
			if (other.requirements_id != null)
				return false;
		} else if (!requirements_id.equals(other.requirements_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}
}