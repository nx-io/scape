package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.PlantCategoryDAO;
import me.scape.ti.dataobject.PlantCategoryDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:42:11
 */
@Repository(value = "plantCategoryDAO")
public class DefaultPlantCategoryDAO  extends DefaultGenericDAO<PlantCategoryDO, Integer> implements PlantCategoryDAO {
	
}
