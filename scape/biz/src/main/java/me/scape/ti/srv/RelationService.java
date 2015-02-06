package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.ro.CommentsRequest;
import me.scape.ti.ro.ItemFavoriteRequest;
import me.scape.ti.ro.PageRequest;
import me.scape.ti.ro.UserFavoriteRequest;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午3:35:44
 */
public interface RelationService {

	Result comments(CommentsRequest request);

	Result favorite_item(ItemFavoriteRequest request);

	Result favorite_user(UserFavoriteRequest request);

	Result getFavoriteItems(PageRequest request);

	Result getFavoriteUsers(PageRequest request);

}