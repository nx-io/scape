package me.scape.ti.dao.impl;

import me.scape.ti.dao.DesignContestEntryDAO;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dataobject.DesignContestEntryDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:06:33
 */
@Repository("designContestEntryDAO")
public class DefaultDesignContestEntryDAO extends EntityManagerSupportGenericDAO<DesignContestEntryDO, Integer> implements DesignContestEntryDAO {
	
}