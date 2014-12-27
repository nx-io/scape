package me.scape.ti.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.scape.ti.http.JSONResponseBody;
import me.scape.ti.http.ResponseCode;
import me.scape.ti.utils.CalendarUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午2:38:54
 */
public class BaseController {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CalendarUtil.S_YYYY_MM_DD_HH_MM_SS);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@ExceptionHandler(Throwable.class)
    @ResponseBody
    public final ResponseEntity<String> handleException(final Throwable ex) {
		log.error("Api Error.", ex);
		return JSONResponseBody.newInstance(ResponseCode.Error_Exception).toResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}