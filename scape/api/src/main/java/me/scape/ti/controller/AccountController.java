package me.scape.ti.controller;

import javax.validation.Valid;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.RegisterRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午2:36:45
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {

	@RequestMapping(value = "/register", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> register(@Valid RegisterRequest registerRequest, BindingResult validResult) {
		if(validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = accountService.register(registerRequest);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/login", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> login(
			@RequestParam(value = "name", required = true) String name, 
			@RequestParam(value = "password", required = true) String password) {
		Result result = accountService.login(name, password);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/reset_passwd", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> reset_passwd(
			@RequestParam(value = "user_id", required = true) Long user_id, 
			@RequestParam(value = "old_passwd", required = true) String old_passwd, 
			@RequestParam(value = "new_passwd", required = true) String new_passwd) {
		Result result = accountService.reset_passwd(user_id, old_passwd, new_passwd);
		return toResponse(result);
	}
}