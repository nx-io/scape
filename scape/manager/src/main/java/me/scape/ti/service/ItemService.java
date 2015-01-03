package me.scape.ti.service;

import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.ItemDetailVO;
import me.scape.ti.vo.ItemListVO;
import me.scape.ti.vo.request.ItemListRequest;
import me.scape.ti.vo.request.ItemRequest;

public interface ItemService {
    CurrentPage<ItemListVO> ListItems(ItemListRequest itemListRequest);

    long createItem(ItemRequest itemRequest);

    ItemDetailVO getItemDetail(long itemId);

    void editItem(long itemId, ItemRequest itemRequest);

    void deleteItem(long itemId);
}
