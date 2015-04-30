package me.scape.ti.dao.impl;

import java.util.List;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.RegionDAO;
import me.scape.ti.dataobject.RegionDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:00:27
 */
@Repository("regionDAO")
public class DefaultRegionDAO extends EntityManagerSupportGenericDAO<RegionDO, Integer> implements RegionDAO {

	static final String Query_Region_HQL = "FROM RegionDO WHERE city_id = ?";
	
	@Override
	public List<RegionDO> queryCityRegion(Integer cityId) {
		return query(Query_Region_HQL, new Object[] { cityId });
	}
}
