package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.CommentsDO;
import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.dataobject.ItemFavoriteDO;
import me.scape.ti.dataobject.UserDO;
import me.scape.ti.dataobject.UserFavoriteDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.CommentsRequest;
import me.scape.ti.ro.ItemFavoriteRequest;
import me.scape.ti.ro.UserFavoriteRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.RelationService;
import me.scape.ti.vo.CommentsVO;
import me.scape.ti.vo.ItemVO;
import me.scape.ti.vo.UserVO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * 评论、赞、收藏的关系业务处理.
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午3:36:23
 */
@Service(value = "relationService")
public class DefaultRelationService extends BaseService implements RelationService {

	/**
	 * 发布评论
	 */
	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result comments(CommentsRequest request) {
		CommentsDO comments = new CommentsDO();
		comments.setContent(request.getContent());
		Date now = new Date();
		comments.setGmt_created(now);
		comments.setGmt_modified(now);
		comments.setItem_id(request.getItem_id());
		comments.setRef_id(request.getRef_id());
		comments.setStatus(CommentsDO.Available);
		comments.setUser_id(request.getUser_id());
		comments.setUser_name(request.getUser_name());
		commentsDAO.persist(comments);
		return Result.newSuccess().with(ResultCode.Success).with("comments", CommentsVO.newInstance(comments));
	}
	
	/**
	 * 收藏/赞景观
	 */
	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result favorite_item(ItemFavoriteRequest request) {
		Object[] args = new Object[]{ request.getUser_id(), request.getItem_id(), request.getType() };
		java.math.BigInteger c = (java.math.BigInteger) itemFavoriteDAO.createNativeQuery("SELECT COUNT(id) FROM item_favorite WHERE user_id = ? AND item_id = ? AND type = ?", args).getSingleResult();
		if(c != null && c.longValue() > 0L) {
			return Result.newSuccess().with(ResultCode.Error_Favorited);
		}
		ItemFavoriteDO favoriteDO = new ItemFavoriteDO();
		favoriteDO.setGmt_created(new Date());
		favoriteDO.setItem_id(request.getItem_id());
		favoriteDO.setType(request.getType());
		favoriteDO.setUser_id(request.getUser_id());
		itemFavoriteDAO.persist(favoriteDO);
		return Result.newSuccess().with(ResultCode.Success).with("favorite", favoriteDO);
	}
	
	/**
	 * 查询收藏的景观
	 */
	@Override
	public Result getFavoriteItems(Long userId, int page) {
		String sql = "SELECT * FROM item i WHERE i.id IN (SELECT ifav.item_id FROM item_favorite ifav WHERE ifav.type = 2 AND ifav.user_id = ?) LIMIT ?, 10";
		List<ItemDO> itemList = itemDAO.queryNative(sql, new Object[]{ userId, page });
		if(CollectionUtils.isEmpty(itemList)) {
			return Result.newError().with(ResultCode.Error_Favorite_Item_Empty);
		}
		List<ItemVO> voList = new ArrayList<ItemVO>();
		for (ItemDO itemDO : itemList) {
			ItemVO vo = ItemVO.newInstance(itemDO);
			if(vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return Result.newSuccess().with(ResultCode.Success).with("itemList", voList);
	}
	
	/**
	 * 收藏的用户
	 */
	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result favorite_user(UserFavoriteRequest request) {
		Object[] args = new Object[]{ request.getUser_id(), request.getFavorite_id() };
		java.math.BigInteger c = (java.math.BigInteger) userFavoriteDAO.createNativeQuery("SELECT COUNT(id) FROM user_favorite WHERE user_id = ? AND favorite_id = ?", args).getSingleResult();
		if(c != null && c.longValue() > 0L) {
			return Result.newSuccess().with(ResultCode.Error_User_Favorited);
		}
		UserFavoriteDO favoriteDO = new UserFavoriteDO();
		favoriteDO.setGmt_created(new Date());
		favoriteDO.setFavorite_id(request.getFavorite_id());
		favoriteDO.setUser_id(request.getUser_id());
		userFavoriteDAO.persist(favoriteDO);
		return Result.newSuccess().with(ResultCode.Success).with("favorite", favoriteDO);
	}
	
	/**
	 * 查询收藏的用户
	 */
	@Override
	public Result getFavoriteUsers(Long userId, int page) {
		String sql = "SELECT * FROM user u WHERE u.id in (SELECT ufav.favorite_id FROM user_favorite ufav WHERE ufav.user_id = ?) LIMIT ?, 10";
		List<UserDO> userList = userDAO.queryNative(sql, new Object[]{ userId, page });
		if(CollectionUtils.isEmpty(userList)) {
			return Result.newError().with(ResultCode.Error_Favorite_User_Empty);
		}
		List<UserVO> voList = new ArrayList<UserVO>();
		for (UserDO user : userList) {
			UserVO vo = UserVO.newInstance(user);
			if(vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return Result.newSuccess().with(ResultCode.Success).with("userList", voList);
	}
}