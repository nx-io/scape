package me.scape.ti.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.CommentsRequest;
import me.scape.ti.ro.ItemFavoriteRequest;
import me.scape.ti.ro.PrivilegedPageRequest;
import me.scape.ti.ro.UserFavoriteRequest;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午3:43:22
 */
@Controller("relationController")
@RequestMapping(value = "/rel")
public class RelationController extends BaseController {

	@RequestMapping(value = "/comments", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> comments(@Valid CommentsRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = relationService.comments(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/ifav", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> favorite_item(@Valid ItemFavoriteRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = relationService.favorite_item(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/ifav/items", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> get_favorite_items(@Valid PrivilegedPageRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = relationService.getFavoriteItems(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/ufav", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> favorite_user(@Valid UserFavoriteRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = relationService.favorite_user(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/ufav/users", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> get_favorite_user(@Valid PrivilegedPageRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = relationService.getFavoriteUsers(request);
		return toResponse(result);
	}
}