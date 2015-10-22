package me.scape.ti.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.ContestEntryRequest;
import me.scape.ti.ro.ContestEntryVoteRequest;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午2:36:45
 */
@Controller("contestController")
@RequestMapping(value = "/contest")
public class ContestController extends BaseController {

	@RequestMapping(value = "/active", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> activeDesignContest() {
		Result result = designContestService.getActiveDesignContest();
		return toResponse(result);
	}
	
	@RequestMapping(value = "/vote", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> vote(@Valid ContestEntryVoteRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = designContestService.contestEntryVote(request);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/entry", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> entryList(@Valid ContestEntryRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = designContestService.getContestEntryList(request);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/entry/{entryId}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> entry(@PathVariable Integer entryId) {
		Result result = designContestService.getContestEntry(entryId);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/judges/{contestId}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> judges(@PathVariable Integer contestId) {
		Result result = designContestService.getDesignContestJudges(contestId);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/news/{contestId}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> news(@PathVariable Integer contestId) {
		Result result = designContestService.getDesignContestNews(contestId);
		return toResponse(result);
	}
}