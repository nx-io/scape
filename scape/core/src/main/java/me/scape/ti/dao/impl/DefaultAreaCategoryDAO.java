package me.scape.ti.dao.impl;

import me.scape.ti.dao.AreaCategoryDAO;
import me.scape.ti.dataobject.AreaCategoryDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:15:39
 */
@Repository(value = "areaCategoryDAO")
public class DefaultAreaCategoryDAO extends DefaultGenericDAO<AreaCategoryDO, Long> implements AreaCategoryDAO {
	
}