package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.dataobject.CommentsDO;
import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.dataobject.ItemMediaDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.ItemPublishRequest;
import me.scape.ti.ro.ItemSearchRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.ItemService;
import me.scape.ti.srv.PageQuery;
import me.scape.ti.vo.AreaCategoryVO;
import me.scape.ti.vo.CategoryVO;
import me.scape.ti.vo.CommentsVO;
import me.scape.ti.vo.ItemMediaVO;
import me.scape.ti.vo.ItemVO;
import me.scape.ti.vo.LabelVO;
import me.scape.ti.vo.StyleVO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:33:16
 */
@Service("itemService")
public class DefaultItemService extends BaseService implements ItemService {

	@Override
	public Result search(ItemSearchRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM item i WHERE 1 = 1 ");
		Map<String, Object> args = new HashMap<String, Object>();
		Long cid = request.getCid();
		if (cid != null && cid > 0L) {
			sb.append(" AND i.category_id = :cid ");
			args.put("cid", cid);
		}
		Long acid = request.getAcid();
		if (acid != null && acid > 0L) {
			sb.append(" AND i.area_category_id = :acid ");
			args.put("acid", acid);
		}
		Long sid = request.getSid();
		if (sid != null && sid > 0L) {
			sb.append(" AND i.style_id = :sid ");
			args.put("sid", sid);
		}
		String title = request.getTitle();
		if (StringUtils.isNotBlank(title)) {
			sb.append(" AND i.title LIKE :title ");
			args.put("title", "%" + title + "%");
		}
		Long id = request.getId();
		if (id != null && id > 0L) {
			sb.append(" AND i.id = :id ");
			args.put("id", id);
		}
		String sort = request.getSort();
		if (StringUtils.isNotBlank(sort)) {
			if (StringUtils.equals("mc", sort)) {
				sb.append(" ORDER BY i.media_count DESC, i.gmt_created DESC ");
			} else if (StringUtils.equals("cc", sort)) {
				sb.append(" ORDER BY i.comment_count DESC, i.gmt_created DESC ");
			} else if (StringUtils.equals("pc", sort)) {
				sb.append(" ORDER BY i.praise_count DESC, i.gmt_created DESC ");
			} else if (StringUtils.equals("lc", sort)) {
				sb.append(" ORDER BY i.like_count DESC, i.gmt_created DESC ");
			} else {
				sb.append(" ORDER BY i.gmt_created DESC ");
			}
		}
		sb.append(" LIMIT :start, :size ");
		Integer page = request.getPage();
		page = (page != null && page > 0) ? page : 1;
		PageQuery pageQuery = new PageQuery(page);
		args.put("start", pageQuery.getIndex());
		args.put("size", pageQuery.getSize());

		List<ItemDO> itemList = itemDAO.queryNative(sb.toString(), args);
		if (CollectionUtils.isEmpty(itemList)) {
			return Result.newError().with(ResultCode.Error_Item_Empty);
		}
		List<ItemVO> voList = new ArrayList<ItemVO>();
		for (ItemDO itemDO : itemList) {
			ItemVO vo = ItemVO.newInstance(itemDO);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return Result.newSuccess().with(ResultCode.Success).with("itemList", voList);
	}

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result publish(ItemPublishRequest request) {
		Result privileged = doPrivileged(request);
		if(!privileged.isSuccess()) {
			return privileged;
		}
		Long userId = privileged.getResponse(Long.class);
		if (StringUtils.isBlank(request.getTitle())) {
			return Result.newError().with(ResultCode.Error_Valid_Request);
		}
		Date now = new Date();
		ItemDO item = new ItemDO();
		item.setTitle(request.getTitle());
		Byte type = request.getType();
		item.setType((type != null && type > 0) ? type : 1);
		item.setCategory_id(request.getCategory_id());
		item.setArea_category_id(request.getArea_category_id());
		item.setStyle_id(request.getStyle_id());
		item.setDescription(request.getDescription());
		item.setDesigner(request.getDesigner());
		item.setDesigner_contact(request.getDesigner_contact());
		item.setConstructor(request.getConstructor());
		item.setConstructor_contact(request.getConstructor_contact());
		item.setUser_id(userId);
		item.setComment_count(0);
		item.setGmt_created(now);
		item.setGmt_modified(now);
		item.setLike_count(0);
		item.setMedia_count(0);
		item.setPraise_count(0);
		item.setStatus(ItemDO.Available);
		List<ItemMediaDO> itemMediaList = new ArrayList<ItemMediaDO>();
		if (StringUtils.isNotBlank(request.getItemMedias())) {
			String[] medias = StringUtils.split(request.getItemMedias(), ",");
			if (medias != null && medias.length > 0) {
				for (String media : medias) {
					ItemMediaDO itemMedia = new ItemMediaDO();
					itemMedia.setGmt_created(now);
					itemMedia.setGmt_modified(now);
					itemMedia.setStatus(ItemMediaDO.Available);
					itemMedia.setType(ItemMediaDO.IMG);
					itemMedia.setUrl(media);
					itemMediaList.add(itemMedia);
				}
			}
		}
		boolean isMediaEmpty = CollectionUtils.isEmpty(itemMediaList);
		if (isMediaEmpty) {
			item.setCover_media("");
		} else {
			item.setCover_media(itemMediaList.get(0).getUrl());
			item.setMedia_count(itemMediaList.size() + 1);
		}
		itemDAO.persist(item);
		if (!isMediaEmpty) {
			for (ItemMediaDO itemMedia : itemMediaList) {
				itemMedia.setItem_id(item.getId());
				itemMediaDAO.persist(itemMedia);
			}
		}
		ItemVO itemVO = ItemVO.newInstance(item);
		if (!isMediaEmpty) {
			itemVO.setItemMediaList(ItemMediaVO.newInstance(itemMediaList));
		}
		itemVO.setAreaCategory(AreaCategoryVO.newInstance(areaCategoryDAO.get(item.getArea_category_id())));
		itemVO.setCategory(CategoryVO.newInstance(categoryDAO.get(item.getCategory_id())));
		itemVO.setStyle(StyleVO.newInstance(styleDAO.get(item.getStyle_id())));
		return Result.newSuccess().with(ResultCode.Success).with("item", itemVO);
	}

	@Override
	public Result getItem(Long itemId) {
		if (itemId == null || itemId <= 0L) {
			return Result.newError().with(ResultCode.Error_Item_Detail);
		}
		ItemDO item = itemDAO.get(itemId);
		if (item == null) {
			return Result.newError().with(ResultCode.Error_Item_Detail);
		}
		ItemVO itemVO = ItemVO.newInstance(item);
		List<ItemMediaDO> itemMediaList = itemMediaDAO.queryNamed("ItemMedia.getItemMediaByItemId", new Object[] { item.getId() });
		if (!CollectionUtils.isEmpty(itemMediaList)) {
			itemVO.setItemMediaList(ItemMediaVO.newInstance(itemMediaList));
		}
		itemVO.setAreaCategory(AreaCategoryVO.newInstance(areaCategoryDAO.get(item.getArea_category_id())));
		itemVO.setCategory(CategoryVO.newInstance(categoryDAO.get(item.getCategory_id())));
		itemVO.setStyle(StyleVO.newInstance(styleDAO.get(item.getStyle_id())));
		itemVO.setLabelList(LabelVO.newInstance(labelDAO.queryNamed("Label.getLabelByItemId", new Object[] { item.getId() })));
		List<CommentsDO> commentsDOList = commentsDAO.query("FROM CommentsDO WHERE item_id = ?", new Object[] { itemId });
		List<CommentsVO> commentsVOList = CommentsVO.newInstance(commentsDOList);
		if(commentsVOList != null && !commentsVOList.isEmpty()) {
			for (CommentsVO comments : commentsVOList) {
				comments.setChildComments(CommentsVO.newInstance(commentsDAO.query("FROM CommentsDO WHERE ref_id = ?", new Object[] { comments.getId() })));
			}
		}
		return Result.newSuccess().with(ResultCode.Success)
				.with("item", itemVO)
				.with("commentsList", commentsVOList);
	}
}