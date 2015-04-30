package me.scape.ti.dao;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.dataobject.PlantsColorRelDO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:44:51
 */
public interface PlantsColorRelDAO extends GenericDAO<PlantsColorRelDO, Long> {
	void deleteByPlantId(Integer plantId);
}