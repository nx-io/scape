package me.scape.ti.ro;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月26日 下午6:13:57
 */
public class TalentsSearchRequest extends NonPrivilegedPageRequest {

	private static final long serialVersionUID = -7313184558141486930L;

    private Long category_id;// 特长

	private Integer province_id;// 省

	private Integer city_id;// 市

	private Byte type;// 搜索类型 1:最近更新 2:最多案例 3:最多关注

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public Integer getProvince_id() {
		return province_id;
	}

	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}
}