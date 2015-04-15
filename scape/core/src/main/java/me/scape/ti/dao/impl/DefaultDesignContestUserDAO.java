package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.DesignContestUserDAO;
import me.scape.ti.dataobject.DesignContestUserDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:14:25
 */
@Repository("designContestUserDAO")
public class DefaultDesignContestUserDAO extends DefaultGenericDAO<DesignContestUserDO, Long> implements DesignContestUserDAO {

}
