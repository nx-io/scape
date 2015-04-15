package me.scape.ti.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.dao.PlantCategoryDAO;
import me.scape.ti.dataobject.PlantCategoryDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:42:11
 */
@Repository("plantCategoryDAO")
public class DefaultPlantCategoryDAO extends DefaultGenericDAO<PlantCategoryDO, Integer> implements PlantCategoryDAO {

	@Override
	public List<PlantCategoryDO> getCategoriesByIds(List<Integer> ids) {
		if (null == ids || ids.size() <= 0) {
			return new ArrayList<PlantCategoryDO>();
		}

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("ids", ids);
		return queryNamed("PlantCategoryDO.getCategoriesByIds", args);
	}

	@Override
	public List<PlantCategoryDO> getAllCategories() {
		return queryNamed("PlantCategoryDO.getAllCategories");
	}

	@Override
	public List<PlantCategoryDO> getDisplayedCategories() {
		return queryNamed("PlantCategoryDO.getDisplayedCategories");
	}
}
