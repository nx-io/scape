package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * 景观案例信息。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月17日 下午11:52:23
 */
@Entity
@Table(name = "item", catalog = "scape")
public class ItemDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	@Column(name = "title", nullable = false, length = 64)
	private String title;// 标题

	@Column(name = "type", nullable = false)
	private Byte type;// 1:原创，2:分享

	@Column(name = "category_id", nullable = false)
	private Long category_id;// 景观分类

	@Column(name = "area_category_id", nullable = false)
	private Long area_category_id;// 景观区域分类

	@Column(name = "style_id", nullable = false)
	private Long style_id;// 风格

	@Column(name = "status", nullable = false)
	private Byte status;// 状态，1:可用，0:不可用，-1:删除

	@Lob
	@Column(name = "description")
	private String description;// 案例描述, 过长的话考虑以后放入redis缓存

	@Column(name = "designer", length = 64)
	private String designer;// 设计师

	@Column(name = "designer_contact", length = 64)
	private String designer_contact;// 设计师联系方式

	@Column(name = "constructor", length = 64)
	private String constructor;// 施工者

	@Column(name = "constructor_contact", length = 64)
	private String constructor_contact;// 施工者联系方式

	@Column(name = "cover_media", nullable = false, length = 256)
	private String cover_media;// 案例封皮

	@Column(name = "media_count", nullable = false)
	private Integer media_count;// 案例图片个数

	@Column(name = "comment_count", nullable = false)
	private Integer comment_count;// 评论数

	@Column(name = "praise_count", nullable = false)
	private Integer praise_count;// 赞数

	@Column(name = "like_count", nullable = false)
	private Integer like_count;// 收藏数

	@Column(name = "user_id", nullable = false)
	private Long user_id;// 发布者

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((area_category_id == null) ? 0 : area_category_id.hashCode());
		result = prime * result + ((category_id == null) ? 0 : category_id.hashCode());
		result = prime * result + ((comment_count == null) ? 0 : comment_count.hashCode());
		result = prime * result + ((constructor == null) ? 0 : constructor.hashCode());
		result = prime * result + ((constructor_contact == null) ? 0 : constructor_contact.hashCode());
		result = prime * result + ((cover_media == null) ? 0 : cover_media.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((designer == null) ? 0 : designer.hashCode());
		result = prime * result + ((designer_contact == null) ? 0 : designer_contact.hashCode());
		result = prime * result + ((like_count == null) ? 0 : like_count.hashCode());
		result = prime * result + ((media_count == null) ? 0 : media_count.hashCode());
		result = prime * result + ((praise_count == null) ? 0 : praise_count.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((style_id == null) ? 0 : style_id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDO other = (ItemDO) obj;
		if (area_category_id == null) {
			if (other.area_category_id != null)
				return false;
		} else if (!area_category_id.equals(other.area_category_id))
			return false;
		if (category_id == null) {
			if (other.category_id != null)
				return false;
		} else if (!category_id.equals(other.category_id))
			return false;
		if (comment_count == null) {
			if (other.comment_count != null)
				return false;
		} else if (!comment_count.equals(other.comment_count))
			return false;
		if (constructor == null) {
			if (other.constructor != null)
				return false;
		} else if (!constructor.equals(other.constructor))
			return false;
		if (constructor_contact == null) {
			if (other.constructor_contact != null)
				return false;
		} else if (!constructor_contact.equals(other.constructor_contact))
			return false;
		if (cover_media == null) {
			if (other.cover_media != null)
				return false;
		} else if (!cover_media.equals(other.cover_media))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (designer == null) {
			if (other.designer != null)
				return false;
		} else if (!designer.equals(other.designer))
			return false;
		if (designer_contact == null) {
			if (other.designer_contact != null)
				return false;
		} else if (!designer_contact.equals(other.designer_contact))
			return false;
		if (like_count == null) {
			if (other.like_count != null)
				return false;
		} else if (!like_count.equals(other.like_count))
			return false;
		if (media_count == null) {
			if (other.media_count != null)
				return false;
		} else if (!media_count.equals(other.media_count))
			return false;
		if (praise_count == null) {
			if (other.praise_count != null)
				return false;
		} else if (!praise_count.equals(other.praise_count))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (style_id == null) {
			if (other.style_id != null)
				return false;
		} else if (!style_id.equals(other.style_id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the type
	 */
	public Byte getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Byte type) {
		this.type = type;
	}

	/**
	 * @return the category_id
	 */
	public Long getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id
	 *            the category_id to set
	 */
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return the area_category_id
	 */
	public Long getArea_category_id() {
		return area_category_id;
	}

	/**
	 * @param area_category_id
	 *            the area_category_id to set
	 */
	public void setArea_category_id(Long area_category_id) {
		this.area_category_id = area_category_id;
	}

	/**
	 * @return the style_id
	 */
	public Long getStyle_id() {
		return style_id;
	}

	/**
	 * @param style_id
	 *            the style_id to set
	 */
	public void setStyle_id(Long style_id) {
		this.style_id = style_id;
	}

	/**
	 * @return the status
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the designer
	 */
	public String getDesigner() {
		return designer;
	}

	/**
	 * @param designer
	 *            the designer to set
	 */
	public void setDesigner(String designer) {
		this.designer = designer;
	}

	/**
	 * @return the designer_contact
	 */
	public String getDesigner_contact() {
		return designer_contact;
	}

	/**
	 * @param designer_contact
	 *            the designer_contact to set
	 */
	public void setDesigner_contact(String designer_contact) {
		this.designer_contact = designer_contact;
	}

	/**
	 * @return the constructor
	 */
	public String getConstructor() {
		return constructor;
	}

	/**
	 * @param constructor
	 *            the constructor to set
	 */
	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}

	/**
	 * @return the constructor_contact
	 */
	public String getConstructor_contact() {
		return constructor_contact;
	}

	/**
	 * @param constructor_contact
	 *            the constructor_contact to set
	 */
	public void setConstructor_contact(String constructor_contact) {
		this.constructor_contact = constructor_contact;
	}

	/**
	 * @return the cover_media
	 */
	public String getCover_media() {
		return cover_media;
	}

	/**
	 * @param cover_media
	 *            the cover_media to set
	 */
	public void setCover_media(String cover_media) {
		this.cover_media = cover_media;
	}

	/**
	 * @return the media_count
	 */
	public Integer getMedia_count() {
		return media_count;
	}

	/**
	 * @param media_count
	 *            the media_count to set
	 */
	public void setMedia_count(Integer media_count) {
		this.media_count = media_count;
	}

	/**
	 * @return the comment_count
	 */
	public Integer getComment_count() {
		return comment_count;
	}

	/**
	 * @param comment_count
	 *            the comment_count to set
	 */
	public void setComment_count(Integer comment_count) {
		this.comment_count = comment_count;
	}

	/**
	 * @return the praise_count
	 */
	public Integer getPraise_count() {
		return praise_count;
	}

	/**
	 * @param praise_count
	 *            the praise_count to set
	 */
	public void setPraise_count(Integer praise_count) {
		this.praise_count = praise_count;
	}

	/**
	 * @return the like_count
	 */
	public Integer getLike_count() {
		return like_count;
	}

	/**
	 * @param like_count
	 *            the like_count to set
	 */
	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
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
}