package me.scape.ti.http;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 上午12:51:22
 */
public class JSONResponse extends ResponseEntity {

	public JSONResponse(ResponseBody body, HttpStatus statusCode) {
		super(body, HttpHeader.JSON.headers, statusCode);
	}

}