package me.scape.ti.controller;

import javax.validation.Valid;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.TalentsSearchRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月26日 下午5:10:00
 */
@Controller("talentsController")
@RequestMapping(value = "/talents")
public class TalentsController extends BaseController {

	@RequestMapping(value = "/search", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> search(@Valid TalentsSearchRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = talentsService.search(request);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/{guid}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> talents(@PathVariable String guid) {
		Result result = talentsService.queryTalents(guid);
		return toResponse(result);
	}
}