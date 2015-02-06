package me.scape.ti.dao;

import me.scape.ti.dataobject.PlantsPeriodRelDO;
import me.scape.ti.jpa.GenericDAO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:53:22
 */
public interface PlantsPeriodRelDAO extends GenericDAO<PlantsPeriodRelDO, Long> {
	void deleteByPlantId(Integer plantId);
}