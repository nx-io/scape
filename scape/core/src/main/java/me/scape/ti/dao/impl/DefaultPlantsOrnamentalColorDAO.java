package me.scape.ti.dao.impl;

import java.util.List;

import me.scape.ti.dao.PlantsOrnamentalColorDAO;
import me.scape.ti.dataobject.PlantsOrnamentalColorDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:49:54
 */
@Repository("plantsOrnamentalColorDAO")
public class DefaultPlantsOrnamentalColorDAO extends DefaultGenericDAO<PlantsOrnamentalColorDO, Integer> implements PlantsOrnamentalColorDAO {

	@Override
	public List<PlantsOrnamentalColorDO> getAllPlantColors() {
		return queryNamed("PlantsOrnamentalColorDO.getAllPlantColors");
	}

	@Override
	public List<PlantsOrnamentalColorDO> getDisplayedPlantColors() {
		return queryNamed("PlantsOrnamentalColorDO.getDisplayedPlantColors");
	}

	@Override
	public List<PlantsOrnamentalColorDO> getPlantColorsByPlantId(Integer plantId) {
		String sql = "SELECT * FROM plant_ornamental_color poc WHERE poc.id IN (SELECT pcr.color_id FROM plant_color_rel pcr WHERE pcr.plant_id = ?)";

		return queryNative(sql, new Object[] { plantId });
	}
}
