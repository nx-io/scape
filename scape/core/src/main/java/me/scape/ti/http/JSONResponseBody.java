package me.scape.ti.http;

import java.util.HashMap;
import java.util.Map;

import me.scape.ti.utils.CalendarUtil;

import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 上午1:04:35
 */
public class JSONResponseBody {
	
	private final static Gson GSON = new GsonBuilder().disableHtmlEscaping().setDateFormat(CalendarUtil.S_YYYY_MM_DD_HH_MM_SS).create();
	
	private long code;
	private String message;
	private Map<String, Object> data;

	public static JSONResponseBody newInstance() {
		return new JSONResponseBody();
	}
	
	public static JSONResponseBody newInstance(ResponseCode responseCode) {
		return new JSONResponseBody(responseCode);
	}
	
	public JSONResponseBody() {
		super();
	}
	
	public JSONResponseBody(ResponseCode responseCode) {
		code(responseCode.code).message(responseCode.message);
	}
	
	public JSONResponseBody with(ResponseCode responseCode) {
		return code(responseCode.code).message(responseCode.message);
	}
	
	public JSONResponse toResponse() {
		return JSONResponse.newInstance(this);
	}
	
	public JSONResponse toResponse(HttpStatus statusCode) {
		return JSONResponse.newInstance(this, statusCode);
	}

	public String toJson() {
		return GSON.toJson(this, JSONResponseBody.class);
	}
	
	@Override
	public String toString() {
		return toJson();
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public JSONResponseBody with(String key, Object value) {
		if(data == null) {
			data = new HashMap<String, Object>();
		}
		data.put(key, value);
		return this;
	}
	
	public JSONResponseBody code(long code) {
		setCode(code);
		return this;
	}
	
	public JSONResponseBody message(String message) {
		setMessage(message);
		return this;
	}
}