package me.scape.ti.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 景观规划设计赛事参赛者.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午10:30:02
 */
@Entity
@Table(name = "design_contest_user", catalog = "scape")
public class DesignContestUserDO implements Serializable {

	private static final long serialVersionUID = -7782042921818978205L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "contest_id", nullable = false)
	private Integer contest_id;// 赛事ID

	@Column(name = "user_id", nullable = false)
	private Long user_id;// 参赛者

	@Column(name = "number", unique = true, nullable = false, length = 64)
	private String number;// 参赛编号

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = true)
	private Date gmt_modified;

}