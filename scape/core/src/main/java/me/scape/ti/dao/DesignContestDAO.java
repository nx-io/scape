package me.scape.ti.dao;

import java.util.List;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.DesignContestQueryCriteria;
import me.scape.ti.dataobject.DesignContestDO;
import me.scape.ti.jpa.GenericDAO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:00:22
 */
public interface DesignContestDAO extends GenericDAO<DesignContestDO, Integer> {

    Pagination<DesignContestDO> ListDesignContests(DesignContestQueryCriteria criteria);

    List<DesignContestDO> getContestsByIds(List<Integer> ids);

    List<DesignContestDO> getAllEnabledContests();
}