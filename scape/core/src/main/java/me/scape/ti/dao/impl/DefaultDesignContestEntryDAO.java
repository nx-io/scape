package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.DesignContestEntryDAO;
import me.scape.ti.dataobject.DesignContestEntryDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:06:33
 */
@Repository("designContestEntryDAO")
public class DefaultDesignContestEntryDAO extends DefaultGenericDAO<DesignContestEntryDO, Integer> implements DesignContestEntryDAO {
	
}