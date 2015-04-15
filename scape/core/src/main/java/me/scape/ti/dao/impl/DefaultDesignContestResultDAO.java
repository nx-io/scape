package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.DesignContestResultDAO;
import me.scape.ti.dataobject.DesignContestResultDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:12:49
 */
@Repository("designContestResultDAO")
public class DefaultDesignContestResultDAO extends DefaultGenericDAO<DesignContestResultDO, Long> implements DesignContestResultDAO {
	
}