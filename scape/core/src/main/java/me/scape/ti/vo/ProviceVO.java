package me.scape.ti.vo;

import me.scape.ti.dataobject.ProvinceDO;


/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 下午2:50:13
 */
public class ProviceVO {
	
	private Integer id;

	private String name;// 名称

	private Double lng;// 经度

	private Double lat;// 纬度
	
	public static ProviceVO newInstance(ProvinceDO provice) {
		if(provice == null) {
			return null;
		}
		ProviceVO vo = new ProviceVO();
		vo.setId(provice.getId());
		vo.setName(provice.getName());
		vo.setLng(provice.getLat());
		vo.setLat(provice.getLat());
		return vo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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