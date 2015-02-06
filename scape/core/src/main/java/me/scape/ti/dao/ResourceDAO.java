package me.scape.ti.dao;

import java.util.List;

import me.scape.ti.dataobject.ResourceDO;
import me.scape.ti.jpa.GenericDAO;

public interface ResourceDAO extends GenericDAO<ResourceDO, Integer> {

	List<ResourceDO> getAllResources();
}
