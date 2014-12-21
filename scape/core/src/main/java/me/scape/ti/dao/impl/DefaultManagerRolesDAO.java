package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.ManagerRolesDAO;
import me.scape.ti.dataobject.ManagerRolesDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:51:37
 */
@Repository(value = "managerRolesDAO")
public class DefaultManagerRolesDAO extends DefaultGenericDAO<ManagerRolesDO, Long> implements ManagerRolesDAO {
	
}