package me.scape.ti.ro;

import javax.validation.constraints.NotNull;

/**
 * 读取比赛作品.
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午3:46:20
 */
public class ContestEntryRequest extends NonPrivilegedPageRequest {

	private static final long serialVersionUID = 8631184699842185894L;
	@NotNull
	private Integer contestId;

	public Integer getContestId() {
		return contestId;
	}

	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
}