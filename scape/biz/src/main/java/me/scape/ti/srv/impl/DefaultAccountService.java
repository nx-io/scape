package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.ocs.oauth.token.response.LoginResponse;
import me.scape.ti.commons.SequenceType;
import me.scape.ti.dataobject.CityDO;
import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.dataobject.ProvinceDO;
import me.scape.ti.dataobject.UserDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.PrivilegedRequest;
import me.scape.ti.ro.PubfavRequest;
import me.scape.ti.ro.RegisterRequest;
import me.scape.ti.ro.ResetPasswdRequest;
import me.scape.ti.ro.UserProfileRequest;
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
	public Result getProfile(PrivilegedRequest request) {
		Result privileged = doPrivileged(request);
		if (!privileged.isSuccess()) {
			return privileged;
		}
		Long userId = privileged.getResponse(Long.class);
		UserDO user = userDAO.get(userId);
		return Result.newSuccess().with(ResultCode.Success).with("user", UserVO.newInstance(user));
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result updateUserProfile(UserProfileRequest request) {
		Result privileged = doPrivileged(request);
		if (!privileged.isSuccess()) {
			return privileged;
		}
        String name = request.getName();// 设计师/企业名称
		UserDO u = userDAO.queryForObject("FROM UserDO u WHERE u.name = ?", new Object[] { name });
        if (u != null) {
            return Result.newError().with(ResultCode.Error_User_Exist);
        }
        
		Long userId = privileged.getResponse(Long.class);
		UserDO user = userDAO.get(userId);
		if (StringUtils.isNotBlank(name)) {
			user.setName(name);
		}
		String fullname = request.getFullname();// 真实姓名
		if (StringUtils.isNotBlank(fullname)) {
			user.setFullname(fullname);
		}
		String avatar = request.getAvatar();// 头像
		if (StringUtils.isNotBlank(avatar)) {
			user.setAvatar(avatar);
		}
		String contact = request.getContact();// 联系方式
		if (StringUtils.isNotBlank(contact)) {
			user.setContact(contact);
		}
		Long category_id = request.getCategory_id();// 特长
		if (category_id != null && category_id > 0L) {
			user.setCategory_id(category_id);
		}
		String profile = request.getProfile();// 简介
		if (StringUtils.isNotBlank(profile)) {
			user.setProfile(profile);
		}
		Integer province_id = request.getProvince_id();// 省
		if (province_id != null && province_id > 0) {
			ProvinceDO province = provinceDAO.get(province_id);
			if (province != null) {
				user.setProvince_id(province_id);
				user.setProvince(province.getName());
			}
		}
		Integer city_id = request.getCity_id();// 市
		if (city_id != null && city_id > 0) {
			CityDO city = cityDAO.get(city_id);
			if (city != null) {
				user.setCity_id(city_id);
				user.setCity(city.getName());
			}
		}
		userDAO.merge(user);
		return Result.newSuccess().with(ResultCode.Success).with("user", UserVO.newInstance(user));
	}

	@Override
	public Result queryPubOrFavItem(PubfavRequest request) {
		Result privileged = doPrivileged(request);
		if (!privileged.isSuccess()) {
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
		if (!privileged.isSuccess()) {
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
		if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
			return Result.newError().with(ResultCode.Error_User_Login_Info);
		}
		UserDO user = userDAO.queryForObject("FROM UserDO u WHERE u.name = ?", new Object[] { name });
		if (user == null) {
			return Result.newError().with(ResultCode.Error_User_Not_Exist);
		}
		if (!StringUtils.equals(PasswdUtils.signPwsswd(password, user.getSalt()), user.getPassword())) {
			return Result.newError().with(ResultCode.Error_User_NameOrPasswd);
		}
		Date now = new Date();
		user.setGmt_modified(now);
		user.setLast_ip(getIp());
		user.setLast_login(now);
		userDAO.merge(user);
		Result login = login(user.getId());
		if (!login.isSuccess()) {
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
		Long uc = userDAO.createQuery("SELECT COUNT(u.id) FROM UserDO u WHERE u.name = ?", Long.class, new Object[] { name }).getSingleResult();
		if (uc != null && uc > 0L) {
			return Result.newError().with(ResultCode.Error_Register_User_Exist);
		}
		uc = userDAO.createQuery("SELECT COUNT(u.id) FROM UserDO u WHERE u.mobile = ?", Long.class, new Object[] { request.getMobile() }).getSingleResult();
		if (uc != null && uc > 0L) {
			return Result.newError().with(ResultCode.Error_Register_User_Exist);
		}
		UserDO user = new UserDO();
		user.setGuid(sequenceService.nextValueAsStringWithCreate(SequenceType.USER_GUID_SEQUENCE, 25, 1L));
		user.setAvatar(avatar);
		user.setName(name);
		user.setMobile(mobile);
		String token = TokenUtils.generate();
		user.setSalt(token);
		user.setPassword(PasswdUtils.signPwsswd(password, token));
		user.setStatus(UserDO.Available);
		user.setLast_ip(getIp());
		user.setAttention_count(0L);
		user.setItem_count(0L);
		Date now = new Date();
		user.setGmt_created(now);
		user.setGmt_modified(now);
		user.setLast_login(now);
		try {
			userDAO.persist(user);
			Result login = login(user.getId());
			if (!login.isSuccess()) {
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