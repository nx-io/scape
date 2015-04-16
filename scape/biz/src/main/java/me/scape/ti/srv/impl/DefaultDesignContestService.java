package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.dataobject.DesignContestDO;
import me.scape.ti.dataobject.DesignContestEntryDO;
import me.scape.ti.dataobject.DesignContestEntryMediaDO;
import me.scape.ti.dataobject.DesignContestEntryVoteDO;
import me.scape.ti.dataobject.DesignContestJudgesDO;
import me.scape.ti.dataobject.DesignContestNewsDO;
import me.scape.ti.dataobject.DesignContestResultDO;
import me.scape.ti.dataobject.DesignContestUserDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.ContestEntryRequest;
import me.scape.ti.ro.ContestEntryVoteRequest;
import me.scape.ti.ro.DesignContestResultRequest;
import me.scape.ti.ro.JoinDesignContestRequest;
import me.scape.ti.ro.UploadContestEntryRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.DesignContestService;
import me.scape.ti.srv.PageQuery;
import me.scape.ti.utils.GuidUtils;
import me.scape.ti.utils.ImageUtils;
import me.scape.ti.vo.DesignContestEntryVO;
import me.scape.ti.vo.DesignContestJudgesVO;
import me.scape.ti.vo.DesignContestResultVO;
import me.scape.ti.vo.DesignContestVO;
import me.scape.ti.vo.UserVO;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 比赛相关业务.
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:19:17
 */
@Service("designContestService")
public class DefaultDesignContestService extends BaseService implements DesignContestService {

	@Override
	public Result getContestEntry(Integer entryId) {
		DesignContestEntryDO designContestEntryDO = designContestEntryDAO.get(entryId);
		if (designContestEntryDO == null) {
			return Result.newError().with(ResultCode.Error_Entry_Empty);
		}
		DesignContestEntryVO vo = DesignContestEntryVO.newInstance(designContestEntryDO);
		vo.setUser(UserVO.newInstance(userDAO.get(designContestEntryDO.getUser_id())));
		List<String> mediaList = new ArrayList<String>();
		String hql = "FROM DesignContestEntryMediaDO WHERE entry_id = ?";
		List<DesignContestEntryMediaDO> contestEntryMediaList = designContestEntryMediaDAO.query(hql, new Object[] { designContestEntryDO.getId() });
		if (CollectionUtils.isNotEmpty(contestEntryMediaList)) {
			for (DesignContestEntryMediaDO media : contestEntryMediaList) {
				mediaList.add(ImageUtils.urlWrapper(media.getUrl()));
			}
		}
		vo.setMediaList(mediaList);
		String sql = "SELECT COUNT(id) FROM design_contest_entry_vote WHERE voter_id = ? AND entry_id = ?";
		java.math.BigInteger c = (java.math.BigInteger) designContestEntryVoteDAO.createNativeQuery(sql, new Object[] { designContestEntryDO.getUser_id(), designContestEntryDO.getId() })
				.getSingleResult();
		if (c != null && c.longValue() > 0L) {
			vo.setVoteCount(c.longValue());
		} else {
			vo.setVoteCount(0L);
		}
		return Result.newSuccess().with(ResultCode.Success).with("entry", vo);
	}

	@Override
	public Result getDesignContestNews(Integer contest_id) {
		String hql = "FROM DesignContestNewsDO WHERE contest_id = ?";
		List<DesignContestNewsDO> newsList = designContestNewsDAO.query(hql, new Object[] { contest_id });
		return Result.newSuccess().with(ResultCode.Success).with("newsList", newsList);
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result setDesignContestResult(DesignContestResultRequest request) {
		DesignContestResultDO result = new DesignContestResultDO();
		result.setComment(request.getComment());
		result.setContest_id(request.getContest_id());
		result.setEntry_id(request.getEntry_id());
		Date now = new Date();
		result.setGmt_created(now);
		result.setGmt_modified(now);
		result.setRanking(request.getRanking());
		designContestResultDAO.persist(result);
		return Result.newSuccess().with(ResultCode.Success);
	}

	@Override
	public Result getDesignContestResult(Integer contestId) {
		String hql = "FROM DesignContestResultDO WHERE contest_id = ?";
		List<DesignContestResultDO> contestResultList = designContestResultDAO.query(hql, new Object[] { contestId });
		if (CollectionUtils.isEmpty(contestResultList)) {
			return Result.newError().with(ResultCode.Error_Contest_Result_Empty);
		}
		List<DesignContestResultVO> resultList = new ArrayList<DesignContestResultVO>();
		for (DesignContestResultDO result : contestResultList) {
			if (result == null) {
				continue;
			}
			DesignContestResultVO vo = new DesignContestResultVO();
			vo.setComment(result.getComment());
			vo.setRanking(result.getRanking());
			DesignContestEntryDO entry = designContestEntryDAO.get(result.getEntry_id());
			if (entry == null) {
				continue;
			}
			vo.setContestEntry(DesignContestEntryVO.newInstance(entry));
			resultList.add(vo);
		}
		return Result.newSuccess().with(ResultCode.Success).with("resultList", resultList);
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result joinDesignContest(JoinDesignContestRequest request) {
		Result privileged = doPrivileged(request);
		if (!privileged.isSuccess()) {
			return privileged;
		}
		Long userId = privileged.getResponse(Long.class);
		DesignContestUserDO contestUser = new DesignContestUserDO();
		contestUser.setContest_id(request.getContestId());
		Date now = new Date();
		contestUser.setGmt_created(now);
		contestUser.setGmt_modified(now);
		contestUser.setNumber(String.valueOf(GuidUtils.guidNum()));
		contestUser.setUser_id(userId);
		designContestUserDAO.persist(contestUser);
		return Result.newSuccess().with(ResultCode.Success).with("NUM", contestUser.getNumber());
	}

	@Override
	public Result getContestEntryList(ContestEntryRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM design_contest_entry c WHERE 1 = 1 ");
		Map<String, Object> args = new HashMap<String, Object>();
		Integer cid = request.getContestId();
		if (cid != null && cid > 0) {
			sb.append(" AND c.contest_id = :cid ");
			args.put("cid", cid);
		}
		sb.append(" ORDER BY c.gmt_created DESC ");
		sb.append(" LIMIT :start, :size ");
		Integer page = request.getPage();
		page = (page != null && page > 0) ? page : 1;
		PageQuery pageQuery = new PageQuery(page);
		args.put("start", pageQuery.getIndex());
		args.put("size", pageQuery.getSize());
		List<DesignContestEntryDO> contestEntryList = designContestEntryDAO.queryNative(sb.toString(), args);
		if (CollectionUtils.isEmpty(contestEntryList)) {
			return Result.newError().with(ResultCode.Error_Entry_Empty);
		}
		List<DesignContestEntryVO> voList = new ArrayList<DesignContestEntryVO>();
		String hql = "FROM DesignContestEntryMediaDO WHERE entry_id = ?";
		String sql = "SELECT COUNT(id) FROM design_contest_entry_vote WHERE voter_id = ? AND entry_id = ?";
		for (DesignContestEntryDO designContestEntryDO : contestEntryList) {
			DesignContestEntryVO vo = DesignContestEntryVO.newInstance(designContestEntryDO);
			vo.setUser(UserVO.newInstance(userDAO.get(designContestEntryDO.getUser_id())));
			List<String> mediaList = new ArrayList<String>();
			List<DesignContestEntryMediaDO> contestEntryMediaList = designContestEntryMediaDAO.query(hql, new Object[] { designContestEntryDO.getId() });
			if (CollectionUtils.isNotEmpty(contestEntryMediaList)) {
				for (DesignContestEntryMediaDO media : contestEntryMediaList) {
					mediaList.add(ImageUtils.urlWrapper(media.getUrl()));
				}
			}
			vo.setMediaList(mediaList);
			java.math.BigInteger c = (java.math.BigInteger) designContestEntryVoteDAO.createNativeQuery(sql, new Object[] { designContestEntryDO.getUser_id(), designContestEntryDO.getId() })
					.getSingleResult();
			if (c != null && c.longValue() > 0L) {
				vo.setVoteCount(c.longValue());
			} else {
				vo.setVoteCount(0L);
			}
			voList.add(vo);
		}
		return Result.newSuccess().with(ResultCode.Success).with("contestEntryList", voList);
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result uploadContestEntry(UploadContestEntryRequest request) {
		Result privileged = doPrivileged(request);
		if (!privileged.isSuccess()) {
			return privileged;
		}
		Long userId = privileged.getResponse(Long.class);
		DesignContestEntryDO contestEntry = new DesignContestEntryDO();
		contestEntry.setAttachment(request.getAttachment());
		contestEntry.setContest_id(request.getContest_id());
		contestEntry.setDescription(request.getDescription());
		Date now = new Date();
		contestEntry.setGmt_created(now);
		contestEntry.setGmt_modified(now);
		contestEntry.setTitle(request.getTitle());
		contestEntry.setUser_id(userId);
		designContestEntryDAO.persist(contestEntry);
		List<String> mediaList = new ArrayList<String>();
		if (StringUtils.isNotBlank(request.getMediaList())) {
			String[] medias = StringUtils.split(request.getMediaList(), ",");
			if (medias != null && medias.length > 0) {
				for (String media : medias) {
					DesignContestEntryMediaDO contestEntryMedia = new DesignContestEntryMediaDO();
					contestEntryMedia.setEntry_id(contestEntry.getId());
					contestEntryMedia.setUrl(media);
					contestEntryMedia.setGmt_created(now);
					contestEntryMedia.setGmt_modified(now);
					designContestEntryMediaDAO.persist(contestEntryMedia);
					mediaList.add(ImageUtils.urlWrapper(media));
				}
			}
		}
		DesignContestEntryVO contestEntryVO = DesignContestEntryVO.newInstance(contestEntry);
		contestEntryVO.setMediaList(mediaList);
		contestEntryVO.setUser(UserVO.newInstance(userDAO.get(userId)));
		contestEntryVO.setVoteCount(0L);
		return Result.newSuccess().with(ResultCode.Success).with("contestEntry", contestEntryVO);
	}

	@Override
	public Result getActiveDesignContest() {
		String hql = "FROM DesignContestDO WHERE status = ?";
		List<DesignContestDO> doList = designContestDAO.query(hql, new Object[] { DesignContestDO.IN_PROGRESS });
		if (CollectionUtils.isEmpty(doList)) {
			return Result.newError().with(ResultCode.Error_Active_Design_Contest_Empty);
		}
		return Result.newSuccess().with(ResultCode.Success).with("contest", DesignContestVO.newInstance(doList.get(0)));
	}

	@Override
	public Result getDesignContestJudges(Integer contestId) {
		String hql = "FROM DesignContestJudgesDO WHERE contest_id = ?";
		List<DesignContestJudgesDO> doList = designContestJudgesDAO.query(hql, new Object[] { contestId });
		return Result.newSuccess().with(ResultCode.Success).with("judgesList", DesignContestJudgesVO.newInstance(doList));
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result contestEntryVote(ContestEntryVoteRequest request) {
		Result privileged = doPrivileged(request);
		if (!privileged.isSuccess()) {
			return privileged;
		}
		Long userId = privileged.getResponse(Long.class);
		Integer entry_id = request.getEntry_id();
		Object[] args = new Object[] { userId, entry_id };
		String sql = "SELECT COUNT(id) FROM design_contest_entry_vote WHERE voter_id = ? AND entry_id = ?";
		java.math.BigInteger c = (java.math.BigInteger) designContestEntryVoteDAO.createNativeQuery(sql, args).getSingleResult();
		if (c != null && c.longValue() > 0L) {
			return Result.newError().with(ResultCode.Error_EntryVote);
		}
		DesignContestEntryVoteDO contestEntryVote = new DesignContestEntryVoteDO();
		contestEntryVote.setEntry_id(entry_id);
		contestEntryVote.setVoter_id(userId);
		Date now = new Date();
		contestEntryVote.setGmt_created(now);
		contestEntryVote.setGmt_modified(now);
		designContestEntryVoteDAO.persist(contestEntryVote);
		return Result.newSuccess().with(ResultCode.Success);
	}
}