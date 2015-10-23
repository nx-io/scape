package me.scape.ti.ro;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午3:07:29
 */
public class ContestEntryVoteRequest extends PrivilegedRequest {

	private static final long serialVersionUID = -5894106911599343141L;
	@NotNull
	private Integer entry_id;// 作品ID

	public Integer getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(Integer entry_id) {
		this.entry_id = entry_id;
	}
}