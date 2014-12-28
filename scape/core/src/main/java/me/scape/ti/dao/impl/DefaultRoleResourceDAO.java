package me.scape.ti.dao.impl;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.RoleResourceDAO;
import me.scape.ti.dataobject.RoleResourceDO;

import org.springframework.stereotype.Repository;

@Repository(value = "roleResourceDAO")
public class DefaultRoleResourceDAO extends DefaultGenericDAO<RoleResourceDO, Integer> implements RoleResourceDAO {

}