package me.scape.ti.dao;

import java.util.List;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.UserQueryCriteria;
import me.scape.ti.dataobject.UserDO;
import me.scape.ti.jpa.GenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:31:47
 */
public interface UserDAO extends GenericDAO<UserDO, Long> {

    List<UserDO> getUsersByIds(List<Long> ids);

    Pagination<UserDO> ListUsers(UserQueryCriteria criteria);
}