package me.scape.ti.dao.impl;

import java.util.List;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.PlantsOrnamentalPeriodDAO;
import me.scape.ti.dataobject.PlantsOrnamentalPeriodDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:52:05
 */
@Repository("plantsOrnamentalPeriodDAO")
public class DefaultPlantsOrnamentalPeriodDAO extends EntityManagerSupportGenericDAO<PlantsOrnamentalPeriodDO, Integer> implements PlantsOrnamentalPeriodDAO {

	@Override
	public List<PlantsOrnamentalPeriodDO> getAllPlantPeriods() {
		return queryNamed("PlantsOrnamentalPeriodDO.getAllPlantPeriods");
	}

	@Override
	public List<PlantsOrnamentalPeriodDO> getDisplayedPlantPeriods() {
		return queryNamed("PlantsOrnamentalPeriodDO.getDisplayedPlantPeriods");
	}

	@Override
	public List<PlantsOrnamentalPeriodDO> getPlantPeriodsByPlantId(Integer plantId) {
		String sql = "SELECT * FROM plant_ornamental_period pop WHERE pop.id IN (SELECT ppr.period_id FROM plant_period_rel ppr WHERE ppr.plant_id = ?)";

		return queryNative(sql, new Object[] { plantId });
	}

}
