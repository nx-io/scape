package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.ItemFavoriteDAO;
import me.scape.ti.dataobject.ItemFavoriteDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:44:49
 */
@Repository(value = "itemFavoriteDAO")
public class DefaultItemFavoriteDAO extends DefaultGenericDAO<ItemFavoriteDO, Long> implements ItemFavoriteDAO {
	
}