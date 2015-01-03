package me.scape.ti.dao.impl;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<CategoryDO> getCategoriesByIds(List<Long> ids) {
        if (null == ids || ids.size() <= 0) {
            return new ArrayList<CategoryDO>();
        }

        return queryNamed("CategoryDO.getCategoriesByIds", ids.toArray());
    }

    @Override
    public List<CategoryDO> getAllCategories() {
        return queryNamed("CategoryDO.getAllCategories");
    }
}
