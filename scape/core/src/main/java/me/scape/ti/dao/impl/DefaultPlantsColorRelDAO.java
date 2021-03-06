package me.scape.ti.dao.impl;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.PlantsColorRelDAO;
import me.scape.ti.dataobject.PlantsColorRelDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:45:49
 */
@Repository("plantsColorRelDAO")
public class DefaultPlantsColorRelDAO extends EntityManagerSupportGenericDAO<PlantsColorRelDO, Long> implements PlantsColorRelDAO {

	@Override
	public void deleteByPlantId(Integer plantId) {
		getEntityManager().createNamedQuery("PlantsColorRelDO.deleteByPlantId").setParameter("plantId", plantId).executeUpdate();
	}

}
