package me.scape.ti.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.UserQueryCriteria;
import me.scape.ti.dao.UserDAO;
import me.scape.ti.dataobject.UserDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:32:18
 */
@Repository(value = "userDAO")
public class DefaultUserDAO extends DefaultGenericDAO<UserDO, Long> implements UserDAO {

    @Override
    public List<UserDO> getUsersByIds(List<Long> ids) {
        if (null == ids || ids.size() <= 0) {
            return new ArrayList<UserDO>();
        }

        Map<String, Object> args = new HashMap<String, Object>();
        args.put("ids", ids);
        return queryNamed("User.getUsersByIds", args);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Pagination<UserDO> ListUsers(UserQueryCriteria criteria) {
        List<Object> args = new ArrayList<Object>();

        StringBuilder sqlCountRows = new StringBuilder();
        sqlCountRows.append("SELECT count(*) FROM user u where 1 = 1");

        StringBuilder sqlFetchRows = new StringBuilder();
        sqlFetchRows.append("SELECT u.* FROM user u where 1 = 1");

        StringBuilder condition = new StringBuilder();
        if (null != criteria.getStatus()) {
            condition.append(" AND u.status = ?");
            args.add(criteria.getStatus());
        } else {
            condition.append(" AND u.status != -1");
        }

        if (StringUtils.isNotEmpty(criteria.getName())) {
            condition.append(" AND u.name LIKE ?");
            args.add("%" + criteria.getName() + "%");
        }

        BigInteger count = (BigInteger) (createNativeQuery(sqlCountRows.append(condition).toString(), null,
                args.toArray()).getSingleResult());

        condition.append(" ORDER BY u.gmt_created DESC");
        if (0 != criteria.getLimit()) {
            condition.append(" LIMIT ?, ?");
            args.add(criteria.getOffset());
            args.add(criteria.getLimit());
        }
        List<UserDO> list = queryNative(sqlFetchRows.append(condition).toString(), args.toArray());

        return new Pagination(count.intValue(), list);
    }

}