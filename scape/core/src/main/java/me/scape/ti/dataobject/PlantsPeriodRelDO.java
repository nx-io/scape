package me.scape.ti.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 植物-观赏期关联.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午4:24:00
 */
@Entity
@Table(name = "plant_period_rel", catalog = "scape")
@NamedQueries({ @NamedQuery(name = "PlantsPeriodRelDO.deleteByPlantId", query = "DELETE FROM PlantsPeriodRelDO WHERE plant_id = :plantId") })
public class PlantsPeriodRelDO implements Serializable {

	private static final long serialVersionUID = -1276101210269230653L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "plant_id", nullable = false)
	private Integer plant_id;

	@Column(name = "period_id", nullable = false)
	private Integer period_id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_created", nullable = false)
	private Date gmt_created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gmt_modified", nullable = true)
	private Date gmt_modified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPlant_id() {
		return plant_id;
	}

	public void setPlant_id(Integer plant_id) {
		this.plant_id = plant_id;
	}

	public Integer getPeriod_id() {
		return period_id;
	}

	public void setPeriod_id(Integer period_id) {
		this.period_id = period_id;
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
		result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
		result = prime * result + ((gmt_modified == null) ? 0 : gmt_modified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((period_id == null) ? 0 : period_id.hashCode());
		result = prime * result + ((plant_id == null) ? 0 : plant_id.hashCode());
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
		PlantsPeriodRelDO other = (PlantsPeriodRelDO) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (period_id == null) {
			if (other.period_id != null)
				return false;
		} else if (!period_id.equals(other.period_id))
			return false;
		if (plant_id == null) {
			if (other.plant_id != null)
				return false;
		} else if (!plant_id.equals(other.plant_id))
			return false;
		return true;
	}

}