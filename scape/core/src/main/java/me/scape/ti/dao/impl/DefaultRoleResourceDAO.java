package me.scape.ti.dao.impl;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.RoleResourceDAO;
import me.scape.ti.dataobject.RoleResourceDO;

import org.springframework.stereotype.Repository;

@Repository("roleResourceDAO")
public class DefaultRoleResourceDAO extends EntityManagerSupportGenericDAO<RoleResourceDO, Integer> implements RoleResourceDAO {

}