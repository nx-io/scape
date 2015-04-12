package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.RegionDAO;
import me.scape.ti.dataobject.RegionDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:00:27
 */
@Repository(value = "regionDAO")
public class DefaultRegionDAO extends DefaultGenericDAO<RegionDO, Integer> implements RegionDAO {

}
