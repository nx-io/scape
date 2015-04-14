package me.scape.ti.vo;

import me.scape.ti.dataobject.CityDO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 下午2:56:26
 */
public class CityVO {

	private Integer id;

	private ProvinceVO province;// 省

	private String name;// 名称

	private Double lng;// 经度

	private Double lat;// 纬度
	
	public static CityVO newInstance(CityDO city) {
		if(city == null) {
			return null;
		}
		CityVO vo = new CityVO();
		vo.setId(city.getId());
		vo.setName(city.getName());
		vo.setLng(city.getLng());
		vo.setLat(city.getLat());
		return vo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProvinceVO getProvince() {
		return province;
	}

	public void setProvince(ProvinceVO province) {
		this.province = province;
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