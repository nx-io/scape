package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.DesignContestEntryVoteDAO;
import me.scape.ti.dataobject.DesignContestEntryVoteDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:10:33
 */
@Repository(value = "designContestEntryVoteDAO")
public class DefaultDesignContestEntryVoteDAO extends DefaultGenericDAO<DesignContestEntryVoteDO, Long> implements DesignContestEntryVoteDAO {
	
}