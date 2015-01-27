package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.PlantsDAO;
import me.scape.ti.dataobject.PlantsDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:47:31
 */
@Repository(value = "plantsDAO")
public class DefaultPlantsDAO extends DefaultGenericDAO<PlantsDO, Long> implements PlantsDAO {

}