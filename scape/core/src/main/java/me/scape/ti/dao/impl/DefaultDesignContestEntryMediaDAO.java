package me.scape.ti.dao.impl;

import me.scape.ti.dao.DesignContestEntryMediaDAO;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dataobject.DesignContestEntryMediaDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:08:36
 */
@Repository("designContestEntryMediaDAO")
public class DefaultDesignContestEntryMediaDAO extends EntityManagerSupportGenericDAO<DesignContestEntryMediaDO, Long> implements DesignContestEntryMediaDAO {
	
}