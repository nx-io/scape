package me.scape.ti.controller;

import javax.validation.Valid;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.PublishRequirementsRequest;
import me.scape.ti.ro.RequirementsSearchRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午2:36:45
 */
@Controller("requirementsController")
@RequestMapping(value = "/require")
public class RequirementsController extends BaseController {

	@RequestMapping(value = "/publish", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> publish(@Valid PublishRequirementsRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = requirementsService.publishRequirements(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/{requireId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> requirements(@PathVariable Long requireId) {
		Result result = requirementsService.getRequirements(requireId);
		return toResponse(result);
	}

	@RequestMapping(value = "/cats/top", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> topCategoryList() {
		Result result = requirementsService.getTopCategoryList();
		return toResponse(result);
	}

	@RequestMapping(value = "/cats/{topCatId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> secondCategoryList(@PathVariable Integer topCatId) {
		Result result = requirementsService.getSecondCategoryList(topCatId);
		return toResponse(result);
	}

	@RequestMapping(value = "/search", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> search(@Valid RequirementsSearchRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = requirementsService.search(request);
		return toResponse(result);
	}
}