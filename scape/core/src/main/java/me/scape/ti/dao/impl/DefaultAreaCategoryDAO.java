package me.scape.ti.dao.impl;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<AreaCategoryDO> getAreaCategoriesByIds(List<Long> ids) {
        if (null == ids || ids.size() <= 0) {
            return new ArrayList<AreaCategoryDO>();
        }

        return queryNamed("AreaCategoryDO.getAreaCategoriesByIds", ids.toArray());
    }

    @Override
    public List<AreaCategoryDO> getAllAreaCategories() {
        return queryNamed("AreaCategoryDO.getAllAreaCategories");
    }

}