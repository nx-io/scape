package me.scape.ti.dao;

import java.util.List;

import me.scape.ti.commons.GenericDAO;
import me.scape.ti.dataobject.ResourceDO;

public interface ResourceDAO extends GenericDAO<ResourceDO, Integer> {

    List<ResourceDO> getAllResources();
}
