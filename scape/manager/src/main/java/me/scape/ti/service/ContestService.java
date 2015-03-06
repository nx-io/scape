package me.scape.ti.service;

import me.scape.ti.vo.ContestDetailVO;
import me.scape.ti.vo.ContestListVO;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.request.ContestListRequest;
import me.scape.ti.vo.request.ContestRequest;

public interface ContestService {

    CurrentPage<ContestListVO> listContests(ContestListRequest contestListRequest);

    int createContest(ContestRequest contestRequest);

    ContestDetailVO getContestDetail(int contestId);

    void editContest(int contestId, ContestRequest contestRequest);
}
