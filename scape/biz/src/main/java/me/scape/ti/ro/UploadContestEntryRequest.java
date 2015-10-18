package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 上传作品.
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午3:18:50
 */
public class UploadContestEntryRequest extends PrivilegedRequest {

	private static final long serialVersionUID = -2325016562647376117L;

    @NotEmpty
	private Integer contest_id;// 赛事ID

	@NotEmpty
	private String title;// 参赛作品标题

	private String description;// 参赛作品简述

	private String attachment;// 参赛作品附件

	private String mediaList;// 作品图片

	public Integer getContest_id() {
		return contest_id;
	}

	public void setContest_id(Integer contest_id) {
		this.contest_id = contest_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getMediaList() {
		return mediaList;
	}

	public void setMediaList(String mediaList) {
		this.mediaList = mediaList;
	}
}