package me.scape.ti.ro;

import java.io.Serializable;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午3:47:18
 */
public class NonPrivilegedPageRequest implements Serializable {

	private static final long serialVersionUID = 2221518914076986816L;
    private Integer page = 1;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
}