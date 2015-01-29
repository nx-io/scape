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

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "cat_id", nullable = false)
	private Long catId;

	@Column(name = "name_cn", nullable = false, length = 255)
	private String nameCn;// 中文名

	@Column(name = "short_name_cn", nullable = true, length = 45)
	private String shortNameCn;// 中文名简称

	@Column(name = "name_en", nullable = true, length = 255)
	private String nameEn;// 英文名

	@Column(name = "short_name_en", nullable = true, length = 45)
	private String shortNameEn;// 英文名简称

	@Column(name = "alias_name", nullable = true, length = 255)
	private String aliasName;// 别名

	@Column(name = "genus", nullable = true, length = 45)
	private String genus;// 科属

	@Column(name = "habits", nullable = true, length = 1024)
	private String habits;// 习性

	@Column(name = "garden_utilization", nullable = true, length = 1024)
	private String gardenUtilization;// 园林用途

	@Column(name = "area_applicable", nullable = true, length = 1024)
	private String areaApplicable;// 适用地区

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = false)
	private Date gmt_modified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getShortNameCn() {
		return shortNameCn;
	}

	public void setShortNameCn(String shortNameCn) {
		this.shortNameCn = shortNameCn;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getShortNameEn() {
		return shortNameEn;
	}

	public void setShortNameEn(String shortNameEn) {
		this.shortNameEn = shortNameEn;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
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

	public String getGardenUtilization() {
		return gardenUtilization;
	}

	public void setGardenUtilization(String gardenUtilization) {
		this.gardenUtilization = gardenUtilization;
	}

	public String getAreaApplicable() {
		return areaApplicable;
	}

	public void setAreaApplicable(String areaApplicable) {
		this.areaApplicable = areaApplicable;
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
		result = prime * result + ((aliasName == null) ? 0 : aliasName.hashCode());
		result = prime * result + ((areaApplicable == null) ? 0 : areaApplicable.hashCode());
		result = prime * result + ((catId == null) ? 0 : catId.hashCode());
		result = prime * result + ((gardenUtilization == null) ? 0 : gardenUtilization.hashCode());
		result = prime * result + ((genus == null) ? 0 : genus.hashCode());
		result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
		result = prime * result + ((gmt_modified == null) ? 0 : gmt_modified.hashCode());
		result = prime * result + ((habits == null) ? 0 : habits.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameCn == null) ? 0 : nameCn.hashCode());
		result = prime * result + ((nameEn == null) ? 0 : nameEn.hashCode());
		result = prime * result + ((shortNameCn == null) ? 0 : shortNameCn.hashCode());
		result = prime * result + ((shortNameEn == null) ? 0 : shortNameEn.hashCode());
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
		if (aliasName == null) {
			if (other.aliasName != null)
				return false;
		} else if (!aliasName.equals(other.aliasName))
			return false;
		if (areaApplicable == null) {
			if (other.areaApplicable != null)
				return false;
		} else if (!areaApplicable.equals(other.areaApplicable))
			return false;
		if (catId == null) {
			if (other.catId != null)
				return false;
		} else if (!catId.equals(other.catId))
			return false;
		if (gardenUtilization == null) {
			if (other.gardenUtilization != null)
				return false;
		} else if (!gardenUtilization.equals(other.gardenUtilization))
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
		if (nameCn == null) {
			if (other.nameCn != null)
				return false;
		} else if (!nameCn.equals(other.nameCn))
			return false;
		if (nameEn == null) {
			if (other.nameEn != null)
				return false;
		} else if (!nameEn.equals(other.nameEn))
			return false;
		if (shortNameCn == null) {
			if (other.shortNameCn != null)
				return false;
		} else if (!shortNameCn.equals(other.shortNameCn))
			return false;
		if (shortNameEn == null) {
			if (other.shortNameEn != null)
				return false;
		} else if (!shortNameEn.equals(other.shortNameEn))
			return false;
		return true;
	}
}