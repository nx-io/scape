package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.StoriesAvatarDAO;
import me.scape.ti.dataobject.StoriesAvatarDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:28:40
 */
@Repository(value = "storiesAvatarDAO")
public class DefaultStoriesAvatarDAO extends DefaultGenericDAO<StoriesAvatarDO, Long> implements StoriesAvatarDAO {
	
}