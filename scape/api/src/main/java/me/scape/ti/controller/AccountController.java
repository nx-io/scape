package me.scape.ti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.RegisterRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<String> register(
			@Valid RegisterRequest registerRequest,
			BindingResult validResult,
			HttpServletRequest request, HttpServletResponse response) {
		if(validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = accountService.register(registerRequest);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/login", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Result result = accountService.login(name, password);
		return toResponse(result);
	}
}