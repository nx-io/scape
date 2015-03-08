package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.DesignContestNewsDAO;
import me.scape.ti.dataobject.DesignContestNewsDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年3月8日 下午7:02:36
 */
@Repository(value = "designContestNewsDAO")
public class DefaultDesignContestNewsDAO extends DefaultGenericDAO<DesignContestNewsDO, Long> implements DesignContestNewsDAO {

}