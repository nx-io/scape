package me.scape.ti.dao;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.TaskQueryCriteria;
import me.scape.ti.dataobject.TaskDO;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 *
 * @version 1.0.0
 * @since 2015年10月13日 下午6:56:26
 */
public interface TaskDAO extends GenericDAO<TaskDO, Long> {

    Pagination<TaskDO> query(TaskQueryCriteria criteria);
}