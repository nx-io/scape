package me.scape.ti.srv.impl;

import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.ItemService;

import org.springframework.stereotype.Service;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:33:16
 */
@Service(value = "itemService")
public class DefaultItemService extends BaseService implements ItemService {

	@Override
	public Result getItem(Long itemId) {
		if(itemId == null || itemId <= 0L) {
			return Result.newError().with(ResultCode.Error_Item_Detail);
		}
		ItemDO item = itemDAO.findById(itemId);
		if(item == null) {
			return Result.newError().with(ResultCode.Error_Item_Detail);
		}
		return Result.newSuccess().with(ResultCode.Success).with("item", 000);
	}
}