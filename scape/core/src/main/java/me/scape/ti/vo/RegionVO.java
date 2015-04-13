package me.scape.ti.vo;

import me.scape.ti.dataobject.RegionDO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 下午2:56:26
 */
public class RegionVO {

	private Integer id;

	private CityVO city;// 市

	private String name;// 名称

	private Double lng;// 经度

	private Double lat;// 纬度
	
	public static RegionVO newInstance(RegionDO region) {
		if(region == null) {
			return null;
		}
		RegionVO vo = new RegionVO();
		vo.setId(region.getId());
		vo.setName(region.getName());
		vo.setLng(region.getLng());
		vo.setLat(region.getLat());
		return vo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CityVO getCity() {
		return city;
	}

	public void setCity(CityVO city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}
}