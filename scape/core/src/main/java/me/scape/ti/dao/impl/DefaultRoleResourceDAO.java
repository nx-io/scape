package me.scape.ti.dao.impl;

import me.scape.ti.dao.RoleResourceDAO;
import me.scape.ti.dataobject.RoleResourceDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

@Repository("roleResourceDAO")
public class DefaultRoleResourceDAO extends DefaultGenericDAO<RoleResourceDO, Integer> implements RoleResourceDAO {

}