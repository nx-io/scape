package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.dataobject.CityDO;
import me.scape.ti.dataobject.ProvinceDO;
import me.scape.ti.dataobject.RegionDO;
import me.scape.ti.dataobject.RequirementsCommentsDO;
import me.scape.ti.dataobject.RequirementsDO;
import me.scape.ti.dataobject.RequirementsSecondCategoryDO;
import me.scape.ti.dataobject.RequirementsTopCategoryDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.PublishRequirementsRequest;
import me.scape.ti.ro.RequirementsSearchRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.PageQuery;
import me.scape.ti.srv.RequirementsService;
import me.scape.ti.vo.RequirementsCommentsVO;
import me.scape.ti.vo.RequirementsSecondCategoryVO;
import me.scape.ti.vo.RequirementsTopCategoryVO;
import me.scape.ti.vo.RequirementsVO;
import me.scape.ti.vo.UserVO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 上午11:33:48
 */
@Service(value = "requirementsService")
public class DefaultRequirementsService extends BaseService implements RequirementsService {

	@Override
	public Result search(RequirementsSearchRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM requirements i WHERE 1 = 1 ");
		Map<String, Object> args = new HashMap<String, Object>();
		Long id = request.getId();
		if (id != null && id > 0L) {
			sb.append(" AND i.id = :id ");
			args.put("id", id);
		}
		String title = request.getTitle();
		if (StringUtils.isNotBlank(title)) {
			sb.append(" AND i.title LIKE :title ");
			args.put("title", "%" + title + "%");
		}
		Integer province_id = request.getProvince_id();
		if (province_id != null && province_id > 0) {
			sb.append(" AND i.province_id = :province_id ");
			args.put("province_id", province_id);
		}
		Integer city_id = request.getCity_id();
		if (city_id != null && city_id > 0) {
			sb.append(" AND i.city_id = :city_id ");
			args.put("city_id", city_id);
		}
		Integer region_id = request.getRegion_id();
		if (region_id != null && region_id > 0) {
			sb.append(" AND i.region_id = :region_id ");
			args.put("region_id", region_id);
		}
		Integer top_cat_id = request.getTop_cat_id();
		if (top_cat_id != null && top_cat_id > 0) {
			sb.append(" AND i.top_cat_id = :top_cat_id ");
			args.put("top_cat_id", top_cat_id);
		}
		Integer sec_cat_id = request.getSec_cat_id();
		if (sec_cat_id != null && sec_cat_id > 0) {
			sb.append(" AND i.sec_cat_id = :sec_cat_id ");
			args.put("sec_cat_id", sec_cat_id);
		}
		sb.append(" ORDER BY i.gmt_created DESC, i.gmt_modified DESC ");
		sb.append(" LIMIT :start, :size ");
		Integer page = request.getPage();
		page = (page != null && page > 0) ? page : 1;
		PageQuery pageQuery = new PageQuery(page);
		args.put("start", pageQuery.getIndex());
		args.put("size", pageQuery.getSize());
		List<RequirementsDO> requirementsList = requirementsDAO.queryNative(sb.toString(), args);
		if (CollectionUtils.isEmpty(requirementsList)) {
			return Result.newError().with(ResultCode.Error_Requirements_Empty);
		}
		List<RequirementsVO> voList = new ArrayList<RequirementsVO>();
		for (RequirementsDO requirements : requirementsList) {
			RequirementsVO vo = toRequirements(requirements);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return Result.newSuccess().with(ResultCode.Success).with("requirementsList", voList);
	}

	@Override
	public Result getRequirements(Long reqId) {
		RequirementsDO requirements = requirementsDAO.get(reqId);
		RequirementsVO vo = toRequirements(requirements);
		List<RequirementsCommentsDO> commentsList = requirementsCommentsDAO.query("FROM RequirementsCommentsDO WHERE requirements_id = ?", new Object[] { reqId });
		List<RequirementsCommentsVO> voList = RequirementsCommentsVO.newInstance(commentsList);
		if(voList != null && !voList.isEmpty()) {
			for (RequirementsCommentsVO comments : voList) {
				comments.setChildComments(RequirementsCommentsVO.newInstance(requirementsCommentsDAO.query("FROM RequirementsCommentsDO WHERE ref_id = ?", new Object[] { comments.getId() })));
			}
		}
		return Result.newSuccess().with(ResultCode.Success)
				.with("requirements", vo)
				.with("commentsList", voList);
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result publishRequirements(PublishRequirementsRequest request) {
		Result privileged = doPrivileged(request);
		if (!privileged.isSuccess()) {
			return privileged;
		}
		Long userId = privileged.getResponse(Long.class);
		RequirementsDO requirements = new RequirementsDO();
		requirements.setTitle(request.getTitle());
		requirements.setConent(request.getConent());
		requirements.setProvince_id(request.getProvince_id());
		ProvinceDO province = provinceDAO.get(request.getProvince_id());
		requirements.setProvince(province.getName());
		requirements.setCity_id(request.getCity_id());
		CityDO city = cityDAO.get(request.getCity_id());
		requirements.setCity(city.getName());
		requirements.setRegion_id(request.getRegion_id());
		RegionDO region = regionDAO.get(request.getRegion_id());
		requirements.setRegion(region.getName());
		requirements.setMedia(request.getMedia());
		requirements.setMobile(request.getMobile());
		requirements.setTop_cat_id(request.getTop_cat_id());
		RequirementsTopCategoryDO topCategory = requirementsTopCategoryDAO.get(request.getTop_cat_id());
		requirements.setTop_cat(topCategory.getName());
		requirements.setSec_cat_id(request.getSec_cat_id());
		RequirementsSecondCategoryDO secCategory = requirementsSecondCategoryDAO.get(request.getSec_cat_id());
		requirements.setSec_cat(secCategory.getName());
		requirements.setUser_id(userId);
		Date date = new Date();
		requirements.setGmt_created(date);
		requirements.setGmt_modified(date);
		requirementsDAO.persist(requirements);
		RequirementsVO vo = toRequirements(requirements);
		return Result.newSuccess().with(ResultCode.Success).with("requirements", vo);
	}

	@Override
	public Result getTopCategoryList() {
		List<RequirementsTopCategoryDO> topCategoryList = requirementsTopCategoryDAO.findAll();
		List<RequirementsTopCategoryVO> voList = new ArrayList<RequirementsTopCategoryVO>();
		if (topCategoryList != null && !topCategoryList.isEmpty()) {
			for (RequirementsTopCategoryDO topCategory : topCategoryList) {
				voList.add(RequirementsTopCategoryVO.newInstance(topCategory));
			}
		}
		return Result.newSuccess().with(ResultCode.Success).with("topCategoryList", voList);
	}

	@Override
	public Result getSecondCategoryList(Integer topCatId) {
		RequirementsTopCategoryDO _do = requirementsTopCategoryDAO.get(topCatId);
		RequirementsTopCategoryVO topCategory = RequirementsTopCategoryVO.newInstance(_do);
		List<RequirementsSecondCategoryDO> secondCategoryList = requirementsSecondCategoryDAO.query("FROM RequirementsSecondCategoryDO WHERE top_cat_id = ?", new Object[] { topCatId });
		List<RequirementsSecondCategoryVO> voList = new ArrayList<RequirementsSecondCategoryVO>();
		if (secondCategoryList != null && !secondCategoryList.isEmpty()) {
			for (RequirementsSecondCategoryDO secondCategory : secondCategoryList) {
				RequirementsSecondCategoryVO vo = RequirementsSecondCategoryVO.newInstance(secondCategory);
				vo.setTop_cat(topCategory);
				voList.add(vo);
			}
		}
		return Result.newSuccess().with(ResultCode.Success).with("secondCategoryList", voList);
	}

	private RequirementsVO toRequirements(RequirementsDO requirements) {
		RequirementsVO vo = RequirementsVO.newInstance(requirements);
		if (vo == null) {
			return vo;
		}
		vo.setUser(UserVO.newInstance(userDAO.get(requirements.getUser_id())));
		return vo;
	}
}