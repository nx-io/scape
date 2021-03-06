package me.scape.ti.dao;

import java.util.List;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.dataobject.RegionDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午10:58:23
 */
public interface RegionDAO extends GenericDAO<RegionDO, Integer> {

	List<RegionDO> queryCityRegion(Integer cityId);

}