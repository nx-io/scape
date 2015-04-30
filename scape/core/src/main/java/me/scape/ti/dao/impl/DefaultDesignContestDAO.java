package me.scape.ti.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.DesignContestQueryCriteria;
import me.scape.ti.dao.DesignContestDAO;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dataobject.DesignContestDO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:01:09
 */
@Repository("designContestDAO")
public class DefaultDesignContestDAO extends EntityManagerSupportGenericDAO<DesignContestDO, Integer> implements DesignContestDAO {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Pagination<DesignContestDO> ListDesignContests(DesignContestQueryCriteria criteria) {
        List<Object> args = new ArrayList<Object>();

        StringBuilder sqlCountRows = new StringBuilder();
        sqlCountRows.append("SELECT count(*) FROM design_contest dc where 1 = 1");

        StringBuilder sqlFetchRows = new StringBuilder();
        sqlFetchRows.append("SELECT dc.* FROM design_contest dc where 1 = 1");

        StringBuilder condition = new StringBuilder();
        if (null != criteria.getStatus()) {
            condition.append(" AND dc.status = ?");
            args.add(criteria.getStatus());
        } else {
            condition.append(" AND dc.status != -1");
        }
        if (StringUtils.isNotEmpty(criteria.getTitle())) {
            condition.append(" AND dc.title LIKE ?");
            args.add("%" + criteria.getTitle() + "%");
        }

        BigInteger count = (BigInteger) (createNativeQuery(sqlCountRows.append(condition).toString(), args.toArray())
                .getSingleResult());

        condition.append(" ORDER BY dc.gmt_created DESC");
        if (0 != criteria.getLimit()) {
            condition.append(" LIMIT ?, ?");
            args.add(criteria.getOffset());
            args.add(criteria.getLimit());
        }
        List<DesignContestDO> list = queryNative(sqlFetchRows.append(condition).toString(), args.toArray());

        return new Pagination(count.intValue(), list);
    }

    @Override
    public List<DesignContestDO> getContestsByIds(List<Integer> ids) {
        if (null == ids || ids.size() <= 0) {
            return new ArrayList<DesignContestDO>();
        }

        Map<String, Object> args = new HashMap<String, Object>();
        args.put("ids", ids);
        return queryNamed("DesignContestDO.getContestsByIds", args);
    }

    @Override
    public List<DesignContestDO> getAllEnabledContests() {
        return queryNamed("DesignContestDO.getAllEnabledContests");
    }

}