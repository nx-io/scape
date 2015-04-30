package me.scape.ti.dao;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.PlantQueryCriteria;
import me.scape.ti.dataobject.PlantsDO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:47:02
 */
public interface PlantsDAO extends GenericDAO<PlantsDO, Integer> {
	Pagination<PlantsDO> listPlants(PlantQueryCriteria criteria);
}