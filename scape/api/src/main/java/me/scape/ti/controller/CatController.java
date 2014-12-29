package me.scape.ti.controller;

import me.scape.ti.result.Result;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月29日 下午8:56:23
 */
@Controller
public class CatController extends BaseController {
	
	@RequestMapping(value = "/cat/{catId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> cat(@PathVariable Long catId) {
		Result result = itemService.getItem(catId);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/acat/{catId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> item(@PathVariable Long catId) {
		Result result = itemService.getItem(catId);
		return toResponse(result);
	}
}