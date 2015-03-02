package me.scape.ti.vo;


/**
 * 比赛结果.
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午4:14:00
 */
public class DesignContestResultVO {

	private DesignContestEntryVO contestEntry;// 作品

	private Integer ranking;// 参赛作品排名

	private String comment;// 参赛作品评语

	public DesignContestEntryVO getContestEntry() {
		return contestEntry;
	}

	public void setContestEntry(DesignContestEntryVO contestEntry) {
		this.contestEntry = contestEntry;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}