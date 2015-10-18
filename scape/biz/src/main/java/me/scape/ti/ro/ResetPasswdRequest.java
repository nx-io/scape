package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 重置密码请求
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午3:33:06
 */
public class ResetPasswdRequest extends PrivilegedRequest {

	private static final long serialVersionUID = 7938620520315533234L;

    @NotEmpty
	private String old_passwd;

	@NotEmpty
	private String new_passwd;

	public String getOld_passwd() {
		return old_passwd;
	}

	public void setOld_passwd(String old_passwd) {
		this.old_passwd = old_passwd;
	}

	public String getNew_passwd() {
		return new_passwd;
	}

	public void setNew_passwd(String new_passwd) {
		this.new_passwd = new_passwd;
	}
}