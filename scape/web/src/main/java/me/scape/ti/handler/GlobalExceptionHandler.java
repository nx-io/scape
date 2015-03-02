package me.scape.ti.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午6:59:48
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		log.error("Handler : " + handler + " Error.", ex);
		ModelAndView mv = new ModelAndView("system_crash");
		return mv;
	}
}