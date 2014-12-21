package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.ItemMediaDAO;
import me.scape.ti.dataobject.ItemMediaDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:46:30
 */
@Repository(value = "itemMediaDAO")
public class DefaultItemMediaDAO extends DefaultGenericDAO<ItemMediaDO, Long> implements ItemMediaDAO {
	
}