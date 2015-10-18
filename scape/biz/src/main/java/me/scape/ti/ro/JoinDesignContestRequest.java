package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午4:10:13
 */
public class JoinDesignContestRequest extends PrivilegedRequest {

	private static final long serialVersionUID = -7388308650831810217L;
    @NotEmpty
	private Integer contestId;

	public Integer getContestId() {
		return contestId;
	}

	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
}