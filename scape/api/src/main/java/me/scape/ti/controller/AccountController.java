package me.scape.ti.controller;

import javax.validation.Valid;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.PrivilegedRequest;
import me.scape.ti.ro.PubfavRequest;
import me.scape.ti.ro.RegisterRequest;
import me.scape.ti.ro.ResetPasswdRequest;
import me.scape.ti.ro.UserProfileRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午2:36:45
 */
@Controller("accountController")
@RequestMapping(value = "/account")
public class AccountController extends BaseController {
	
	@RequestMapping(value = "/profile", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> profile(@Valid UserProfileRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = accountService.updateUserProfile(request);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/iprofile", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> get_profile(@Valid PrivilegedRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = accountService.getProfile(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/register", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> register(@Valid RegisterRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = accountService.register(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> login(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "password", required = true) String password) {
		Result result = accountService.login(name, password);
		return toResponse(result);
	}

	@RequestMapping(value = "/reset_passwd", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> reset_passwd(@Valid ResetPasswdRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = accountService.reset_passwd(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/pubfav", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> pubfav(@Valid PubfavRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = accountService.queryPubOrFavItem(request);
		return toResponse(result);
	}
}