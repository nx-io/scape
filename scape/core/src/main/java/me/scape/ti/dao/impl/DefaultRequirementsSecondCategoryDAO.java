package me.scape.ti.dao.impl;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.RequirementsSecondCategoryDAO;
import me.scape.ti.dataobject.RequirementsSecondCategoryDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:12:40
 */
@Repository("requirementsSecondCategoryDAO")
public class DefaultRequirementsSecondCategoryDAO extends EntityManagerSupportGenericDAO<RequirementsSecondCategoryDO, Integer> implements RequirementsSecondCategoryDAO {
	
}