package me.scape.ti.dao;

import java.util.List;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.dataobject.PlantsOrnamentalPeriodDO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:51:43
 */
public interface PlantsOrnamentalPeriodDAO extends GenericDAO<PlantsOrnamentalPeriodDO, Integer> {

	List<PlantsOrnamentalPeriodDO> getAllPlantPeriods();

	List<PlantsOrnamentalPeriodDO> getDisplayedPlantPeriods();

	List<PlantsOrnamentalPeriodDO> getPlantPeriodsByPlantId(Integer plantId);
}