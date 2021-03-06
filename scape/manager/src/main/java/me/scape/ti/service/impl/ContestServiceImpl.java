package me.scape.ti.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.DesignContestNewsQueryCriteria;
import me.scape.ti.criteria.DesignContestQueryCriteria;
import me.scape.ti.criteria.DesignContestJudgeQueryCriteria;
import me.scape.ti.dao.DesignContestDAO;
import me.scape.ti.dao.DesignContestJudgesDAO;
import me.scape.ti.dao.DesignContestNewsDAO;
import me.scape.ti.dataobject.DesignContestDO;
import me.scape.ti.dataobject.DesignContestJudgesDO;
import me.scape.ti.dataobject.DesignContestNewsDO;
import me.scape.ti.service.ContestService;
import me.scape.ti.utils.CDNUtil;
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

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContestServiceImpl extends BaseServiceImpl implements ContestService {

    @Resource
    private DesignContestDAO designContestDAO;

    @Resource
    private DesignContestNewsDAO designContestNewsDAO;

    @Resource
    private DesignContestJudgesDAO designContestJudgesDAO;

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

    @Override
    public List<ContestListVO> listAllEnabledContests() {
        List<DesignContestDO> contests = designContestDAO.getAllEnabledContests();
        List<ContestListVO> contestVOs = formatContests(contests);

        return contestVOs;
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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public CurrentPage<ContestNewsListVO> listContestNews(ContestNewsListRequest contestNewsListRequest) {
        DesignContestNewsQueryCriteria criteria = new DesignContestNewsQueryCriteria();

        int curn = contestNewsListRequest.getCurn() > 0 ? contestNewsListRequest.getCurn() : 1;
        int pageSize = contestNewsListRequest.getPs();
        criteria.setOffset((curn - 1) * pageSize);
        criteria.setLimit(pageSize);

        Pagination<DesignContestNewsDO> contestNewsPagination = designContestNewsDAO.listDesignContestNews(criteria);

        List<ContestNewsListVO> contestNewsVOs = new ArrayList<ContestNewsListVO>();
        List<DesignContestNewsDO> contestNewsList = contestNewsPagination.getItems();
        if (null != contestNewsList && contestNewsList.size() > 0) {
            List<Integer> contestIds = new ArrayList<Integer>();
            for (DesignContestNewsDO contestNews : contestNewsList) {
                contestIds.add(contestNews.getContest_id());
            }
            List<DesignContestDO> contestList = designContestDAO.getContestsByIds(contestIds);
            Map<Integer, String> contestMap = new HashMap<Integer, String>();
            for (DesignContestDO contest : contestList) {
                contestMap.put(contest.getId(), contest.getTitle());
            }

            for (DesignContestNewsDO contestNews : contestNewsList) {
                ContestNewsListVO contestNewsListVO = new ContestNewsListVO();
                contestNewsListVO.setId(contestNews.getId());
                contestNewsListVO.setTitle(contestNews.getTitle());
                contestNewsListVO.setContest_id(contestNews.getContest_id());
                contestNewsListVO.setContest_title(contestMap.get(contestNews.getContest_id()));
                contestNewsListVO.setGmt_created(contestNews.getGmt_created());

                contestNewsVOs.add(contestNewsListVO);
            }
        }

        return new CurrentPage(curn, contestNewsPagination.getCount(), pageSize, contestNewsVOs);
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public long createContestNews(ContestNewsRequest contestNewsRequest) {
        Date now = new Date();

        DesignContestNewsDO contestNews = new DesignContestNewsDO();

        contestNews.setTitle(contestNewsRequest.getTitle());
        contestNews.setContest_id(contestNewsRequest.getContest_id());
        contestNews.setContent(contestNewsRequest.getContent());
        contestNews.setGmt_created(now);
        contestNews.setGmt_modified(now);

        designContestDAO.persist(contestNews);

        return contestNews.getId();
    }

    @Override
    public ContestDetailNewsVO getContestNewsDetail(long contestNewsId) {
        ContestDetailNewsVO contestDetailNewsVO = new ContestDetailNewsVO();

        DesignContestNewsDO contestNews = designContestNewsDAO.get(contestNewsId);
        if (null == contestNews) {
            return contestDetailNewsVO;
        }

        contestDetailNewsVO.setId(contestNewsId);
        contestDetailNewsVO.setTitle(contestNews.getTitle());
        contestDetailNewsVO.setContest_id(contestNews.getContest_id());
        contestDetailNewsVO.setContent(contestNews.getContent());

        return contestDetailNewsVO;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public void editContestNews(long contestNewsId, ContestNewsRequest contestNewsRequest) {
        DesignContestNewsDO contestNews = designContestNewsDAO.get(contestNewsId);
        if (null == contestNews) {
            return;
        }

        Date now = new Date();

        contestNews.setTitle(contestNewsRequest.getTitle());
        contestNews.setContest_id(contestNewsRequest.getContest_id());
        contestNews.setContent(contestNewsRequest.getContent());
        contestNews.setGmt_modified(now);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public CurrentPage<ContestJudgeListVO> listContestJudge(ContestJudgeListRequest contestJudgeListRequest) {
        DesignContestJudgeQueryCriteria criteria = new DesignContestJudgeQueryCriteria();

        int curn = contestJudgeListRequest.getCurn() > 0 ? contestJudgeListRequest.getCurn() : 1;
        int pageSize = contestJudgeListRequest.getPs();
        criteria.setOffset((curn - 1) * pageSize);
        criteria.setLimit(pageSize);

        Pagination<DesignContestJudgesDO> contestJudgesPagination = designContestJudgesDAO
                .listDesignContestJudge(criteria);

        List<ContestJudgeListVO> contestJudgeVOs = new ArrayList<ContestJudgeListVO>();
        List<DesignContestJudgesDO> contestJudgeList = contestJudgesPagination.getItems();
        if (null != contestJudgeList && contestJudgeList.size() > 0) {
            List<Integer> contestIds = new ArrayList<Integer>();
            for (DesignContestJudgesDO contestJudge : contestJudgeList) {
                contestIds.add(contestJudge.getContest_id());
            }
            List<DesignContestDO> contestList = designContestDAO.getContestsByIds(contestIds);
            Map<Integer, String> contestMap = new HashMap<Integer, String>();
            for (DesignContestDO contest : contestList) {
                contestMap.put(contest.getId(), contest.getTitle());
            }

            for (DesignContestJudgesDO contestJudge : contestJudgeList) {
                ContestJudgeListVO contestJudgeListVO = new ContestJudgeListVO();
                contestJudgeListVO.setId(contestJudge.getId());
                contestJudgeListVO.setName(contestJudge.getName());
                contestJudgeListVO.setTitle(contestJudge.getTitle());
                contestJudgeListVO.setAvatar(CDNUtil.getFullPath(contestJudge.getAvatar()));
                contestJudgeListVO.setContest_id(contestJudge.getContest_id());
                contestJudgeListVO.setContest_title(contestMap.get(contestJudge.getContest_id()));
                contestJudgeListVO.setGmt_created(contestJudge.getGmt_created());

                contestJudgeVOs.add(contestJudgeListVO);
            }
        }

        return new CurrentPage(curn, contestJudgesPagination.getCount(), pageSize, contestJudgeVOs);
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public long createContestJudge(ContestJudgeRequest contestJudgeRequest) {
        Date now = new Date();

        DesignContestJudgesDO contestJudge = new DesignContestJudgesDO();
        contestJudge.setTitle(contestJudgeRequest.getTitle());
        contestJudge.setContest_id(contestJudgeRequest.getContest_id());
        contestJudge.setName(contestJudgeRequest.getName());
        contestJudge.setTitle(contestJudgeRequest.getTitle());
        contestJudge.setAvatar(contestJudgeRequest.getAvatar());
        contestJudge.setProfile(contestJudgeRequest.getProfile());
        contestJudge.setGmt_created(now);
        contestJudge.setGmt_modified(now);

        designContestJudgesDAO.persist(contestJudge);

        return contestJudge.getId();
    }

    @Override
    public ContestJudgeDetailVO getContestJudgeDetail(long contestJudgeId) {
        ContestJudgeDetailVO contestJudgeDetailVO = new ContestJudgeDetailVO();

        DesignContestJudgesDO contestJudge = designContestJudgesDAO.get(contestJudgeId);
        if (null == contestJudge) {
            return contestJudgeDetailVO;
        }

        contestJudgeDetailVO.setId(contestJudgeId);
        contestJudgeDetailVO.setTitle(contestJudge.getTitle());
        contestJudgeDetailVO.setContest_id(contestJudge.getContest_id());
        contestJudgeDetailVO.setName(contestJudge.getName());
        contestJudgeDetailVO.setTitle(contestJudge.getTitle());
        contestJudgeDetailVO.setAvatar(contestJudge.getAvatar());
        contestJudgeDetailVO.setAvatar_url(CDNUtil.getFullPath(contestJudge.getAvatar()));
        contestJudgeDetailVO.setProfile(contestJudge.getProfile());

        return contestJudgeDetailVO;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public void editContestJudge(long contestJudgeId, ContestJudgeRequest contestJudgeRequest) {
        DesignContestJudgesDO contestJudge = designContestJudgesDAO.get(contestJudgeId);
        if (null == contestJudge) {
            return;
        }

        Date now = new Date();

        contestJudge.setTitle(contestJudgeRequest.getTitle());
        contestJudge.setContest_id(contestJudgeRequest.getContest_id());
        contestJudge.setName(contestJudgeRequest.getName());
        contestJudge.setTitle(contestJudgeRequest.getTitle());
        contestJudge.setAvatar(contestJudgeRequest.getAvatar());
        contestJudge.setProfile(contestJudgeRequest.getProfile());
        contestJudge.setGmt_modified(now);
    }

}
