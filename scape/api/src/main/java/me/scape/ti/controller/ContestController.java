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
@RequestMapping(value = "/contest")
public class ContestController extends BaseController {

	@RequestMapping(value = "/active", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> activeDesignContest() {
		Result result = designContestService.getActiveDesignContest();
		return toResponse(result);
	}
	
	@RequestMapping(value = "/judges/{contestId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> item(@PathVariable Integer contestId) {
		Result result = designContestService.getDesignContestJudges(contestId);
		return toResponse(result);
	}
}