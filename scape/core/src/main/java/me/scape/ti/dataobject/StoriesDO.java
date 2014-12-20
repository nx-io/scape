package me.scape.ti.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 景观案例信息。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月17日 下午11:52:23
 */
@Entity(name = "ls_stories")
@Table(name = "ls_stories", catalog = "scape")
public class StoriesDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	@Column(name = "designer_id", nullable = false)
	private Long designer_id;// 设计师ID

	@Column(name = "category_id", nullable = false)
	private Long category_id;// 案例场景, 景观分类

	@Column(name = "area_category_id", nullable = false)
	private Long area_category_id;// 景观区域分类

	@Column(name = "label_id", nullable = false)
	private Long label_id;// 景观案例标签

	@Column(name = "avatar", nullable = false, length = 256)
	private String avatar;// 项目首图冗余

	@Column(name = "avatar_count", nullable = false)
	private Integer avatar_count;// 项目展示图片个数

	@Column(name = "description", nullable = true, length = 1024)
	private String description;// 案例描述, 过长的话考虑以后放入redis缓存

	@Column(name = "comment_count", nullable = false)
	private Long comment_count;// 评论数

	@Column(name = "praise_count", nullable = false)
	private Long praise_count;// 赞数

	/**
	 * @return the comment_count
	 */
	public Long getComment_count() {
		return comment_count;
	}

	/**
	 * @param comment_count
	 *            the comment_count to set
	 */
	public void setComment_count(Long comment_count) {
		this.comment_count = comment_count;
	}

	/**
	 * @return the praise_count
	 */
	public Long getPraise_count() {
		return praise_count;
	}

	/**
	 * @param praise_count
	 *            the praise_count to set
	 */
	public void setPraise_count(Long praise_count) {
		this.praise_count = praise_count;
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
	 * @return the label_id
	 */
	public Long getLabel_id() {
		return label_id;
	}

	/**
	 * @param label_id
	 *            the label_id to set
	 */
	public void setLabel_id(Long label_id) {
		this.label_id = label_id;
	}

	/**
	 * @return the designer_id
	 */
	public Long getDesigner_id() {
		return designer_id;
	}

	/**
	 * @param designer_id
	 *            the designer_id to set
	 */
	public void setDesigner_id(Long designer_id) {
		this.designer_id = designer_id;
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
	 * @return the avatar_count
	 */
	public Integer getAvatar_count() {
		return avatar_count;
	}

	/**
	 * @param avatar_count
	 *            the avatar_count to set
	 */
	public void setAvatar_count(Integer avatar_count) {
		this.avatar_count = avatar_count;
	}
}