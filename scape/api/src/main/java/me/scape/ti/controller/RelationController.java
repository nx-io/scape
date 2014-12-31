package me.scape.ti.controller;

import javax.validation.Valid;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.CommentsRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午3:43:22
 */
@Controller
@RequestMapping(value = "/rel")
public class RelationController extends BaseController {
	
	@RequestMapping(value = "/comments", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> register(@Valid CommentsRequest request, BindingResult validResult) {
		if(validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = relationService.comments(request);
		return toResponse(result);
	}
}