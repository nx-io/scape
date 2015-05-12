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
 * 需求信息
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午5:09:33
 */
@Entity
@Table(name = "requirements", catalog = "scape")
public class RequirementsDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "title", nullable = false, length = 64)
	private String title;// 需求信息标题

	@Column(name = "conent", length = 2048)
	private String conent;// 需求信息内容

	@Column(name = "user_id", nullable = false)
	private Long user_id;// 发布者

	@Column(name = "province_id")
	private Integer province_id;// 省

	@Column(name = "province", length = 20)
	private String province;

	@Column(name = "city_id")
	private Integer city_id;// 市

	@Column(name = "city", length = 20)
	private String city;

	@Column(name = "region_id")
	private Integer region_id;// 区

	@Column(name = "region", length = 20)
	private String region;

	@Column(name = "top_cat_id")
	private Integer top_cat_id;// 一级分类ID

	@Column(name = "top_cat", length = 64)
	private String top_cat;

	@Column(name = "sec_cat_id")
	private Integer sec_cat_id;// 二级分类ID

	@Column(name = "sec_cat", length = 64)
	private String sec_cat;

	@Column(name = "mobile", length = 64, nullable = false)
	private String mobile;// 手机

	@Column(name = "media", length = 255)
	private String media;// 图片

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConent() {
		return conent;
	}

	public void setConent(String conent) {
		this.conent = conent;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Integer getProvince_id() {
		return province_id;
	}

	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getTop_cat_id() {
		return top_cat_id;
	}

	public void setTop_cat_id(Integer top_cat_id) {
		this.top_cat_id = top_cat_id;
	}

	public String getTop_cat() {
		return top_cat;
	}

	public void setTop_cat(String top_cat) {
		this.top_cat = top_cat;
	}

	public Integer getSec_cat_id() {
		return sec_cat_id;
	}

	public void setSec_cat_id(Integer sec_cat_id) {
		this.sec_cat_id = sec_cat_id;
	}

	public String getSec_cat() {
		return sec_cat;
	}

	public void setSec_cat(String sec_cat) {
		this.sec_cat = sec_cat;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((city_id == null) ? 0 : city_id.hashCode());
		result = prime * result + ((conent == null) ? 0 : conent.hashCode());
		result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
		result = prime * result + ((gmt_modified == null) ? 0 : gmt_modified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((media == null) ? 0 : media.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((province_id == null) ? 0 : province_id.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((region_id == null) ? 0 : region_id.hashCode());
		result = prime * result + ((sec_cat == null) ? 0 : sec_cat.hashCode());
		result = prime * result + ((sec_cat_id == null) ? 0 : sec_cat_id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((top_cat == null) ? 0 : top_cat.hashCode());
		result = prime * result + ((top_cat_id == null) ? 0 : top_cat_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		RequirementsDO other = (RequirementsDO) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (city_id == null) {
			if (other.city_id != null)
				return false;
		} else if (!city_id.equals(other.city_id))
			return false;
		if (conent == null) {
			if (other.conent != null)
				return false;
		} else if (!conent.equals(other.conent))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (media == null) {
			if (other.media != null)
				return false;
		} else if (!media.equals(other.media))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (province_id == null) {
			if (other.province_id != null)
				return false;
		} else if (!province_id.equals(other.province_id))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (region_id == null) {
			if (other.region_id != null)
				return false;
		} else if (!region_id.equals(other.region_id))
			return false;
		if (sec_cat == null) {
			if (other.sec_cat != null)
				return false;
		} else if (!sec_cat.equals(other.sec_cat))
			return false;
		if (sec_cat_id == null) {
			if (other.sec_cat_id != null)
				return false;
		} else if (!sec_cat_id.equals(other.sec_cat_id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (top_cat == null) {
			if (other.top_cat != null)
				return false;
		} else if (!top_cat.equals(other.top_cat))
			return false;
		if (top_cat_id == null) {
			if (other.top_cat_id != null)
				return false;
		} else if (!top_cat_id.equals(other.top_cat_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
}