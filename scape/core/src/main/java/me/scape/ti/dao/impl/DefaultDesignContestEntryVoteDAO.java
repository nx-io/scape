package me.scape.ti.dao.impl;

import me.scape.ti.dao.DesignContestEntryVoteDAO;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dataobject.DesignContestEntryVoteDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:10:33
 */
@Repository("designContestEntryVoteDAO")
public class DefaultDesignContestEntryVoteDAO extends EntityManagerSupportGenericDAO<DesignContestEntryVoteDO, Integer> implements DesignContestEntryVoteDAO {
	
}