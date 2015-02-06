package me.scape.ti.dao;

import java.util.List;

import me.scape.ti.dataobject.RoleDO;
import me.scape.ti.jpa.GenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:52:41
 */
public interface RoleDAO extends GenericDAO<RoleDO, Integer> {
	List<RoleDO> getAllRoles();

	List<RoleDO> getRolesByResourceId(Integer resourceId);
}