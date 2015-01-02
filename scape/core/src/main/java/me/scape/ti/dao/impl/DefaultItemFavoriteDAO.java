package me.scape.ti.dao.impl;

import me.scape.ti.dao.ItemFavoriteDAO;
import me.scape.ti.dataobject.ItemFavoriteDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:44:49
 */
@Repository(value = "itemFavoriteDAO")
public class DefaultItemFavoriteDAO extends DefaultGenericDAO<ItemFavoriteDO, Long> implements ItemFavoriteDAO {
	
}