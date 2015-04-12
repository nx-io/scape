package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.RequirementsDAO;
import me.scape.ti.dataobject.RequirementsDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:16:29
 */
@Repository(value = "requirementsDAO")
public class DefaultRequirementsDAO extends DefaultGenericDAO<RequirementsDO, Long> implements RequirementsDAO {
	
}