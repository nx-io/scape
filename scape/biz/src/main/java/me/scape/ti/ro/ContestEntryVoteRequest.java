package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午3:07:29
 */
public class ContestEntryVoteRequest extends BaseRequest {

	@NotEmpty
	private Integer entry_id;// 作品ID

	public Integer getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(Integer entry_id) {
		this.entry_id = entry_id;
	}
}