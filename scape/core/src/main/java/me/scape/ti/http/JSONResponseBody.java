package me.scape.ti.http;

import java.util.HashMap;
import java.util.Map;

import me.scape.ti.gson.GsonUtils;

import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 上午1:04:35
 */
public class JSONResponseBody {

	private long code;
	private String message;
	private Map<String, Object> data;

	public static JSONResponseBody newInstance() {
		return new JSONResponseBody();
	}

	public JSONResponseBody() {
		super();
	}

	public JSONResponse toResponse() {
		return JSONResponse.newInstance(this);
	}

	public JSONResponse toResponse(HttpStatus statusCode) {
		return JSONResponse.newInstance(this, statusCode);
	}

	public String toJson() {
		return GsonUtils.GSON.toJson(this, JSONResponseBody.class);
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

	public JSONResponseBody with(Map<String, Object> data) {
		if (CollectionUtils.isEmpty(data)) {
			return this;
		}
		if (this.data == null) {
			this.data = new HashMap<String, Object>();
		}
		this.data.putAll(data);
		return this;
	}

	public JSONResponseBody with(String key, Object value) {
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		data.put(key, value);
		return this;
	}

	public JSONResponseBody with(long code, String message) {
		setCode(code);
		setMessage(message);
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