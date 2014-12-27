package me.scape.ti.controller;

import me.scape.ti.dataobject.UserDO;
import me.scape.ti.http.JSONResponseBody;
import me.scape.ti.http.ResponseCode;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月26日 上午11:55:31
 */
@Controller
public class Test extends BaseController {
	
	@RequestMapping(value = "/test/home", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> test(@RequestParam(value = "name", required = false) final String name) {
		UserDO user = new UserDO();
		user.setAvatar("asas");
		user.setId(123L);
		user.setName(name);
		return JSONResponseBody.newInstance(ResponseCode.Succeed).with("user", user).toResponse();
	}
	
	@RequestMapping(value = "/test/error", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity<String> error() {
		throw new IllegalStateException("test error.");
	}
}