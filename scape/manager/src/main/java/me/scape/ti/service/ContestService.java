package me.scape.ti.service;

import java.util.List;

import me.scape.ti.vo.ContestDetailNewsVO;
import me.scape.ti.vo.ContestDetailVO;
import me.scape.ti.vo.ContestJudgeDetailVO;
import me.scape.ti.vo.ContestJudgeListVO;
import me.scape.ti.vo.ContestListVO;
import me.scape.ti.vo.ContestNewsListVO;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.request.ContestJudgeListRequest;
import me.scape.ti.vo.request.ContestJudgeRequest;
import me.scape.ti.vo.request.ContestListRequest;
import me.scape.ti.vo.request.ContestNewsListRequest;
import me.scape.ti.vo.request.ContestNewsRequest;
import me.scape.ti.vo.request.ContestRequest;

public interface ContestService {

    CurrentPage<ContestListVO> listContests(ContestListRequest contestListRequest);

    List<ContestListVO> listAllEnabledContests();

    int createContest(ContestRequest contestRequest);

    ContestDetailVO getContestDetail(int contestId);

    void editContest(int contestId, ContestRequest contestRequest);

    CurrentPage<ContestNewsListVO> listContestNews(ContestNewsListRequest contestNewsListRequest);

    long createContestNews(ContestNewsRequest contestNewsRequest);

    ContestDetailNewsVO getContestNewsDetail(long contestNewsId);

    void editContestNews(long contestNewsId, ContestNewsRequest contestNewsRequest);

    CurrentPage<ContestJudgeListVO> listContestJudge(ContestJudgeListRequest contestJudgeListRequest);

    long createContestJudge(ContestJudgeRequest contestJudgeRequest);

    ContestJudgeDetailVO getContestJudgeDetail(long contestJudgeId);

    void editContestJudge(long contestJudgeId, ContestJudgeRequest contestJudgeRequest);
}
