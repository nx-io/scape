package me.scape.ti.controller;

import javax.validation.Valid;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.CommentsRequest;
import me.scape.ti.ro.ItemFavoriteRequest;
import me.scape.ti.ro.UserFavoriteRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<String> comments(@Valid CommentsRequest request, BindingResult validResult) {
		if(validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = relationService.comments(request);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/ifav", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> favorite_item(@Valid ItemFavoriteRequest request, BindingResult validResult) {
		if(validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = relationService.favorite_item(request);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/ifav/{userId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> get_favorite_items(@PathVariable Long userId, 
			@RequestParam(value = "page", required = false) int page) {
		Result result = relationService.getFavoriteItems(userId, page);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/ufav", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> favorite_user(@Valid UserFavoriteRequest request, BindingResult validResult) {
		if(validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = relationService.favorite_user(request);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/ufav/{userId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> get_favorite_user(@PathVariable Long userId, 
			@RequestParam(value = "page", required = false) int page) {
		Result result = relationService.getFavoriteUsers(userId, page);
		return toResponse(result);
	}
}