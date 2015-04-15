package me.scape.ti.dao.impl;

import me.scape.ti.dao.UserFavoriteDAO;
import me.scape.ti.dataobject.UserFavoriteDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:57:46
 */
@Repository("userFavoriteDAO")
public class DefaultUserFavoriteDAO extends DefaultGenericDAO<UserFavoriteDO, Long> implements UserFavoriteDAO {

}