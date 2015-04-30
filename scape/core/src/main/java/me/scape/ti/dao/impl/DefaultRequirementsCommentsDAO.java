package me.scape.ti.dao.impl;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.RequirementsCommentsDAO;
import me.scape.ti.dataobject.RequirementsCommentsDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:10:11
 */
@Repository("requirementsCommentsDAO")
public class DefaultRequirementsCommentsDAO extends EntityManagerSupportGenericDAO<RequirementsCommentsDO, Long> implements RequirementsCommentsDAO {
	
}