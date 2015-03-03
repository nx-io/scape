package me.scape.ti.srv;

import javax.servlet.http.HttpServletRequest;

import me.scape.ti.auth.AuthService;
import me.scape.ti.auth.request.CheckRequest;
import me.scape.ti.auth.request.LoginRequest;
import me.scape.ti.auth.response.CheckResponse;
import me.scape.ti.auth.response.LoginResponse;
import me.scape.ti.dao.AreaCategoryDAO;
import me.scape.ti.dao.CategoryDAO;
import me.scape.ti.dao.CommentsDAO;
import me.scape.ti.dao.DesignContestDAO;
import me.scape.ti.dao.DesignContestEntryDAO;
import me.scape.ti.dao.DesignContestEntryMediaDAO;
import me.scape.ti.dao.DesignContestEntryVoteDAO;
import me.scape.ti.dao.DesignContestJudgesDAO;
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
import me.scape.ti.dao.RoleDAO;
import me.scape.ti.dao.StyleDAO;
import me.scape.ti.dao.SystemSettingDAO;
import me.scape.ti.dao.UserDAO;
import me.scape.ti.dao.UserFavoriteDAO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.PrivilegedRequest;
import me.scape.ti.utils.WebUtils;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
	@Qualifier(value = "areaCategoryDAO")
	protected AreaCategoryDAO areaCategoryDAO;

	@Autowired
	@Qualifier(value = "categoryDAO")
	protected CategoryDAO categoryDAO;

	@Autowired
	@Qualifier(value = "commentsDAO")
	protected CommentsDAO commentsDAO;

	@Autowired
	@Qualifier(value = "itemDAO")
	protected ItemDAO itemDAO;

	@Autowired
	@Qualifier(value = "itemFavoriteDAO")
	protected ItemFavoriteDAO itemFavoriteDAO;

	@Autowired
	@Qualifier(value = "itemMediaDAO")
	protected ItemMediaDAO itemMediaDAO;

	@Autowired
	@Qualifier(value = "labelDAO")
	protected LabelDAO labelDAO;

	@Autowired
	@Qualifier(value = "managerDAO")
	protected ManagerDAO managerDAO;

	@Autowired
	@Qualifier(value = "roleDAO")
	protected RoleDAO roleDAO;

	@Autowired
	@Qualifier(value = "styleDAO")
	protected StyleDAO styleDAO;

	@Autowired
	@Qualifier(value = "userDAO")
	protected UserDAO userDAO;

	@Autowired
	@Qualifier(value = "userFavoriteDAO")
	protected UserFavoriteDAO userFavoriteDAO;

	@Autowired
	@Qualifier(value = "plantCategoryDAO")
	protected PlantCategoryDAO plantCategoryDAO;

	@Autowired
	@Qualifier(value = "plantsColorRelDAO")
	protected PlantsColorRelDAO plantsColorRelDAO;

	@Autowired
	@Qualifier(value = "plantsDAO")
	protected PlantsDAO plantsDAO;

	@Autowired
	@Qualifier(value = "plantsOrnamentalColorDAO")
	protected PlantsOrnamentalColorDAO plantsOrnamentalColorDAO;

	@Autowired
	@Qualifier(value = "plantsOrnamentalPeriodDAO")
	protected PlantsOrnamentalPeriodDAO plantsOrnamentalPeriodDAO;

	@Autowired
	@Qualifier(value = "plantsPeriodRelDAO")
	protected PlantsPeriodRelDAO plantsPeriodRelDAO;

	@Autowired
	@Qualifier(value = "plantMediaDAO")
	protected PlantMediaDAO plantMediaDAO;

	@Autowired
	@Qualifier(value = "systemSettingDAO")
	protected SystemSettingDAO systemSettingDAO;

	@Autowired
	@Qualifier(value = "designContestDAO")
	protected DesignContestDAO designContestDAO;

	@Autowired
	@Qualifier(value = "designContestJudgesDAO")
	protected DesignContestJudgesDAO designContestJudgesDAO;

	@Autowired
	@Qualifier(value = "designContestEntryDAO")
	protected DesignContestEntryDAO designContestEntryDAO;

	@Autowired
	@Qualifier(value = "designContestEntryMediaDAO")
	protected DesignContestEntryMediaDAO designContestEntryMediaDAO;

	@Autowired
	@Qualifier(value = "designContestEntryVoteDAO")
	protected DesignContestEntryVoteDAO designContestEntryVoteDAO;

	@Autowired
	@Qualifier(value = "designContestUserDAO")
	protected DesignContestUserDAO designContestUserDAO;

	@Autowired
	@Qualifier(value = "designContestResultDAO")
	protected DesignContestResultDAO designContestResultDAO;
	
	protected Result doPrivileged(PrivilegedRequest request) {
		CheckRequest checkRequest = new CheckRequest();
		checkRequest.setApp_id(request.getApp_id());
		checkRequest.setOpen_id(request.getOpen_id());
		checkRequest.setAccess_token(request.getAccess_token());
		CheckResponse checkResponse = AuthService.check(checkRequest);
		if (StringUtils.isBlank(checkResponse.getSecret_id())) {
			return Result.newError().with(ResultCode.Error_Token);
		}
		Long user_id = NumberUtils.toLong(checkResponse.getSecret_id(), 0L);
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
		loginRequest.setApp_id(AuthService.App_Id);
		loginRequest.setSecret_id(String.valueOf(userId));
		LoginResponse loginResponse = AuthService.login(loginRequest);
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