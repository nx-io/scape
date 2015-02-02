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
 * 景观规划设计赛事比赛结果.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 下午2:25:39
 */
@Entity
@Table(name = "design_contest_result", catalog = "scape")
public class DesignContestResultDO implements Serializable {

	private static final long serialVersionUID = -6254857307014659510L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "contest_id", nullable = false)
	private Integer contest_id;// 赛事ID

	@Column(name = "entry_id", nullable = false)
	private Integer entry_id;// 作品ID

	@Column(name = "ranking", nullable = false)
	private Integer ranking;// 参赛作品排名

	@Column(name = "comment", nullable = false, length = 512)
	private String comment;// 参赛作品评语

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = true)
	private Date gmt_modified;

}