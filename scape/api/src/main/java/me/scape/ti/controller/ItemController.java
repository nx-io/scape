package me.scape.ti.controller;

import me.scape.ti.result.Result;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午2:36:45
 */
@Controller
public class ItemController extends BaseController {

	@RequestMapping(value = "/item/{itemId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> item(@PathVariable Long itemId) {
		Result result = accountService.register(null);
		return toResponse(result);
	}
}