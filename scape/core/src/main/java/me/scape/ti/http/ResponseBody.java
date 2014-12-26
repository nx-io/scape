package me.scape.ti.http;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 上午1:04:35
 */
public class ResponseBody {
	
	private long code;
	private String message;
	private Map<String, Object> data;

	@Override
	public String toString() {
		return new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ").create().toJson(this, ResponseBody.class);
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
	
	public ResponseBody add(String key, Object value) {
		if(data == null) {
			data = new HashMap<String, Object>();
		}
		data.put(key, value);
		return this;
	}
	
	public ResponseBody code(long code) {
		setCode(code);
		return this;
	}
	
	public ResponseBody message(String message) {
		setMessage(message);
		return this;
	}
}