package me.scape.ti.dataobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 植物.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 上午10:19:35
 */
@Entity
@Table(name = "plants", catalog = "scape")
public class PlantsDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "cat_id", nullable = false)
	private Long catId;

	@Column(name = "color_id", nullable = false)
	private Long colorId;

	@Column(name = "period_id", nullable = false)
	private Long periodId;

	private String nameCn;// 中文名
	
	private String shortNameCn;// 中文名简称
	
	private String nameEn;// 英文名
	
	private String shortNameEn;// 英文名简称

	private String aliasName;// 别名

	private String genus;// 科属

	private String habits;// 习性

}