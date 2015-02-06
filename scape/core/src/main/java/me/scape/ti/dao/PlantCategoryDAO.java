package me.scape.ti.dao;

import java.util.List;

import me.scape.ti.dataobject.PlantCategoryDO;
import me.scape.ti.jpa.GenericDAO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:41:18
 */
public interface PlantCategoryDAO extends GenericDAO<PlantCategoryDO, Integer> {

	List<PlantCategoryDO> getCategoriesByIds(List<Integer> ids);

	List<PlantCategoryDO> getAllCategories();

	List<PlantCategoryDO> getDisplayedCategories();
}
