package me.scape.ti.dao;

import java.util.List;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.ItemQueryCriteria;
import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.jpa.GenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:41:43
 */
public interface ItemDAO extends GenericDAO<ItemDO, Long> {
	Pagination<ItemDO> queryItems(ItemQueryCriteria criteria);
	
	List<ItemDO> getUserItems(Long userId, Byte type);
}