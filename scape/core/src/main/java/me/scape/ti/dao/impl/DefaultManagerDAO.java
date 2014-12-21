package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.ManagerDAO;
import me.scape.ti.dataobject.ManagerDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:49:36
 */
@Repository(value = "managerDAO")
public class DefaultManagerDAO extends DefaultGenericDAO<ManagerDO, Long> implements ManagerDAO {
	
}