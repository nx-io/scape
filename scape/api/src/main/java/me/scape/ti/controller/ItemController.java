package me.scape.ti.controller;

import javax.validation.Valid;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.ItemPublishRequest;
import me.scape.ti.ro.ItemSearchRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午2:36:45
 */
@Controller("itemController")
public class ItemController extends BaseController {

	@RequestMapping(value = "/item/publish", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> publish(@Valid ItemPublishRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = itemService.publish(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/item/{itemId}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> item(@PathVariable Long itemId) {
		Result result = itemService.getItem(itemId);
		return toResponse(result);
	}

	@RequestMapping(value = "/item/search", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> search(@Valid ItemSearchRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = itemService.search(request);
		return toResponse(result);
	}
}