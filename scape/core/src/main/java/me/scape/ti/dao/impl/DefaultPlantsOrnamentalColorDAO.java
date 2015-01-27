package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.PlantsOrnamentalColorDAO;
import me.scape.ti.dataobject.PlantsOrnamentalColorDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:49:54
 */
@Repository(value = "plantsOrnamentalColorDAO")
public class DefaultPlantsOrnamentalColorDAO extends DefaultGenericDAO<PlantsOrnamentalColorDO, Long> implements PlantsOrnamentalColorDAO {

}
