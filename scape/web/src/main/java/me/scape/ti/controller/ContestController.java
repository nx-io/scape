package me.scape.ti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.scape.ti.result.Result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 比赛.
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年3月2日 下午10:56:18
 */
@Controller
@RequestMapping(value = "/contest")
public class ContestController extends BaseController {

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
//		Result result = designContestService.getActiveDesignContest();
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("about");
	}
	
	@RequestMapping(value = "/organization")
	public ModelAndView organization(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("organization");
	}
	
	@RequestMapping(value = "/works")
	public ModelAndView works(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("works");
	}
}