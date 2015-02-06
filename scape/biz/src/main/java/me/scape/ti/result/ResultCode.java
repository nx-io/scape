package me.scape.ti.result;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:39:29
 */
public enum ResultCode {
	Success(200L, "成功"),

	Error_Register(-1000L, "注册失败"),

	Error_Register_Mobile(-1001L, "请输入正确的手机号码"),

	Error_Register_Name(-1002L, "请输入用户名"),

	Error_Register_Passwd(-1003L, "请输入密码"),

	Error_Register_User_Exist(-1004L, "用户名已注册"),

	Error_Permission(-2000L, "非法权限"),

	Error_User_Not_Exist(-2001L, "用户不存在"),

	Error_User_Passwd(-2002L, "密码错误"),

	Error_Exception(-3000L, "System Business Error."),

	Error_Valid_Request(-4000L, "数据验证失败"),

	Error_Item_Detail(-5000L, "案例不存在"),

	Error_Item_Empty(-6000L, "查询不到案例"),

	Error_Favorite_Item_Empty(-7000L, "无收藏案例"),

	Error_Favorited(-7001L, "不能重复收藏或者赞"),

	Error_User_Favorited(-7002L, "对不起！您已经收藏改用户"),

	Error_Favorite_User_Empty(-8000L, "无收藏用户"),

	Error_Plants_Empty(-9000L, "查询不到植物"),

	Error_Empty_Setting(-10000L, "查询配置项"),

	Error_Login(-10005L, "登录失败"),

	Error_Token(-10006L, "用户登录token校验失败"),

	;
	public final long code;
	public final String description;

	private ResultCode(long code, String description) {
		this.code = code;
		this.description = description;
	}
}