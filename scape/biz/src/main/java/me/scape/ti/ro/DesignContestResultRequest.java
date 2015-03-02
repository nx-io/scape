package me.scape.ti.ro;

/**
 * 设置比赛结果.
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午4:11:24
 */
public class DesignContestResultRequest {

	private Integer contest_id;// 赛事ID

	private Integer entry_id;// 作品ID

	private Integer ranking;// 参赛作品排名

	private String comment;// 参赛作品评语

	public Integer getContest_id() {
		return contest_id;
	}

	public void setContest_id(Integer contest_id) {
		this.contest_id = contest_id;
	}

	public Integer getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(Integer entry_id) {
		this.entry_id = entry_id;
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