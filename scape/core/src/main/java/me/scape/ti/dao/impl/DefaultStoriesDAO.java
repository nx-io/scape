package me.scape.ti.dao.impl;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.StoriesDAO;
import me.scape.ti.dataobject.StoriesDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:30:43
 */
@Repository(value = "storiesDAO")
public class DefaultStoriesDAO extends DefaultGenericDAO<StoriesDO, Long> implements StoriesDAO {
	
}