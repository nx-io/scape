package me.scape.ti.dao.impl;

import me.scape.ti.dao.DesignContestUserDAO;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dataobject.DesignContestUserDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:14:25
 */
@Repository("designContestUserDAO")
public class DefaultDesignContestUserDAO extends EntityManagerSupportGenericDAO<DesignContestUserDO, Long> implements DesignContestUserDAO {

}
