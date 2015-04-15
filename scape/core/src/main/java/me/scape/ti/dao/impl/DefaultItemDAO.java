package me.scape.ti.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.ItemQueryCriteria;
import me.scape.ti.dao.ItemDAO;
import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:42:32
 */
@Repository("itemDAO")
public class DefaultItemDAO extends DefaultGenericDAO<ItemDO, Long> implements ItemDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pagination<ItemDO> ListItems(ItemQueryCriteria criteria) {
		List<Object> args = new ArrayList<Object>();

		StringBuilder sqlCountRows = new StringBuilder();
		sqlCountRows.append("SELECT count(*) FROM item i where 1 = 1");

		StringBuilder sqlFetchRows = new StringBuilder();
		sqlFetchRows.append("SELECT i.* FROM item i where 1 = 1");

		StringBuilder condition = new StringBuilder();
		if (null != criteria.getStatus()) {
			condition.append(" AND i.status = ?");
			args.add(criteria.getStatus());
		} else {
			condition.append(" AND i.status != -1");
		}
		if (StringUtils.isNotEmpty(criteria.getTitle())) {
			condition.append(" AND i.title LIKE ?");
			args.add("%" + criteria.getTitle() + "%");
		}
		if (null != criteria.getType()) {
			condition.append(" AND i.type = ?");
			args.add(criteria.getType());
		}
		if (null != criteria.getCategory_id()) {
			condition.append(" AND i.category_id = ?");
			args.add(criteria.getCategory_id());
		}
		if (null != criteria.getArea_category_id()) {
			condition.append(" AND i.area_category_id = ?");
			args.add(criteria.getArea_category_id());
		}
		if (null != criteria.getStyle_id()) {
			condition.append(" AND i.style_id = ?");
			args.add(criteria.getStyle_id());
		}

		BigInteger count = (BigInteger) (createNativeQuery(sqlCountRows.append(condition).toString(), args.toArray()).getSingleResult());

		condition.append(" ORDER BY i.gmt_created DESC");
		if (0 != criteria.getLimit()) {
			condition.append(" LIMIT ?, ?");
			args.add(criteria.getOffset());
			args.add(criteria.getLimit());
		}
		List<ItemDO> list = queryNative(sqlFetchRows.append(condition).toString(), args.toArray());

		return new Pagination(count.intValue(), list);
	}

}