package me.scape.ti.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.scape.ti.http.JSONResponseBody;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.srv.AccountService;
import me.scape.ti.srv.CatService;
import me.scape.ti.srv.CommonService;
import me.scape.ti.srv.ItemService;
import me.scape.ti.srv.PlantService;
import me.scape.ti.srv.RelationService;
import me.scape.ti.utils.CalendarUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	@Autowired
	@Qualifier(value = "accountService")
	protected AccountService accountService;

	@Autowired
	@Qualifier(value = "itemService")
	protected ItemService itemService;

	@Autowired
	@Qualifier(value = "catService")
	protected CatService catService;

	@Autowired
	@Qualifier(value = "relationService")
	protected RelationService relationService;

	@Autowired
	@Qualifier(value = "commonService")
	protected CommonService commonService;

	@Autowired
	@Qualifier(value = "plantService")
	protected PlantService plantService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(CalendarUtil.S_YYYY_MM_DD_HH_MM_SS);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public final ResponseEntity<String> handleException(final Throwable ex) {
		log.error("Api Request Error.", ex);
		return toResponse(Result.newError().with(ResultCode.Error_Exception), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	protected ResponseEntity<String> toResponse(Result result) {
		return JSONResponseBody.newInstance().code(result.getResultCode()).message(result.getMessage())
				.with(result.getData()).toResponse();
	}
	
	protected ResponseEntity<String> toResponse(Result result, HttpStatus status) {
		return JSONResponseBody.newInstance().code(result.getResultCode()).message(result.getMessage())
				.with(result.getData()).toResponse(status);
	}
}