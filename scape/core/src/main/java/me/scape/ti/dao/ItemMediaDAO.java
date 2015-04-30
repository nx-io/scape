package me.scape.ti.dao;

import java.util.List;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.dataobject.ItemMediaDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:45:48
 */
public interface ItemMediaDAO extends GenericDAO<ItemMediaDO, Long> {
	List<ItemMediaDO> getItemMediasByItemId(Long itemId);
}