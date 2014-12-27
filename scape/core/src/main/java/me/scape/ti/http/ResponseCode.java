package me.scape.ti.http;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午2:09:37
 */
public enum ResponseCode {

	Succeed(200L, "成功"),
	
	Failed(300L, "请求失败"),
	
	Error_Permission(-1000L, "非法权限"),
	
	Error_Register(-2000L, "用户注册失败"),
	
	Error_Exception(-3000L, "业务处理失败"),
	
	;
	public final long code;
	public final String message;

	private ResponseCode(long code, String message) {
		this.code = code;
		this.message = message;
	}
}