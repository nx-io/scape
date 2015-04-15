package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.RequirementsCommentsDAO;
import me.scape.ti.dataobject.RequirementsCommentsDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:10:11
 */
@Repository("requirementsCommentsDAO")
public class DefaultRequirementsCommentsDAO extends DefaultGenericDAO<RequirementsCommentsDO, Long> implements RequirementsCommentsDAO {
	
}