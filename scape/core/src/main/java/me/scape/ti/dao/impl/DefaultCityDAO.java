package me.scape.ti.dao.impl;

import java.util.List;

import me.scape.ti.dao.CityDAO;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dataobject.CityDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:03:49
 */
@Repository("cityDAO")
public class DefaultCityDAO extends EntityManagerSupportGenericDAO<CityDO, Integer> implements CityDAO {

	static final String Query_City_HQL = "FROM CityDO WHERE province_id = ?";
	
	@Override
	public List<CityDO> queryProvinceCity(Integer provinceId) {
		return query(Query_City_HQL, new Object[] { provinceId });
	}
}