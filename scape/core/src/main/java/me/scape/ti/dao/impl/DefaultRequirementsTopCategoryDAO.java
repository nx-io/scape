package me.scape.ti.dao.impl;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.RequirementsTopCategoryDAO;
import me.scape.ti.dataobject.RequirementsTopCategoryDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:14:38
 */
@Repository("requirementsTopCategoryDAO")
public class DefaultRequirementsTopCategoryDAO extends EntityManagerSupportGenericDAO<RequirementsTopCategoryDO, Integer> implements RequirementsTopCategoryDAO {
	
}