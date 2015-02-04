package me.scape.ti.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.ItemQueryCriteria;
import me.scape.ti.dao.AreaCategoryDAO;
import me.scape.ti.dao.CategoryDAO;
import me.scape.ti.dao.ItemDAO;
import me.scape.ti.dao.ItemMediaDAO;
import me.scape.ti.dao.StyleDAO;
import me.scape.ti.dao.UserDAO;
import me.scape.ti.dataobject.AreaCategoryDO;
import me.scape.ti.dataobject.CategoryDO;
import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.dataobject.ItemMediaDO;
import me.scape.ti.dataobject.StyleDO;
import me.scape.ti.dataobject.UserDO;
import me.scape.ti.service.ItemService;
import me.scape.ti.utils.CDNUtil;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.ItemDetailVO;
import me.scape.ti.vo.ItemListVO;
import me.scape.ti.vo.MediaVO;
import me.scape.ti.vo.request.ItemListRequest;
import me.scape.ti.vo.request.ItemRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class ItemServiceImpl extends BaseServiceImpl implements ItemService {

    @Resource
    private ItemDAO itemDAO;

    @Resource
    private ItemMediaDAO itemMediaDAO;

    @Resource
    private AreaCategoryDAO areaCategoryDAO;

    @Resource
    private CategoryDAO categoryDAO;

    @Resource
    private StyleDAO styleDAO;

    @Resource
    private UserDAO userDAO;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public CurrentPage<ItemListVO> ListItems(ItemListRequest itemListRequest) {
        ItemQueryCriteria criteria = new ItemQueryCriteria();

        criteria.setTitle(itemListRequest.getTitle());
        criteria.setStatus(itemListRequest.getStatus());
        criteria.setType(itemListRequest.getType());
        criteria.setArea_category_id(itemListRequest.getArea_category_id());
        criteria.setCategory_id(itemListRequest.getCategory_id());
        criteria.setStyle_id(itemListRequest.getStyle_id());

        int curn = itemListRequest.getCurn() > 0 ? itemListRequest.getCurn() : 1;
        int pageSize = itemListRequest.getPs();
        criteria.setOffset((curn - 1) * pageSize);
        criteria.setLimit(pageSize);

        Pagination<ItemDO> items = itemDAO.ListItems(criteria);

        List<ItemListVO> itemVOs = formatItems(items.getItems());

        return new CurrentPage(curn, items.getCount(), pageSize, itemVOs);
    }

    private List<ItemListVO> formatItems(List<ItemDO> items) {
        List<ItemListVO> itemVOs = new ArrayList<ItemListVO>();
        if (null == items || items.size() <= 0) {
            return itemVOs;
        }

        List<Long> categoryIds = new ArrayList<Long>();
        List<Long> areaCategoryIds = new ArrayList<Long>();
        List<Long> styleIds = new ArrayList<Long>();
        List<Long> userIds = new ArrayList<Long>();
        for (ItemDO item : items) {
            Long categoryId = item.getCategory_id();
            if (!categoryIds.contains(categoryId)) {
                categoryIds.add(categoryId);
            }

            Long areaCategoryId = item.getArea_category_id();
            if (!areaCategoryIds.contains(areaCategoryId)) {
                areaCategoryIds.add(areaCategoryId);
            }

            Long styleId = item.getStyle_id();
            if (!styleIds.contains(styleId)) {
                styleIds.add(styleId);
            }

            Long userId = item.getUser_id();
            if (!userIds.contains(userId)) {
                userIds.add(userId);
            }
        }

        Map<Long, String> categoryMap = new HashMap<Long, String>();
        List<CategoryDO> categories = categoryDAO.getCategoriesByIds(categoryIds);
        for (CategoryDO category : categories) {
            categoryMap.put(category.getId(), category.getName());
        }

        Map<Long, String> areaCategoryMap = new HashMap<Long, String>();
        List<AreaCategoryDO> areaCategories = areaCategoryDAO.getAreaCategoriesByIds(areaCategoryIds);
        for (AreaCategoryDO areaCategory : areaCategories) {
            areaCategoryMap.put(areaCategory.getId(), areaCategory.getName());
        }

        Map<Long, String> styleMap = new HashMap<Long, String>();
        List<StyleDO> styles = styleDAO.getStylesByIds(styleIds);
        for (StyleDO style : styles) {
            styleMap.put(style.getId(), style.getName());
        }

        Map<Long, String> userMap = new HashMap<Long, String>();
        List<UserDO> users = userDAO.getUsersByIds(userIds);
        for (UserDO user : users) {
            userMap.put(user.getId(), user.getName());
        }

        for (ItemDO item : items) {
            ItemListVO itemListVO = new ItemListVO();
            itemListVO.setId(item.getId());
            itemListVO.setTitle(item.getTitle());
            itemListVO.setType(item.getType());
            itemListVO.setStatus(item.getStatus());
            itemListVO.setDesigner(item.getDesigner());

            Long areaCategoryId = item.getArea_category_id();
            Long categoryId = item.getCategory_id();
            Long styleId = item.getStyle_id();
            itemListVO.setArea_category(areaCategoryMap.get(areaCategoryId));
            itemListVO.setCategory(categoryMap.get(categoryId));
            itemListVO.setStyle(styleMap.get(styleId));

            Long userId = item.getUser_id();
            if (null != userId && 0 != userId) {
                itemListVO.setUser_id(userId);
                itemListVO.setUser_name(userMap.get(userId));
            }

            itemListVO.setCover_media(CDNUtil.getFullPath(item.getCover_media()));

            itemListVO.setComment_count(item.getComment_count());
            itemListVO.setLike_count(item.getLike_count());
            itemListVO.setPraise_count(item.getPraise_count());
            itemListVO.setGmt_created(item.getGmt_created());

            itemVOs.add(itemListVO);
        }

        return itemVOs;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public long createItem(ItemRequest itemRequest) {
        Date now = new Date();

        ItemDO item = new ItemDO();
        item.setTitle(itemRequest.getTitle());
        item.setType(itemRequest.getType());
        item.setStatus(itemRequest.getStatus());
        item.setCategory_id(itemRequest.getCategory_id());
        item.setArea_category_id(itemRequest.getArea_category_id());
        item.setStyle_id(itemRequest.getStyle_id());
        item.setDescription(itemRequest.getDescription());
        item.setDesigner(itemRequest.getDesigner());
        item.setDesigner_contact(itemRequest.getDesigner_contact());
        item.setConstructor(itemRequest.getConstructor());
        item.setConstructor_contact(itemRequest.getConstructor_contact());

        item.setUser_id(0L);
        item.setComment_count(0);
        item.setLike_count(0);
        item.setPraise_count(0);

        item.setGmt_created(now);
        item.setGmt_modified(now);

        List<ItemMediaDO> itemMediaList = new ArrayList<ItemMediaDO>();
        List<String> medias = itemRequest.getMedias();
        if (null != medias) {
			for (String media : medias) {
				if (StringUtils.isNotBlank(media)) {
					ItemMediaDO itemMedia = new ItemMediaDO();
					itemMedia.setUrl(media);
					itemMedia.setStatus(ItemMediaDO.Available);
					itemMedia.setType(ItemMediaDO.IMG);
					itemMedia.setGmt_created(now);
					itemMedia.setGmt_modified(now);

					itemMediaList.add(itemMedia);
				}
			}
        }

        item.setCover_media(itemRequest.getCover_media());
        item.setMedia_count(itemMediaList.size());
        itemDAO.persist(item);

        Long itemId = item.getId();

        for (ItemMediaDO media : itemMediaList) {
            media.setItem_id(itemId);

            itemMediaDAO.persist(media);
        }

        return itemId;
    }

    @Override
    public ItemDetailVO getItemDetail(long itemId) {
        ItemDetailVO itemDetailVO = new ItemDetailVO();

        ItemDO item = itemDAO.get(itemId);
        if (null == item) {
            return itemDetailVO;
        }

        itemDetailVO.setId(item.getId());
        itemDetailVO.setTitle(item.getTitle());
        itemDetailVO.setType(item.getType());

        Long areaCategoryId = item.getArea_category_id();
        itemDetailVO.setArea_category_id(areaCategoryId);
        AreaCategoryDO areaCategory = areaCategoryDAO.get(areaCategoryId);
        if (null != areaCategory) {
            itemDetailVO.setArea_category_name(areaCategory.getName());
        }

        Long categoryId = item.getCategory_id();
        itemDetailVO.setCategory_id(categoryId);
        CategoryDO category = categoryDAO.get(categoryId);
        if (null != category) {
            itemDetailVO.setCategory_name(category.getName());
        }

        Long styleId = item.getStyle_id();
        itemDetailVO.setStyle_id(styleId);
        StyleDO style = styleDAO.get(styleId);
        if (null != style) {
            itemDetailVO.setStyle_name(style.getName());
        }

        itemDetailVO.setStatus(item.getStatus());
        itemDetailVO.setDesigner(item.getDesigner());
        itemDetailVO.setDesigner_contact(item.getDesigner_contact());
        itemDetailVO.setConstructor(item.getConstructor());
        itemDetailVO.setConstructor_contact(item.getConstructor_contact());
        itemDetailVO.setDescription(item.getDescription());

        Long userId = item.getUser_id();
        if (null != userId && 0 != userId) {
            UserDO userDO = userDAO.get(userId);
            itemDetailVO.setUser_id(userId);
            itemDetailVO.setUser_name(userDO.getName());
        }

        itemDetailVO.setComment_count(item.getComment_count());
        itemDetailVO.setLike_count(item.getLike_count());
        itemDetailVO.setPraise_count(item.getPraise_count());
        itemDetailVO.setMedia_count(item.getMedia_count());
        itemDetailVO.setGmt_created(item.getGmt_created());

        MediaVO coverMedia = new MediaVO();
        String coverMediaPath = item.getCover_media();
        coverMedia.setPath(coverMediaPath);
        coverMedia.setUrl(CDNUtil.getFullPath(coverMediaPath));
        itemDetailVO.setCover_media(coverMedia);

        List<ItemMediaDO> itemMediaList = itemMediaDAO.getItemMediasByItemId(itemId);
        if (!CollectionUtils.isEmpty(itemMediaList)) {
            List<MediaVO> medias = new ArrayList<MediaVO>();
            for (ItemMediaDO itemMediaDO : itemMediaList) {
                MediaVO media = new MediaVO();
                String path = itemMediaDO.getUrl();
                media.setPath(path);
                media.setUrl(CDNUtil.getFullPath(path));

                medias.add(media);
            }

            itemDetailVO.setMedias(medias);
        }

        return itemDetailVO;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public void editItem(long itemId, ItemRequest itemRequest) {
        ItemDO item = itemDAO.get(itemId);
        if (null == item) {
            return;
        }

        Date now = new Date();

        item.setTitle(itemRequest.getTitle());
        item.setType(itemRequest.getType());
        item.setStatus(itemRequest.getStatus());
        item.setCategory_id(itemRequest.getCategory_id());
        item.setArea_category_id(itemRequest.getArea_category_id());
        item.setStyle_id(itemRequest.getStyle_id());
        item.setDescription(itemRequest.getDescription());
        item.setDesigner(itemRequest.getDesigner());
        item.setDesigner_contact(itemRequest.getDesigner_contact());
        item.setConstructor(itemRequest.getConstructor());
        item.setConstructor_contact(itemRequest.getConstructor_contact());

        item.setUser_id(item.getUser_id());
        item.setComment_count(item.getComment_count());
        item.setLike_count(item.getLike_count());
        item.setPraise_count(item.getPraise_count());

        item.setGmt_modified(now);

        List<ItemMediaDO> itemMediaList = itemMediaDAO.getItemMediasByItemId(itemId);
        List<String> itemMedias = new ArrayList<String>();
        for (ItemMediaDO itemMediaDO : itemMediaList) {
            itemMedias.add(itemMediaDO.getUrl());
        }

        int itemMediaSize = 0;
        List<String> medias = itemRequest.getMedias();
        if (null != medias) {
            for (String media : medias) {
				if (StringUtils.isNotBlank(media)) {
					if (!itemMedias.contains(media)) {
						ItemMediaDO itemMedia = new ItemMediaDO();
						itemMedia.setItem_id(itemId);
						itemMedia.setUrl(media);
						itemMedia.setStatus(ItemMediaDO.Available);
						itemMedia.setType(ItemMediaDO.IMG);
						itemMedia.setGmt_created(now);
						itemMedia.setGmt_modified(now);

						itemMediaDAO.persist(itemMedia);
					}

					itemMediaSize++;
				}
            }

            for (ItemMediaDO itemMediaDO : itemMediaList) {
                if (!medias.contains(itemMediaDO.getUrl())) {
                    itemMediaDO.setStatus(ItemMediaDO.Strike_out);
                    itemMediaDO.setGmt_modified(now);
                }
            }
        } else {
            for (ItemMediaDO itemMediaDO : itemMediaList) {
                itemMediaDO.setStatus(ItemMediaDO.Strike_out);
                itemMediaDO.setGmt_modified(now);
            }
        }

        item.setCover_media(itemRequest.getCover_media());
        item.setMedia_count(itemMediaSize);
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public void deleteItem(long itemId) {
        ItemDO item = itemDAO.get(itemId);
        if (null == item) {
            return;
        }

        Date now = new Date();

        item.setStatus(ItemDO.Strike_out);
        item.setGmt_modified(now);

        List<ItemMediaDO> itemMediaList = itemMediaDAO.getItemMediasByItemId(itemId);
        for (ItemMediaDO itemMediaDO : itemMediaList) {
            itemMediaDO.setStatus(ItemMediaDO.Strike_out);
            itemMediaDO.setGmt_modified(now);
        }
    }
}
