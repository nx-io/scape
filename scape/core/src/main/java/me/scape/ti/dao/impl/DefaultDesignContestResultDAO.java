package me.scape.ti.dao.impl;

import me.scape.ti.dao.DesignContestResultDAO;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dataobject.DesignContestResultDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:12:49
 */
@Repository("designContestResultDAO")
public class DefaultDesignContestResultDAO extends EntityManagerSupportGenericDAO<DesignContestResultDO, Long> implements DesignContestResultDAO {
	
}