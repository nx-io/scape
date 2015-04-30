package me.scape.ti.dao;

import java.util.List;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.dataobject.ResourceDO;

public interface ResourceDAO extends GenericDAO<ResourceDO, Integer> {

	List<ResourceDO> getAllResources();
}
