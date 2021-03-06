package me.scape.ti.dao.impl;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.ItemFavoriteDAO;
import me.scape.ti.dataobject.ItemFavoriteDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:44:49
 */
@Repository("itemFavoriteDAO")
public class DefaultItemFavoriteDAO extends EntityManagerSupportGenericDAO<ItemFavoriteDO, Long> implements ItemFavoriteDAO {

}