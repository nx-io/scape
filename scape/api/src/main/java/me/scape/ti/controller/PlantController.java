package me.scape.ti.controller;

import javax.validation.Valid;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.PlantSearchRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月27日 下午11:51:36
 */
@Controller
public class PlantController extends BaseController {
	
	@RequestMapping(value = "/plant/search", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> search(@Valid PlantSearchRequest request, BindingResult validResult) {
		if(validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = plantService.search(request);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/plant/cats", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> cats() {
		Result result = plantService.getCats();
		return toResponse(result);
	}
	
	@RequestMapping(value = "/plant/colors", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> colors() {
		Result result = plantService.getColors();
		return toResponse(result);
	}
	
	@RequestMapping(value = "/plant/periods", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> periods() {
		Result result = plantService.getPeriods();
		return toResponse(result);
	}
}