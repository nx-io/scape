package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.auth.response.LoginResponse;
import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.dataobject.UserDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.PubfavRequest;
import me.scape.ti.ro.RegisterRequest;
import me.scape.ti.ro.ResetPasswdRequest;
import me.scape.ti.srv.AccountService;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.PageQuery;
import me.scape.ti.utils.PasswdUtils;
import me.scape.ti.utils.TokenUtils;
import me.scape.ti.utils.ValidationUtils;
import me.scape.ti.vo.ItemVO;
import me.scape.ti.vo.UserVO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * 账户相关的业务。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:29:58
 */
@Service("accountService")
public class DefaultAccountService extends BaseService implements AccountService {

	@Override
	public Result queryPubOrFavItem(PubfavRequest request) {
		Result privileged = doPrivileged(request);
		if(!privileged.isSuccess()) {
			return privileged;
		}
		Long userId = privileged.getResponse(Long.class);
		Map<String, Object> args = new HashMap<String, Object>();
		Integer page = request.getPage();
		page = (page != null && page > 0) ? page : 1;
		PageQuery pageQuery = new PageQuery(page);
		args.put("start", pageQuery.getIndex());
		args.put("size", pageQuery.getSize());
		args.put("user_id", userId);
		args.put("type", request.getType());
		String sql = "SELECT * FROM item i WHERE i.user_id = :user_id AND i.type = :type ORDER BY i.gmt_created DESC LIMIT :start, :size";
		List<ItemDO> itemList = itemDAO.queryNative(sql, args);
		if (CollectionUtils.isEmpty(itemList)) {
			return Result.newError().with(ResultCode.Error_Item_Empty);
		}
		List<ItemVO> voList = new ArrayList<ItemVO>();
		for (ItemDO itemDO : itemList) {
			ItemVO vo = ItemVO.newInstance(itemDO);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return Result.newSuccess().with(ResultCode.Success).with("itemList", voList);
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result reset_passwd(ResetPasswdRequest request) {
		Result privileged = doPrivileged(request);
		if(!privileged.isSuccess()) {
			return privileged;
		}
		Long userId = privileged.getResponse(Long.class);
		UserDO user = userDAO.get(userId);
		if (user == null) {
			return Result.newError().with(ResultCode.Error_User_Not_Exist);
		}
		if (!StringUtils.equals(PasswdUtils.signPwsswd(request.getOld_passwd(), user.getSalt()), user.getPassword())) {
			return Result.newError().with(ResultCode.Error_User_Passwd);
		}
		String token = TokenUtils.generate();
		user.setSalt(token);
		user.setPassword(PasswdUtils.signPwsswd(request.getNew_passwd(), token));
		userDAO.merge(user);
		return Result.newSuccess().with(ResultCode.Success).with("user", UserVO.newInstance(user));
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result login(String name, String password) {
		if (StringUtils.isBlank(name)) {
			return Result.newError().with(ResultCode.Error_Permission);
		}
		if (StringUtils.isBlank(password)) {
			return Result.newError().with(ResultCode.Error_Permission);
		}
		UserDO user = userDAO.queryNamedForObject("User.getUserByName", new Object[] { name });
		if (user == null) {
			return Result.newError().with(ResultCode.Error_Permission);
		}
		if (!StringUtils.equals(PasswdUtils.signPwsswd(password, user.getSalt()), user.getPassword())) {
			return Result.newError().with(ResultCode.Error_Permission);
		}
		Date now = new Date();
		user.setGmt_modified(now);
		user.setLast_ip(getIp());
		user.setLast_login(now);
		userDAO.merge(user);
		// 安全登录
		Result login = login(user.getId());
		if(!login.isSuccess()) {
			return login;
		}
		LoginResponse loginResponse = login.getResponse(LoginResponse.class);
		UserVO vo = UserVO.newInstance(user);
		vo.setApp_id(loginResponse.getApp_id());
		vo.setOpen_id(loginResponse.getOpen_id());
		vo.setAccess_token(loginResponse.getAccess_token());
		vo.setExpires_in(loginResponse.getExpires_in());
		return Result.newSuccess().with(ResultCode.Success).with("user", vo);
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result register(RegisterRequest request) {
		String name = request.getName();
		String password = request.getPassword();
		String mobile = request.getMobile();
		String avatar = request.getAvatar();
		if (StringUtils.isBlank(name)) {
			return Result.newError().with(ResultCode.Error_Register_Name);
		}
		if (StringUtils.isBlank(password)) {
			return Result.newError().with(ResultCode.Error_Register_Passwd);
		}
		if (!ValidationUtils.isMobilePhoneNumber(mobile)) {
			return Result.newError().with(ResultCode.Error_Register_Mobile);
		}
		Long uc = userDAO.createNamedQuery("User.existUserByName", Long.class, new Object[] { name }).getSingleResult();
		if (uc != null && uc > 0L) {
			return Result.newError().with(ResultCode.Error_Register_User_Exist);
		}
		uc = userDAO.createNamedQuery("User.existUserByMobile", Long.class, new Object[] { request.getMobile() }).getSingleResult();
		if (uc != null && uc > 0L) {
			return Result.newError().with(ResultCode.Error_Register_User_Exist);
		}
		UserDO user = new UserDO();
		user.setAvatar(avatar);
		user.setName(name);
		user.setMobile(mobile);
		String token = TokenUtils.generate();
		user.setSalt(token);
		user.setPassword(PasswdUtils.signPwsswd(password, token));
		user.setStatus(UserDO.Available);
		user.setLast_ip(getIp());
		Date now = new Date();
		user.setGmt_created(now);
		user.setGmt_modified(now);
		user.setLast_login(now);
		try {
			userDAO.persist(user);
			// 安全登录
			Result login = login(user.getId());
			if(!login.isSuccess()) {
				return login;
			}
			LoginResponse loginResponse = login.getResponse(LoginResponse.class);
			UserVO vo = UserVO.newInstance(user);
			vo.setApp_id(loginResponse.getApp_id());
			vo.setOpen_id(loginResponse.getOpen_id());
			vo.setAccess_token(loginResponse.getAccess_token());
			vo.setExpires_in(loginResponse.getExpires_in());
			return Result.newSuccess().with(ResultCode.Success).with("user", vo);
		} catch (Exception e) {
			log.error("Account Register Error.", e);
		}
		return Result.newError().with(ResultCode.Error_Register);
	}
}