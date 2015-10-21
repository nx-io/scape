package me.scape.ti.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.TaskQueryCriteria;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.TaskDAO;
import me.scape.ti.dataobject.TaskDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:03:49
 */
@SuppressWarnings({"unchecked", "rawtypes"})
@Repository("taskDAO")
public class DefaultTaskDAO extends EntityManagerSupportGenericDAO<TaskDO, Long> implements TaskDAO {
    
    @Override
    public Pagination<TaskDO> query(TaskQueryCriteria criteria) {
        List<Object> args = new ArrayList<Object>();

        StringBuilder sqlCountRows = new StringBuilder();
        sqlCountRows.append("SELECT count(*) FROM task i where 1 = 1");

        StringBuilder sqlFetchRows = new StringBuilder();
        sqlFetchRows.append("SELECT i.* FROM task i where 1 = 1");

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
        if (null != criteria.getType() && criteria.getType() > 0) {
            condition.append(" AND i.type = ?");
            args.add(criteria.getType());
        }
        if (null != criteria.getPublishUserId() && criteria.getPublishUserId() > 0L) {
            condition.append(" AND i.user_id = ?");
            args.add(criteria.getPublishUserId());
        }
        if (null != criteria.getFromReward() && null != criteria.getToReward()) {
            condition.append(" AND i.reward BETWEEN ? AND ? ");
            args.add(criteria.getFromReward());
            args.add(criteria.getToReward());
        }
        if (null != criteria.getFromCreated() && null != criteria.getToCreated()) {
            condition.append(" AND i.gmt_created BETWEEN ? AND ? ");
            args.add(criteria.getFromCreated());
            args.add(criteria.getToCreated());
        }
        if (null != criteria.getFromStartDate() && null != criteria.getToStartDate()) {
            condition.append(" AND i.start_date BETWEEN ? AND ? ");
            args.add(criteria.getFromStartDate());
            args.add(criteria.getToStartDate());
        }

        BigInteger count = (BigInteger) (createNativeQuery(sqlCountRows.append(condition).toString(), args.toArray()).getSingleResult());

        condition.append(" ORDER BY i.gmt_created DESC");
        if (0 != criteria.getLimit()) {
            condition.append(" LIMIT ?, ?");
            args.add(criteria.getOffset());
            args.add(criteria.getLimit());
        }
        List<TaskDO> list = queryNative(sqlFetchRows.append(condition).toString(), args.toArray());

        return new Pagination(count.intValue(), list);
    }
}