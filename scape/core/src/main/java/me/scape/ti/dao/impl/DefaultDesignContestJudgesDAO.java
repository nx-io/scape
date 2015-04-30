package me.scape.ti.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.DesignContestJudgeQueryCriteria;
import me.scape.ti.dao.DesignContestJudgesDAO;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dataobject.DesignContestJudgesDO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:04:00
 */
@Repository("designContestJudgesDAO")
public class DefaultDesignContestJudgesDAO extends EntityManagerSupportGenericDAO<DesignContestJudgesDO, Long> implements
        DesignContestJudgesDAO {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Pagination<DesignContestJudgesDO> listDesignContestJudge(DesignContestJudgeQueryCriteria criteria) {
        List<Object> args = new ArrayList<Object>();

        StringBuilder sqlCountRows = new StringBuilder();
        sqlCountRows.append("SELECT count(*) FROM design_contest_judges dcj where 1 = 1");

        StringBuilder sqlFetchRows = new StringBuilder();
        sqlFetchRows.append("SELECT dcj.* FROM design_contest_judges dcj where 1 = 1");

        StringBuilder condition = new StringBuilder();
        if (StringUtils.isNotEmpty(criteria.getName())) {
            condition.append(" AND dcj.name LIKE ?");
            args.add("%" + criteria.getName() + "%");
        }

        BigInteger count = (BigInteger) (createNativeQuery(sqlCountRows.append(condition).toString(), args.toArray())
                .getSingleResult());

        condition.append(" ORDER BY dcj.gmt_created DESC");
        if (0 != criteria.getLimit()) {
            condition.append(" LIMIT ?, ?");
            args.add(criteria.getOffset());
            args.add(criteria.getLimit());
        }
        List<DesignContestJudgesDO> list = queryNative(sqlFetchRows.append(condition).toString(), args.toArray());

        return new Pagination(count.intValue(), list);
    }

}