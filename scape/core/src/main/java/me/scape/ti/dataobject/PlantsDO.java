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

	private static final long serialVersionUID = 7551940138202490992L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "cat_id", nullable = false)
	private Integer cat_id;

	@Column(name = "name_cn", nullable = false, length = 255)
	private String name_cn;// 中文名

	@Column(name = "short_name_cn", nullable = true, length = 45)
	private String short_name_cn;// 中文名简称

	@Column(name = "name_en", nullable = false, length = 255)
	private String name_en;// 英文名

	@Column(name = "short_name_en", nullable = true, length = 45)
	private String short_name_en;// 英文名简称

	@Column(name = "alias_name", nullable = true, length = 255)
	private String alias_name;// 别名

	@Column(name = "cover_media", nullable = false, length = 255)
	private String cover_media;// 植物封皮

	@Column(name = "genus", nullable = true, length = 45)
	private String genus;// 科属

	@Column(name = "habits", nullable = true, length = 1024)
	private String habits;// 习性

	@Column(name = "garden_utilization", nullable = true, length = 1024)
	private String garden_utilization;// 园林用途

	@Column(name = "area_applicable", nullable = true, length = 1024)
	private String area_applicable;// 适用地区

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = true)
	private Date gmt_modified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCat_id() {
		return cat_id;
	}

	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}

	public String getName_cn() {
		return name_cn;
	}

	public void setName_cn(String name_cn) {
		this.name_cn = name_cn;
	}

	public String getShort_name_cn() {
		return short_name_cn;
	}

	public void setShort_name_cn(String short_name_cn) {
		this.short_name_cn = short_name_cn;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public String getShort_name_en() {
		return short_name_en;
	}

	public void setShort_name_en(String short_name_en) {
		this.short_name_en = short_name_en;
	}

	public String getAlias_name() {
		return alias_name;
	}

	public void setAlias_name(String alias_name) {
		this.alias_name = alias_name;
	}

	public String getCover_media() {
		return cover_media;
	}

	public void setCover_media(String cover_media) {
		this.cover_media = cover_media;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getHabits() {
		return habits;
	}

	public void setHabits(String habits) {
		this.habits = habits;
	}

	public String getGarden_utilization() {
		return garden_utilization;
	}

	public void setGarden_utilization(String garden_utilization) {
		this.garden_utilization = garden_utilization;
	}

	public String getArea_applicable() {
		return area_applicable;
	}

	public void setArea_applicable(String area_applicable) {
		this.area_applicable = area_applicable;
	}

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}

	public Date getGmt_modified() {
		return gmt_modified;
	}

	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias_name == null) ? 0 : alias_name.hashCode());
		result = prime * result + ((area_applicable == null) ? 0 : area_applicable.hashCode());
		result = prime * result + ((cat_id == null) ? 0 : cat_id.hashCode());
		result = prime * result + ((cover_media == null) ? 0 : cover_media.hashCode());
		result = prime * result + ((garden_utilization == null) ? 0 : garden_utilization.hashCode());
		result = prime * result + ((genus == null) ? 0 : genus.hashCode());
		result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
		result = prime * result + ((gmt_modified == null) ? 0 : gmt_modified.hashCode());
		result = prime * result + ((habits == null) ? 0 : habits.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name_cn == null) ? 0 : name_cn.hashCode());
		result = prime * result + ((name_en == null) ? 0 : name_en.hashCode());
		result = prime * result + ((short_name_cn == null) ? 0 : short_name_cn.hashCode());
		result = prime * result + ((short_name_en == null) ? 0 : short_name_en.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlantsDO other = (PlantsDO) obj;
		if (alias_name == null) {
			if (other.alias_name != null)
				return false;
		} else if (!alias_name.equals(other.alias_name))
			return false;
		if (area_applicable == null) {
			if (other.area_applicable != null)
				return false;
		} else if (!area_applicable.equals(other.area_applicable))
			return false;
		if (cat_id == null) {
			if (other.cat_id != null)
				return false;
		} else if (!cat_id.equals(other.cat_id))
			return false;
		if (cover_media == null) {
			if (other.cover_media != null)
				return false;
		} else if (!cover_media.equals(other.cover_media))
			return false;
		if (garden_utilization == null) {
			if (other.garden_utilization != null)
				return false;
		} else if (!garden_utilization.equals(other.garden_utilization))
			return false;
		if (genus == null) {
			if (other.genus != null)
				return false;
		} else if (!genus.equals(other.genus))
			return false;
		if (gmt_created == null) {
			if (other.gmt_created != null)
				return false;
		} else if (!gmt_created.equals(other.gmt_created))
			return false;
		if (gmt_modified == null) {
			if (other.gmt_modified != null)
				return false;
		} else if (!gmt_modified.equals(other.gmt_modified))
			return false;
		if (habits == null) {
			if (other.habits != null)
				return false;
		} else if (!habits.equals(other.habits))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name_cn == null) {
			if (other.name_cn != null)
				return false;
		} else if (!name_cn.equals(other.name_cn))
			return false;
		if (name_en == null) {
			if (other.name_en != null)
				return false;
		} else if (!name_en.equals(other.name_en))
			return false;
		if (short_name_cn == null) {
			if (other.short_name_cn != null)
				return false;
		} else if (!short_name_cn.equals(other.short_name_cn))
			return false;
		if (short_name_en == null) {
			if (other.short_name_en != null)
				return false;
		} else if (!short_name_en.equals(other.short_name_en))
			return false;
		return true;
	}

}