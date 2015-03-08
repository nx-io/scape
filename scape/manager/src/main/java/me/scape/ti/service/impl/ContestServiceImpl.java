package me.scape.ti.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.DesignContestQueryCriteria;
import me.scape.ti.dao.DesignContestDAO;
import me.scape.ti.dataobject.DesignContestDO;
import me.scape.ti.service.ContestService;
import me.scape.ti.vo.ContestDetailVO;
import me.scape.ti.vo.ContestListVO;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.request.ContestListRequest;
import me.scape.ti.vo.request.ContestRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContestServiceImpl extends BaseServiceImpl implements ContestService {

    @Resource
    private DesignContestDAO designContestDAO;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public CurrentPage<ContestListVO> listContests(ContestListRequest contestListRequest) {
        DesignContestQueryCriteria criteria = new DesignContestQueryCriteria();

        criteria.setTitle(contestListRequest.getTitle());
        criteria.setStatus(contestListRequest.getStatus());

        int curn = contestListRequest.getCurn() > 0 ? contestListRequest.getCurn() : 1;
        int pageSize = contestListRequest.getPs();
        criteria.setOffset((curn - 1) * pageSize);
        criteria.setLimit(pageSize);

        Pagination<DesignContestDO> contests = designContestDAO.ListDesignContests(criteria);

        List<ContestListVO> contestVOs = formatContests(contests.getItems());

        return new CurrentPage(curn, contests.getCount(), pageSize, contestVOs);
    }

    private List<ContestListVO> formatContests(List<DesignContestDO> contests) {
        List<ContestListVO> contestVOs = new ArrayList<ContestListVO>();
        if (null == contests || contests.size() <= 0) {
            return contestVOs;
        }

        for (DesignContestDO contest : contests) {
            ContestListVO contestListVO = new ContestListVO();
            contestListVO.setId(contest.getId());
            contestListVO.setTitle(contest.getTitle());
            contestListVO.setStatus(contest.getStatus());
            contestListVO.setStart_time(contest.getStart_time());
            contestListVO.setEnd_time(contest.getEnd_time());

            contestVOs.add(contestListVO);
        }

        return contestVOs;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public int createContest(ContestRequest contestRequest) {
        Date now = new Date();

        DesignContestDO contest = new DesignContestDO();

        contest.setTitle(contestRequest.getTitle());
        contest.setStatus(contestRequest.getStatus());
        contest.setTopic(contestRequest.getTopic());
        contest.setDescription(contestRequest.getDescription());
        contest.setTimetable(contestRequest.getTimetable());
        contest.setPrizes(contestRequest.getPrizes());
        contest.setRequirements(contestRequest.getRequirements());
        contest.setCommittee(contestRequest.getCommittee());
        contest.setHost_organizers(contestRequest.getHost_organizers());
        contest.setOrganizers(contestRequest.getOrganizers());
        contest.setCo_organizers(contestRequest.getCo_organizers());
        contest.setStart_time(contestRequest.getStart_time());
        contest.setEnd_time(contestRequest.getEnd_time());

        contest.setGmt_created(now);
        contest.setGmt_modified(now);

        designContestDAO.persist(contest);

        return contest.getId();
    }

    @Override
    public ContestDetailVO getContestDetail(int contestId) {
        ContestDetailVO contestDetailVO = new ContestDetailVO();

        DesignContestDO contest = designContestDAO.get(contestId);
        if (null == contest) {
            return contestDetailVO;
        }

        contestDetailVO.setId(contestId);
        contestDetailVO.setTitle(contest.getTitle());
        contestDetailVO.setStatus(contest.getStatus());
        contestDetailVO.setTopic(contest.getTopic());
        contestDetailVO.setDescription(contest.getDescription());
        contestDetailVO.setTimetable(contest.getTimetable());
        contestDetailVO.setPrizes(contest.getPrizes());
        contestDetailVO.setRequirements(contest.getRequirements());
        contestDetailVO.setCommittee(contest.getCommittee());
        contestDetailVO.setHost_organizers(contest.getHost_organizers());
        contestDetailVO.setOrganizers(contest.getOrganizers());
        contestDetailVO.setCo_organizers(contest.getCo_organizers());
        contestDetailVO.setStart_time(contest.getStart_time());
        contestDetailVO.setEnd_time(contest.getEnd_time());

        return contestDetailVO;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public void editContest(int contestId, ContestRequest contestRequest) {
        DesignContestDO contest = designContestDAO.get(contestId);
        if (null == contest) {
            return;
        }

        Date now = new Date();

        contest.setTitle(contestRequest.getTitle());
        contest.setStatus(contestRequest.getStatus());
        contest.setTopic(contestRequest.getTopic());
        contest.setDescription(contestRequest.getDescription());
        contest.setTimetable(contestRequest.getTimetable());
        contest.setPrizes(contestRequest.getPrizes());
        contest.setRequirements(contestRequest.getRequirements());
        contest.setCommittee(contestRequest.getCommittee());
        contest.setHost_organizers(contestRequest.getHost_organizers());
        contest.setOrganizers(contestRequest.getOrganizers());
        contest.setCo_organizers(contestRequest.getCo_organizers());
        contest.setStart_time(contestRequest.getStart_time());
        contest.setEnd_time(contestRequest.getEnd_time());

        contest.setGmt_modified(now);
    }

}
