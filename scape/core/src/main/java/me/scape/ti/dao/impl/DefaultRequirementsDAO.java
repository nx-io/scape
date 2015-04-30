package me.scape.ti.dao.impl;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.RequirementsDAO;
import me.scape.ti.dataobject.RequirementsDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:16:29
 */
@Repository("requirementsDAO")
public class DefaultRequirementsDAO extends EntityManagerSupportGenericDAO<RequirementsDO, Long> implements RequirementsDAO {
	
}