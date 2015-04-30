package me.scape.ti.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.PlantQueryCriteria;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.PlantsDAO;
import me.scape.ti.dataobject.PlantsDO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:47:31
 */
@Repository("plantsDAO")
public class DefaultPlantsDAO extends EntityManagerSupportGenericDAO<PlantsDO, Integer> implements PlantsDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pagination<PlantsDO> listPlants(PlantQueryCriteria criteria) {
		List<Object> args = new ArrayList<Object>();

		StringBuilder sqlCountRows = new StringBuilder();
		sqlCountRows.append("SELECT count(*) FROM plants p where 1 = 1");

		StringBuilder sqlFetchRows = new StringBuilder();
		sqlFetchRows.append("SELECT p.* FROM plants p where 1 = 1");

		StringBuilder condition = new StringBuilder();
		if (StringUtils.isNotEmpty(criteria.getName())) {
			condition.append(" AND p.name_cn LIKE ? OR p.name_en LIKE ?");
			args.add("%" + criteria.getName() + "%");
			args.add("%" + criteria.getName() + "%");
		}
		if (null != criteria.getCat_id()) {
			condition.append(" AND p.cat_id = ?");
			args.add(criteria.getCat_id());
		}

		BigInteger count = (BigInteger) (createNativeQuery(sqlCountRows.append(condition).toString(), args.toArray()).getSingleResult());

		condition.append(" ORDER BY p.gmt_created DESC");
		if (0 != criteria.getLimit()) {
			condition.append(" LIMIT ?, ?");
			args.add(criteria.getOffset());
			args.add(criteria.getLimit());
		}
		List<PlantsDO> list = queryNative(sqlFetchRows.append(condition).toString(), args.toArray());

		return new Pagination(count.intValue(), list);
	}

}