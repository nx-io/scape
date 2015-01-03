package me.scape.ti.dao;

import java.util.List;

import me.scape.ti.dataobject.AreaCategoryDO;
import me.scape.ti.jpa.GenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:14:12
 */
public interface AreaCategoryDAO extends GenericDAO<AreaCategoryDO, Long> {
    List<AreaCategoryDO> getAreaCategoriesByIds(List<Long> ids);

    List<AreaCategoryDO> getAllAreaCategories();
}