package me.scape.ti.dao.impl;

import java.util.List;

import me.scape.ti.dao.ResourceDAO;
import me.scape.ti.dataobject.ResourceDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

@Repository(value = "resourceDAO")
public class DefaultResourceDAO extends DefaultGenericDAO<ResourceDO, Integer> implements ResourceDAO {

    @Override
    public List<ResourceDO> getAllResources() {
        return queryNamed("ResourceDO.getAllResources");
    }

}