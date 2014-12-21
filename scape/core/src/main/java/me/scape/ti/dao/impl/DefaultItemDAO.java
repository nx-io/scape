package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.ItemDAO;
import me.scape.ti.dataobject.ItemDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:42:32
 */
@Repository(value = "itemDAO")
public class DefaultItemDAO extends DefaultGenericDAO<ItemDO, Long> implements ItemDAO {
	
}