package me.scape.ti.dao;

import java.util.List;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.dataobject.CityDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:02:02
 */
public interface CityDAO extends GenericDAO<CityDO, Integer> {

	List<CityDO> queryProvinceCity(Integer provinceId);

}