package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.scape.ti.dataobject.DesignContestJudgesDO;
import me.scape.ti.utils.ImageUtils;

import org.springframework.util.CollectionUtils;


/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:50:44
 */
public class DesignContestJudgesVO {

	private String name;// 姓名

	private String title;// 职称

	private String avatar;// 头像

	private String profile;// 简介
	
	public static List<DesignContestJudgesVO> newInstance(List<DesignContestJudgesDO> doList) {
		if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<DesignContestJudgesVO> voList = new ArrayList<DesignContestJudgesVO>();
		for (DesignContestJudgesDO designContestJudges : doList) {
			DesignContestJudgesVO vo = newInstance(designContestJudges);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return voList;
	}
	
	public static DesignContestJudgesVO newInstance(DesignContestJudgesDO _do) {
		if (_do == null) {
			return null;
		}
		return new DesignContestJudgesVO().toDesignContestJudges(_do);
	}

	private final DesignContestJudgesVO toDesignContestJudges(DesignContestJudgesDO _do) {
		setAvatar(ImageUtils.urlWrapper(_do.getAvatar()));
		setName(_do.getName());
		setProfile(_do.getProfile());
		setTitle(_do.getTitle());
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}