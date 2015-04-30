package me.scape.ti.dao.impl;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.PlantsPeriodRelDAO;
import me.scape.ti.dataobject.PlantsPeriodRelDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:53:46
 */
@Repository("plantsPeriodRelDAO")
public class DefaultPlantsPeriodRelDAO extends EntityManagerSupportGenericDAO<PlantsPeriodRelDO, Long> implements PlantsPeriodRelDAO {

	@Override
	public void deleteByPlantId(Integer plantId) {
		getEntityManager().createNamedQuery("PlantsPeriodRelDO.deleteByPlantId").setParameter("plantId", plantId).executeUpdate();
	}
}
