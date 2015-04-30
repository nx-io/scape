package me.scape.ti.dao;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.DesignContestJudgeQueryCriteria;
import me.scape.ti.dataobject.DesignContestJudgesDO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:03:02
 */
public interface DesignContestJudgesDAO extends GenericDAO<DesignContestJudgesDO, Long> {

    Pagination<DesignContestJudgesDO> listDesignContestJudge(DesignContestJudgeQueryCriteria criteria);
}