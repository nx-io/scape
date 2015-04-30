package me.scape.ti.dao.impl;

import java.util.List;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.RoleDAO;
import me.scape.ti.dataobject.RoleDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:53:18
 */
@Repository("roleDAO")
public class DefaultRoleDAO extends EntityManagerSupportGenericDAO<RoleDO, Integer> implements RoleDAO {

	@Override
	public List<RoleDO> getAllRoles() {
		return queryNamed("RoleDO.getAllRoles");
	}

	@Override
	public List<RoleDO> getRolesByResourceId(Integer resourceId) {
		String sql = "SELECT r.* FROM role r JOIN role_resource rr ON (r.id = rr.role_id AND rr.resource_id = ?)";
		return queryNative(sql, new Object[] { resourceId });
	}
}