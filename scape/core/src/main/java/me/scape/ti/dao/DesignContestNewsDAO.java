package me.scape.ti.dao;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.DesignContestNewsQueryCriteria;
import me.scape.ti.dataobject.DesignContestNewsDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0s
 * @since 2015年3月8日 下午7:01:21
 */
public interface DesignContestNewsDAO extends GenericDAO<DesignContestNewsDO, Long> {

    Pagination<DesignContestNewsDO> listDesignContestNews(DesignContestNewsQueryCriteria criteria);
}
