package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.ro.ContestEntryRequest;
import me.scape.ti.ro.ContestEntryVoteRequest;
import me.scape.ti.ro.DesignContestResultRequest;
import me.scape.ti.ro.JoinDesignContestRequest;
import me.scape.ti.ro.UploadContestEntryRequest;

/**
 * 赛事相关业务.
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:18:39
 */
public interface DesignContestService {
	
	/**
	 * 设置比赛结果
	 */
	Result setDesignContestResult(DesignContestResultRequest request);
	
	/**
	 * 获取比赛结果
	 */
	Result getDesignContestResult(Integer contestId);
	
	/**
	 * 参加比赛
	 */
	Result joinDesignContest(JoinDesignContestRequest request);

	/**
	 * 获取正在进行的比赛信息
	 */
	Result getActiveDesignContest();
	
	/**
	 * 获取一个比赛的专家团队
	 */
	Result getDesignContestJudges(Integer contestId);
	
	/**
	 * 上传作品
	 */
	Result uploadContestEntry(UploadContestEntryRequest request);
	
	/**
	 * 获取比赛作品
	 */
	Result getContestEntry(ContestEntryRequest request);
	
	/**
	 * 投票
	 */
	Result contestEntryVote(ContestEntryVoteRequest request);
}