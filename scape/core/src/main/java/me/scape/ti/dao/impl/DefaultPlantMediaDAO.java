package me.scape.ti.dao.impl;

import java.util.List;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.PlantMediaDAO;
import me.scape.ti.dataobject.PlantMediaDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月28日 下午2:48:53
 */
@Repository("plantMediaDAO")
public class DefaultPlantMediaDAO extends EntityManagerSupportGenericDAO<PlantMediaDO, Long> implements PlantMediaDAO {

	@Override
	public List<PlantMediaDO> getMediasByPlantId(Integer plantId) {
		return queryNamed("PlantMedia.getPlantMediaByPlantId", new Object[] { plantId });
	}

	@Override
	public void deleteByPlantId(Integer plantId) {
		getEntityManager().createNamedQuery("PlantMediaDO.deleteByPlantId").setParameter("plantId", plantId).executeUpdate();
	}
}
