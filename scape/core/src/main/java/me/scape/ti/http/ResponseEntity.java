package me.scape.ti.http;

import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 上午12:42:46
 */
public class ResponseEntity extends org.springframework.http.ResponseEntity<String> {
	
	public ResponseEntity(ResponseBody body, MultiValueMap<String, String> headers, HttpStatus statusCode) {
		super(body.toString(), headers, statusCode);
	}
}