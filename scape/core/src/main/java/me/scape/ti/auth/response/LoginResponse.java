package me.scape.ti.auth.response;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年2月5日 上午11:31:31
 */
@XStreamAlias(ResponseAlias.Login)
public class LoginResponse {

	public static final LoginResponse DEFAULT_RESPONSE = new LoginResponse(StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY, -1);

	/**
	 * 应用ID
	 */
	@XStreamAlias("app_id")
	private String app_id;

	/**
	 * 用于绑定应用系统用户开放ID
	 */
	@XStreamAlias("open_id")
	private String open_id;

	/**
	 * 访问凭证令牌
	 */
	@XStreamAlias("access_token")
	private String access_token;

	/**
	 * 凭证有效时间，单位：秒
	 */
	@XStreamAlias("expires_in")
	private Integer expires_in;

	public LoginResponse(String app_id, String open_id, String access_token, Integer expires_in) {
		super();
		this.app_id = app_id;
		this.open_id = open_id;
		this.access_token = access_token;
		this.expires_in = expires_in;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getOpen_id() {
		return open_id;
	}

	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
}
