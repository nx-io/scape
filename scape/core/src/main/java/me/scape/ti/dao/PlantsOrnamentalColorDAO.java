package me.scape.ti.dao;

import java.util.List;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.dataobject.PlantsOrnamentalColorDO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:49:26
 */
public interface PlantsOrnamentalColorDAO extends GenericDAO<PlantsOrnamentalColorDO, Integer> {

	List<PlantsOrnamentalColorDO> getAllPlantColors();

	List<PlantsOrnamentalColorDO> getDisplayedPlantColors();

	List<PlantsOrnamentalColorDO> getPlantColorsByPlantId(Integer plantId);
}