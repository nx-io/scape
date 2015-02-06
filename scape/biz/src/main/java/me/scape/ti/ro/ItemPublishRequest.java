package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 案例发布请求.
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月28日 上午11:55:04
 */
public class ItemPublishRequest extends BaseRequest {

	@NotEmpty
	private String title;// 标题

	private Byte type;// 1:原创，2:分享

	@NotEmpty
	private Long category_id;// 景观分类

	@NotEmpty
	private Long area_category_id;// 景观区域分类

	@NotEmpty
	private Long style_id;// 风格

	private String description;// 案例描述, 过长的话考虑以后放入redis缓存

	private String designer;// 设计师

	private String designer_contact;// 设计师联系方式

	private String constructor;// 施工者

	private String constructor_contact;// 施工者联系方式

	private String itemMedias;// 图片组，以,分割

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

	public String getItemMedias() {
		return itemMedias;
	}

	public void setItemMedias(String itemMedias) {
		this.itemMedias = itemMedias;
	}
}