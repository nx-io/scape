package me.scape.ti.dao;

import java.util.List;

import me.scape.ti.dataobject.CategoryDO;
import me.scape.ti.jpa.GenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:17:23
 */
public interface CategoryDAO extends GenericDAO<CategoryDO, Long> {
	List<CategoryDO> getCategoriesByIds(List<Long> ids);

	List<CategoryDO> getAllCategories();
}
