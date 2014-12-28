package me.scape.ti.result;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:39:29
 */
public enum ResultCode {
	Success								(200L, 		"成功"),

	Error_Register						(-1000L, 	"注册失败"),
	
	Error_Register_Mobile				(-1001L, 	"请输入正确的手机号码"),
	
	Error_Register_Name					(-1002L, 	"请输入用户名"),
	
	Error_Register_Passwd				(-1003L, 	"请输入密码"),
	
	Error_Permission					(-2000L, 	"非法权限"),
	
	Error_Exception						(-3000L,	"业务处理失败"),
	
	Error_Valid_Request					(-4000L, 	"数据验证失败"),
	
	Error_Item_Detail					(-5000L, 	"案例不存在"),
	
	Error_Item_Empty					(-6000L, 	"查询不到案例"),
	
	;
	public final long code;
	public final String description;
	
	private ResultCode(long code, String description) {
		this.code = code;
		this.description = description;
	}
}