package me.scape.ti.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.TaskApplyQueryCriteria;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.TaskUserDAO;
import me.scape.ti.dataobject.TaskUserDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:03:49
 */
@SuppressWarnings({"unchecked", "rawtypes"})
@Repository("taskUserDAO")
public class DefaultTaskUserDAO extends EntityManagerSupportGenericDAO<TaskUserDO, Long> implements TaskUserDAO {

    @Override
    public Pagination<TaskUserDO> query(TaskApplyQueryCriteria criteria) {
        List<Object> args = new ArrayList<Object>();

        StringBuilder sqlCountRows = new StringBuilder();
        sqlCountRows.append("SELECT count(*) FROM task_user i where 1 = 1");

        StringBuilder sqlFetchRows = new StringBuilder();
        sqlFetchRows.append("SELECT i.* FROM task_user i where 1 = 1");

        StringBuilder condition = new StringBuilder();
        if (null != criteria.getApplyUserId() || criteria.getApplyUserId() > 0L) {
            condition.append(" AND i.user_id = ?");
            args.add(criteria.getApplyUserId());
        }

        BigInteger count = (BigInteger) (createNativeQuery(sqlCountRows.append(condition).toString(), args.toArray()).getSingleResult());

        condition.append(" ORDER BY i.gmt_created DESC");
        if (0 != criteria.getLimit()) {
            condition.append(" LIMIT ?, ?");
            args.add(criteria.getOffset());
            args.add(criteria.getLimit());
        }
        List<TaskUserDO> list = queryNative(sqlFetchRows.append(condition).toString(), args.toArray());

        return new Pagination(count.intValue(), list);
    }
}