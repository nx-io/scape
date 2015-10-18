package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月18日 下午2:53:44
 */
public class PubfavRequest extends PrivilegedPageRequest {

	private static final long serialVersionUID = -8429914125637434058L;
    @NotEmpty
	private Byte type;

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}
}