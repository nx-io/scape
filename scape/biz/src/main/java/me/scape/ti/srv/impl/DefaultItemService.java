package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.AreaCategoryDO;
import me.scape.ti.dataobject.CategoryDO;
import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.dataobject.ItemMediaDO;
import me.scape.ti.dataobject.StyleDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.ItemPublishRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.ItemService;
import me.scape.ti.vo.AreaCategoryVO;
import me.scape.ti.vo.CategoryVO;
import me.scape.ti.vo.ItemMediaVO;
import me.scape.ti.vo.ItemVO;
import me.scape.ti.vo.StyleVO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:33:16
 */
@Service(value = "itemService")
public class DefaultItemService extends BaseService implements ItemService {

	@Override
	public Result publish(ItemPublishRequest request) {
		if(StringUtils.isBlank(request.getTitle())) {
			return Result.newError().with(ResultCode.Error_Valid_Request);
		}
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
		item.setUser_id(request.getUser_id());
		itemDAO.persist(item);
		ItemVO itemVO = ItemVO.newInstance(item);
		if(StringUtils.isNotBlank(request.getItemMedias())) {
			String[] medias = StringUtils.split(request.getItemMedias(), ",");
			if(medias != null && medias.length > 0) {
				List<ItemMediaDO> itemMediaList = new ArrayList<ItemMediaDO>();
				Date now = new Date();
				for (String media : medias) {
					ItemMediaDO itemMedia = new ItemMediaDO();
					itemMedia.setGmt_created(now);
					itemMedia.setGmt_modified(now);
					itemMedia.setItem_id(item.getId());
					itemMedia.setStatus(ItemMediaDO.Available);
					itemMedia.setType(ItemMediaDO.IMG);
					itemMedia.setUrl(media);
					itemMediaDAO.persist(itemMedia);
					itemMediaList.add(itemMedia);
				}
				itemVO.setItemMediaList(ItemMediaVO.newInstanceList(itemMediaList));
			}
		}
		AreaCategoryDO areaCategoryDO = areaCategoryDAO.findById(item.getArea_category_id());
		itemVO.setAreaCategory(AreaCategoryVO.newInstance(areaCategoryDO));
		CategoryDO categoryDO = categoryDAO.findById(item.getCategory_id());
		itemVO.setCategory(CategoryVO.newInstance(categoryDO));
		StyleDO styleDO = styleDAO.findById(item.getStyle_id());
		itemVO.setStyle(StyleVO.newInstance(styleDO));
		return Result.newSuccess().with(ResultCode.Success).with("item", itemVO);
	}
	
	@Override
	public Result getItem(Long itemId) {
		if (itemId == null || itemId <= 0L) {
			return Result.newError().with(ResultCode.Error_Item_Detail);
		}
		ItemDO item = itemDAO.findById(itemId);
		if (item == null) {
			return Result.newError().with(ResultCode.Error_Item_Detail);
		}
		ItemVO itemVO = ItemVO.newInstance(item);
		List<ItemMediaDO> itemMediaList = itemMediaDAO.findByNamedQuery("ItemMedia.getItemMediaByItemId",
				new Object[] { item.getId() });
		if(!CollectionUtils.isEmpty(itemMediaList)) {
			itemVO.setItemMediaList(ItemMediaVO.newInstanceList(itemMediaList));
		}
		AreaCategoryDO areaCategoryDO = areaCategoryDAO.findById(item.getArea_category_id());
		itemVO.setAreaCategory(AreaCategoryVO.newInstance(areaCategoryDO));
		CategoryDO categoryDO = categoryDAO.findById(item.getCategory_id());
		itemVO.setCategory(CategoryVO.newInstance(categoryDO));
		StyleDO styleDO = styleDAO.findById(item.getStyle_id());
		itemVO.setStyle(StyleVO.newInstance(styleDO));
		return Result.newSuccess().with(ResultCode.Success).with("item", itemVO);
	}
}