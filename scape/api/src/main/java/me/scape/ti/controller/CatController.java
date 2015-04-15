package me.scape.ti.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月29日 下午11:27:45
 */
@Controller("catController")
public class CatController extends BaseController {

	@RequestMapping(value = "/item/cat", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> cat() {
		return toResponse(catService.getAllCat());
	}

	@RequestMapping(value = "/item/area", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> area() {
		return toResponse(catService.getAllAreaCat());
	}

	@RequestMapping(value = "/item/style", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> style() {
		return toResponse(catService.getAllStyle());
	}
}