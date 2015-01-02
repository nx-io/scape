package me.scape.ti.dao.impl;

import me.scape.ti.dao.CategoryDAO;
import me.scape.ti.dataobject.CategoryDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:17:53
 */
@Repository(value = "categoryDAO")
public class DefaultCategoryDAO extends DefaultGenericDAO<CategoryDO, Long> implements CategoryDAO {
	
}
