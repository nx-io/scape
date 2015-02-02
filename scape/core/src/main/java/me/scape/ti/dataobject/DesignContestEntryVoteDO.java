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
 * 景观规划设计赛事参赛作品投票.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 上午11:03:23
 */
@Entity
@Table(name = "design_contest_entry_vote", catalog = "scape")
public class DesignContestEntryVoteDO implements Serializable {

	private static final long serialVersionUID = 2844313934431274360L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "entry_id", nullable = false)
	private Integer entry_id;// 作品ID

	@Column(name = "voter_id", nullable = false)
	private Long voter_id;// 投票者

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = true)
	private Date gmt_modified;

}