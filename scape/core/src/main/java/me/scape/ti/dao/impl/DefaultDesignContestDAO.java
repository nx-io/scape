package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.DesignContestDAO;
import me.scape.ti.dataobject.DesignContestDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月2日 下午2:01:09
 */
@Repository(value = "designContestDAO")
public class DefaultDesignContestDAO extends DefaultGenericDAO<DesignContestDO, Integer> implements DesignContestDAO {
	
}