package me.scape.ti.srv.impl;

import java.util.Date;

import me.scape.ti.dataobject.RequirementsDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.PublishRequirementsRequest;
import me.scape.ti.ro.RequirementsSearchRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.RequirementsService;
import me.scape.ti.vo.CityVO;
import me.scape.ti.vo.ProviceVO;
import me.scape.ti.vo.RegionVO;
import me.scape.ti.vo.RequirementsSecondCategoryVO;
import me.scape.ti.vo.RequirementsTopCategoryVO;
import me.scape.ti.vo.RequirementsVO;
import me.scape.ti.vo.UserVO;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 上午11:33:48
 */
public class DefaultRequirementsService extends BaseService implements RequirementsService {

	@Override
	public Result search(RequirementsSearchRequest request) {
		return null;
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result publishRequirements(PublishRequirementsRequest request) {
		Result privileged = doPrivileged(request);
		if(!privileged.isSuccess()) {
			return privileged;
		}
		Long userId = privileged.getResponse(Long.class);
		RequirementsDO requirements = new RequirementsDO();
		requirements.setTitle(request.getTitle());
		requirements.setConent(request.getConent());
		requirements.setProvince_id(request.getProvince_id());
		requirements.setCity_id(request.getCity_id());
		requirements.setRegion_id(request.getRegion_id());
		requirements.setMedia(request.getMedia());
		requirements.setMobile(request.getMobile());
		requirements.setTop_cat_id(request.getTop_cat_id());
		requirements.setSec_cat_id(request.getSec_cat_id());
		requirements.setUser_id(userId);
		Date date = new Date();
		requirements.setGmt_created(date);
		requirements.setGmt_modified(date);
		requirementsDAO.persist(requirements);
		RequirementsVO vo = RequirementsVO.newInstance(requirements);
		vo.setUser(UserVO.newInstance(userDAO.get(userId)));
		vo.setProvince(ProviceVO.newInstance(provinceDAO.get(requirements.getProvince_id())));
		vo.setCity(CityVO.newInstance(cityDAO.get(requirements.getCity_id())));
		vo.setRegion(RegionVO.newInstance(regionDAO.get(requirements.getRegion_id())));
		vo.setTop_cat(RequirementsTopCategoryVO.newInstance(requirementsTopCategoryDAO.get(requirements.getTop_cat_id())));
		vo.setSec_cat(RequirementsSecondCategoryVO.newInstance(requirementsSecondCategoryDAO.get(requirements.getSec_cat_id())));
		return Result.newSuccess().with(ResultCode.Success).with("requirements", vo);
	}
}