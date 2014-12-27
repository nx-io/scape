package me.scape.ti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.scape.ti.result.Result;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	public ResponseEntity<String> register(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("request");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String avatar = request.getParameter("avatar");
		Result result = accountService.register(name, password, mobile, avatar);
		return toResponse(result);
	}
}