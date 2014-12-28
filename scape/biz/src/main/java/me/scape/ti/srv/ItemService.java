package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.ro.ItemPublishRequest;
import me.scape.ti.ro.ItemSearchRequest;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:32:53
 */
public interface ItemService {

	Result getItem(Long itemId);

	Result publish(ItemPublishRequest request);

	Result search(ItemSearchRequest request);

}