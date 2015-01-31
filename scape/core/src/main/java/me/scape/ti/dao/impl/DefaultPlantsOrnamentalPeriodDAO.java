package me.scape.ti.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.PlantsOrnamentalPeriodDAO;
import me.scape.ti.dataobject.PlantsOrnamentalPeriodDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:52:05
 */
@Repository(value = "plantsOrnamentalPeriodDAO")
public class DefaultPlantsOrnamentalPeriodDAO extends DefaultGenericDAO<PlantsOrnamentalPeriodDO, Integer> implements
        PlantsOrnamentalPeriodDAO {

    @Override
    public List<PlantsOrnamentalPeriodDO> getAllPlantPeriods() {
        return queryNamed("PlantsOrnamentalPeriodDO.getAllPlantPeriods");
    }

    @Override
    public List<PlantsOrnamentalPeriodDO> getDisplayedPlantPeriods() {
        return queryNamed("PlantsOrnamentalPeriodDO.getDisplayedPlantPeriods");
    }

}
