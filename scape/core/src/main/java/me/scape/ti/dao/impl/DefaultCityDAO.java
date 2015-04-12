package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.CityDAO;
import me.scape.ti.dataobject.CityDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:03:49
 */
@Repository(value = "cityDAO")
public class DefaultCityDAO extends DefaultGenericDAO<CityDO, Integer> implements CityDAO {
	
}