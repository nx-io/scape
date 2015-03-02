package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.DesignContestJudgesDAO;
import me.scape.ti.dataobject.DesignContestJudgesDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:04:00
 */
@Repository(value = "designContestJudgesDAO")
public class DefaultDesignContestJudgesDAO extends DefaultGenericDAO<DesignContestJudgesDO, Long> implements DesignContestJudgesDAO {
	
}