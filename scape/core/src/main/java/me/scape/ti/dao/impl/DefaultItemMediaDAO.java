package me.scape.ti.dao.impl;

import java.util.List;

import me.scape.ti.dao.ItemMediaDAO;
import me.scape.ti.dataobject.ItemMediaDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:46:30
 */
@Repository(value = "itemMediaDAO")
public class DefaultItemMediaDAO extends DefaultGenericDAO<ItemMediaDO, Long> implements ItemMediaDAO {

	@Override
	public List<ItemMediaDO> getItemMediasByItemId(Long itemId) {
		return queryNamed("ItemMedia.getItemMediaByItemId", new Object[] { itemId });
	}

}