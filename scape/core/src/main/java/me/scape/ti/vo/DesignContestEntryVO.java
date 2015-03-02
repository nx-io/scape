package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.DesignContestEntryDO;
import me.scape.ti.utils.ImageUtils;

import org.springframework.util.CollectionUtils;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午3:31:52
 */
public class DesignContestEntryVO {

	private Integer contest_id;// 赛事ID

	private UserVO user;// 参赛者

	private String title;// 参赛作品标题

	private String description;// 参赛作品简述

	private String attachment;// 参赛作品附件

	private Date gmt_created;

	private List<String> mediaList;

	private Long voteCount;// 投票数

	public static List<DesignContestEntryVO> newInstance(List<DesignContestEntryDO> doList) {
		if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<DesignContestEntryVO> voList = new ArrayList<DesignContestEntryVO>();
		for (DesignContestEntryDO designContestEntry : doList) {
			DesignContestEntryVO vo = newInstance(designContestEntry);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return voList;
	}

	public static DesignContestEntryVO newInstance(DesignContestEntryDO _do) {
		if (_do == null) {
			return null;
		}
		return new DesignContestEntryVO().toDesignContestEntry(_do);
	}

	private final DesignContestEntryVO toDesignContestEntry(DesignContestEntryDO _do) {
		setAttachment(ImageUtils.urlWrapper(_do.getAttachment()));
		setContest_id(_do.getContest_id());
		setDescription(_do.getDescription());
		setGmt_created(_do.getGmt_created());
		setTitle(_do.getTitle());
		return this;
	}

	public Long getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Long voteCount) {
		this.voteCount = voteCount;
	}

	public Integer getContest_id() {
		return contest_id;
	}

	public void setContest_id(Integer contest_id) {
		this.contest_id = contest_id;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
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

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}

	public List<String> getMediaList() {
		return mediaList;
	}

	public void setMediaList(List<String> mediaList) {
		this.mediaList = mediaList;
	}
}