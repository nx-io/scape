package me.scape.ti.srv;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.ocs.commons.redis.RedisTemplate;
import me.ocs.commons.sequence.SequenceService;
import me.ocs.oauth.security.SecurityService;
import me.ocs.oauth.token.AuthenticationProvider;
import me.ocs.oauth.token.request.LoginRequest;
import me.ocs.oauth.token.request.PrivilegedRequest;
import me.ocs.oauth.token.response.LoginResponse;
import me.ocs.oauth.token.response.PrivilegedResponse;
import me.scape.ti.constant.CommonConstant;
import me.scape.ti.dao.AreaCategoryDAO;
import me.scape.ti.dao.CategoryDAO;
import me.scape.ti.dao.CityDAO;
import me.scape.ti.dao.CommentsDAO;
import me.scape.ti.dao.DesignContestDAO;
import me.scape.ti.dao.DesignContestEntryDAO;
import me.scape.ti.dao.DesignContestEntryMediaDAO;
import me.scape.ti.dao.DesignContestEntryVoteDAO;
import me.scape.ti.dao.DesignContestJudgesDAO;
import me.scape.ti.dao.DesignContestNewsDAO;
import me.scape.ti.dao.DesignContestResultDAO;
import me.scape.ti.dao.DesignContestUserDAO;
import me.scape.ti.dao.ItemDAO;
import me.scape.ti.dao.ItemFavoriteDAO;
import me.scape.ti.dao.ItemMediaDAO;
import me.scape.ti.dao.LabelDAO;
import me.scape.ti.dao.ManagerDAO;
import me.scape.ti.dao.PlantCategoryDAO;
import me.scape.ti.dao.PlantMediaDAO;
import me.scape.ti.dao.PlantsColorRelDAO;
import me.scape.ti.dao.PlantsDAO;
import me.scape.ti.dao.PlantsOrnamentalColorDAO;
import me.scape.ti.dao.PlantsOrnamentalPeriodDAO;
import me.scape.ti.dao.PlantsPeriodRelDAO;
import me.scape.ti.dao.ProvinceDAO;
import me.scape.ti.dao.RegionDAO;
import me.scape.ti.dao.RequirementsCommentsDAO;
import me.scape.ti.dao.RequirementsDAO;
import me.scape.ti.dao.RequirementsSecondCategoryDAO;
import me.scape.ti.dao.RequirementsTopCategoryDAO;
import me.scape.ti.dao.RoleDAO;
import me.scape.ti.dao.StyleDAO;
import me.scape.ti.dao.SystemSettingDAO;
import me.scape.ti.dao.UserDAO;
import me.scape.ti.dao.UserFavoriteDAO;
import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.dataobject.ItemMediaDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.utils.WebUtils;
import me.scape.ti.vo.AreaCategoryVO;
import me.scape.ti.vo.CategoryVO;
import me.scape.ti.vo.ItemMediaVO;
import me.scape.ti.vo.ItemVO;
import me.scape.ti.vo.LabelVO;
import me.scape.ti.vo.StyleVO;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:21:29
 */
public class BaseService implements InitializingBean {

	protected Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	@Qualifier("areaCategoryDAO")
	protected AreaCategoryDAO areaCategoryDAO;

	@Autowired
	@Qualifier("categoryDAO")
	protected CategoryDAO categoryDAO;

	@Autowired
	@Qualifier("commentsDAO")
	protected CommentsDAO commentsDAO;

	@Autowired
	@Qualifier("itemDAO")
	protected ItemDAO itemDAO;

	@Autowired
	@Qualifier("itemFavoriteDAO")
	protected ItemFavoriteDAO itemFavoriteDAO;

	@Autowired
	@Qualifier("itemMediaDAO")
	protected ItemMediaDAO itemMediaDAO;

	@Autowired
	@Qualifier("labelDAO")
	protected LabelDAO labelDAO;

	@Autowired
	@Qualifier("managerDAO")
	protected ManagerDAO managerDAO;

	@Autowired
	@Qualifier("roleDAO")
	protected RoleDAO roleDAO;

	@Autowired
	@Qualifier("styleDAO")
	protected StyleDAO styleDAO;

	@Autowired
	@Qualifier("userDAO")
	protected UserDAO userDAO;

	@Autowired
	@Qualifier("userFavoriteDAO")
	protected UserFavoriteDAO userFavoriteDAO;

	@Autowired
	@Qualifier("plantCategoryDAO")
	protected PlantCategoryDAO plantCategoryDAO;

	@Autowired
	@Qualifier("plantsColorRelDAO")
	protected PlantsColorRelDAO plantsColorRelDAO;

	@Autowired
	@Qualifier("plantsDAO")
	protected PlantsDAO plantsDAO;

	@Autowired
	@Qualifier("plantsOrnamentalColorDAO")
	protected PlantsOrnamentalColorDAO plantsOrnamentalColorDAO;

	@Autowired
	@Qualifier("plantsOrnamentalPeriodDAO")
	protected PlantsOrnamentalPeriodDAO plantsOrnamentalPeriodDAO;

	@Autowired
	@Qualifier("plantsPeriodRelDAO")
	protected PlantsPeriodRelDAO plantsPeriodRelDAO;

	@Autowired
	@Qualifier("plantMediaDAO")
	protected PlantMediaDAO plantMediaDAO;

	@Autowired
	@Qualifier("systemSettingDAO")
	protected SystemSettingDAO systemSettingDAO;

	@Autowired
	@Qualifier("designContestDAO")
	protected DesignContestDAO designContestDAO;

	@Autowired
	@Qualifier("designContestJudgesDAO")
	protected DesignContestJudgesDAO designContestJudgesDAO;

	@Autowired
	@Qualifier("designContestEntryDAO")
	protected DesignContestEntryDAO designContestEntryDAO;

	@Autowired
	@Qualifier("designContestEntryMediaDAO")
	protected DesignContestEntryMediaDAO designContestEntryMediaDAO;

	@Autowired
	@Qualifier("designContestEntryVoteDAO")
	protected DesignContestEntryVoteDAO designContestEntryVoteDAO;

	@Autowired
	@Qualifier("designContestUserDAO")
	protected DesignContestUserDAO designContestUserDAO;

	@Autowired
	@Qualifier("designContestResultDAO")
	protected DesignContestResultDAO designContestResultDAO;

	@Autowired
	@Qualifier("designContestNewsDAO")
	protected DesignContestNewsDAO designContestNewsDAO;

	@Autowired
	@Qualifier("cityDAO")
	protected CityDAO cityDAO;

	@Autowired
	@Qualifier("regionDAO")
	protected RegionDAO regionDAO;

	@Autowired
	@Qualifier("provinceDAO")
	protected ProvinceDAO provinceDAO;

	@Autowired
	@Qualifier("requirementsCommentsDAO")
	protected RequirementsCommentsDAO requirementsCommentsDAO;

	@Autowired
	@Qualifier("requirementsSecondCategoryDAO")
	protected RequirementsSecondCategoryDAO requirementsSecondCategoryDAO;

	@Autowired
	@Qualifier("requirementsTopCategoryDAO")
	protected RequirementsTopCategoryDAO requirementsTopCategoryDAO;

	@Autowired
	@Qualifier("requirementsDAO")
	protected RequirementsDAO requirementsDAO;

	@Autowired
	@Qualifier("redisTemplate")
	protected RedisTemplate redisTemplate;

	@Autowired
	@Qualifier("securityService")
	protected SecurityService securityService;

	@Autowired
	@Qualifier("redisAuthenticationProvider")
	protected AuthenticationProvider authenticationProvider;

	@Autowired
	@Qualifier("sequenceService")
	protected SequenceService sequenceService;
	
	protected ItemVO toItem(ItemDO item) {
		ItemVO vo = ItemVO.newInstance(item);
		List<ItemMediaDO> itemMediaList = itemMediaDAO.queryNamed("ItemMedia.getItemMediaByItemId", new Object[] { item.getId() });
		if (!CollectionUtils.isEmpty(itemMediaList)) {
			vo.setItemMediaList(ItemMediaVO.newInstance(itemMediaList));
		}
		vo.setAreaCategory(AreaCategoryVO.newInstance(areaCategoryDAO.get(item.getArea_category_id())));
		vo.setCategory(CategoryVO.newInstance(categoryDAO.get(item.getCategory_id())));
		vo.setStyle(StyleVO.newInstance(styleDAO.get(item.getStyle_id())));
		vo.setLabelList(LabelVO.newInstance(labelDAO.queryNamed("Label.getLabelByItemId", new Object[] { item.getId() })));
		return vo;
	}
	
	protected Result doPrivileged(me.scape.ti.ro.PrivilegedRequest request) {
		PrivilegedRequest checkRequest = new PrivilegedRequest();
		checkRequest.setApp_id(request.getApp_id());
		checkRequest.setOpen_id(request.getOpen_id());
		checkRequest.setAccess_token(request.getAccess_token());
		PrivilegedResponse privilegedResponse = authenticationProvider.doPrivileged(checkRequest);
		if (StringUtils.isBlank(privilegedResponse.getSecret_id())) {
			return Result.newError().with(ResultCode.Error_Token);
		}
		Long user_id = NumberUtils.toLong(privilegedResponse.getSecret_id(), 0L);
		if (user_id <= 0L) {
			return Result.newError().with(ResultCode.Error_Token);
		}
		return Result.newSuccess().with(ResultCode.Success).response(user_id);
	}
	
	protected Result login(Long userId) {
		if(userId == null || userId <= 0L) {
			return Result.newError().with(ResultCode.Error_Login);
		}
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setApp_id(CommonConstant.App_Id);
		loginRequest.setSecret_id(String.valueOf(userId));
		LoginResponse loginResponse = authenticationProvider.doLogin(loginRequest);
		if (loginResponse == null || StringUtils.isEmpty(loginResponse.getAccess_token())) {
			return Result.newError().with(ResultCode.Error_Login);
		}
		return Result.newSuccess().with(ResultCode.Success).response(loginResponse);
	}
	
	protected final long getIp() {
		return WebUtils.ipToLng(WebUtils.getIpAddr(request));
	}

	@Override
	public final void afterPropertiesSet() throws Exception {
		init();
	}

	protected void init() throws Exception {

	}
}