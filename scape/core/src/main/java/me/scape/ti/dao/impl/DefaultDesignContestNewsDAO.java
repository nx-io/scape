package me.scape.ti.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.DesignContestNewsQueryCriteria;
import me.scape.ti.dao.DesignContestNewsDAO;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dataobject.DesignContestNewsDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年3月8日 下午7:02:36
 */
@Repository("designContestNewsDAO")
public class DefaultDesignContestNewsDAO extends EntityManagerSupportGenericDAO<DesignContestNewsDO, Long> implements
        DesignContestNewsDAO {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Pagination<DesignContestNewsDO> listDesignContestNews(DesignContestNewsQueryCriteria criteria) {
        List<Object> args = new ArrayList<Object>();

        StringBuilder sqlCountRows = new StringBuilder();
        sqlCountRows.append("SELECT count(*) FROM design_contest_news dcn where 1 = 1");

        StringBuilder sqlFetchRows = new StringBuilder();
        sqlFetchRows.append("SELECT dcn.* FROM design_contest_news dcn where 1 = 1");

        StringBuilder condition = new StringBuilder();

        BigInteger count = (BigInteger) (createNativeQuery(sqlCountRows.append(condition).toString(), args.toArray())
                .getSingleResult());

        condition.append(" ORDER BY dcn.gmt_created DESC, dcn.contest_id DESC");
        if (0 != criteria.getLimit()) {
            condition.append(" LIMIT ?, ?");
            args.add(criteria.getOffset());
            args.add(criteria.getLimit());
        }
        List<DesignContestNewsDO> list = queryNative(sqlFetchRows.append(condition).toString(), args.toArray());

        return new Pagination(count.intValue(), list);
    }

}