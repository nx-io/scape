package me.scape.ti.dao.impl;

import java.util.List;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.ResourceDAO;
import me.scape.ti.dataobject.ResourceDO;

import org.springframework.stereotype.Repository;

@Repository(value = "resourceDAO")
public class DefaultResourceDAO extends DefaultGenericDAO<ResourceDO, Integer> implements ResourceDAO {

    @Override
    public List<ResourceDO> getAllResources() {
        return findByNamedQuery("ResourceDO.getAllResources");
    }

}