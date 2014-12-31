package me.scape.ti.vo;

import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.ItemDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月28日 上午12:33:35
 */
public class ItemVO {

	private Long id;

	private String title;// 标题

	private Byte type;// 1:原创，2:分享

	private Long category_id;// 景观分类

	private Long area_category_id;// 景观区域分类

	private Long style_id;// 风格

	private Byte status;// 状态，1:可用，0:不可用，-1:删除

	private String description;// 案例描述, 过长的话考虑以后放入redis缓存

	private String designer;// 设计师

	private String designer_contact;// 设计师联系方式

	private String constructor;// 施工者

	private String constructor_contact;// 施工者联系方式

	private String cover_media;// 案例封皮

	private Integer media_count;// 案例图片个数

	private Integer comment_count;// 评论数

	private Integer praise_count;// 赞数

	private Integer like_count;// 收藏数

	private Long user_id;// 发布者

	private Date gmt_created;

	private List<ItemMediaVO> itemMediaList;

	private List<LabelVO> labelList;
	
	private AreaCategoryVO areaCategory;
	private CategoryVO category;
	private StyleVO style;
	
	public static ItemVO newInstance(ItemDO _do) {
		if(_do == null) {
			return null;
		}
		return new ItemVO().toItem(_do);
	}
	
	private final ItemVO toItem(ItemDO _do) {
		setId(_do.getId());
		setTitle(_do.getTitle());
		setType(_do.getType());
		setCategory_id(_do.getCategory_id());
		setArea_category_id(_do.getArea_category_id());
		setStyle_id(_do.getStyle_id());
		setStatus(_do.getStatus());
		setDescription(_do.getDescription());
		setDesigner(_do.getDesigner());
		setDesigner_contact(_do.getDesigner_contact());
		setConstructor(_do.getConstructor());
		setConstructor_contact(_do.getConstructor_contact());
		setCover_media(_do.getCover_media());
		setMedia_count(_do.getMedia_count());
		setComment_count(_do.getComment_count());
		setPraise_count(_do.getPraise_count());
		setLike_count(_do.getLike_count());
		setUser_id(_do.getUser_id());
		setGmt_created(_do.getGmt_created());
		return this;
	}
	
	public List<LabelVO> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<LabelVO> labelList) {
		this.labelList = labelList;
	}

	public StyleVO getStyle() {
		return style;
	}

	public void setStyle(StyleVO style) {
		this.style = style;
	}

	public AreaCategoryVO getAreaCategory() {
		return areaCategory;
	}

	public void setAreaCategory(AreaCategoryVO areaCategory) {
		this.areaCategory = areaCategory;
	}

	public CategoryVO getCategory() {
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public Long getArea_category_id() {
		return area_category_id;
	}

	public void setArea_category_id(Long area_category_id) {
		this.area_category_id = area_category_id;
	}

	public Long getStyle_id() {
		return style_id;
	}

	public void setStyle_id(Long style_id) {
		this.style_id = style_id;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getDesigner_contact() {
		return designer_contact;
	}

	public void setDesigner_contact(String designer_contact) {
		this.designer_contact = designer_contact;
	}

	public String getConstructor() {
		return constructor;
	}

	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}

	public String getConstructor_contact() {
		return constructor_contact;
	}

	public void setConstructor_contact(String constructor_contact) {
		this.constructor_contact = constructor_contact;
	}

	public String getCover_media() {
		return cover_media;
	}

	public void setCover_media(String cover_media) {
		this.cover_media = cover_media;
	}

	public Integer getMedia_count() {
		return media_count;
	}

	public void setMedia_count(Integer media_count) {
		this.media_count = media_count;
	}

	public Integer getComment_count() {
		return comment_count;
	}

	public void setComment_count(Integer comment_count) {
		this.comment_count = comment_count;
	}

	public Integer getPraise_count() {
		return praise_count;
	}

	public void setPraise_count(Integer praise_count) {
		this.praise_count = praise_count;
	}

	public Integer getLike_count() {
		return like_count;
	}

	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}

	public List<ItemMediaVO> getItemMediaList() {
		return itemMediaList;
	}

	public void setItemMediaList(List<ItemMediaVO> itemMediaList) {
		this.itemMediaList = itemMediaList;
	}
}