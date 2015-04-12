package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.RequirementsTopCategoryDAO;
import me.scape.ti.dataobject.RequirementsTopCategoryDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:14:38
 */
@Repository(value = "requirementsTopCategoryDAO")
public class DefaultRequirementsTopCategoryDAO extends DefaultGenericDAO<RequirementsTopCategoryDO, Long> implements RequirementsTopCategoryDAO {
	
}