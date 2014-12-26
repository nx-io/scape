package me.scape.ti.dao.impl;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.RoleDAO;
import me.scape.ti.dataobject.RoleDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:53:18
 */
@Repository(value = "roleDAO")
public class DefaultRoleDAO extends DefaultGenericDAO<RoleDO, Long> implements RoleDAO {
	
}