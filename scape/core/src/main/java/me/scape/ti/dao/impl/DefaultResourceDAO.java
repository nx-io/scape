package me.scape.ti.dao.impl;

import java.util.List;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.ResourceDAO;
import me.scape.ti.dataobject.ResourceDO;

import org.springframework.stereotype.Repository;

@Repository("resourceDAO")
public class DefaultResourceDAO extends EntityManagerSupportGenericDAO<ResourceDO, Integer> implements ResourceDAO {

	@Override
	public List<ResourceDO> getAllResources() {
		return queryNamed("ResourceDO.getAllResources");
	}

}