package me.scape.ti.dao;

import java.util.List;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.dataobject.StyleDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:54:20
 */
public interface StyleDAO extends GenericDAO<StyleDO, Long> {
	List<StyleDO> getStylesByIds(List<Long> ids);

	List<StyleDO> getAllStyles();
}