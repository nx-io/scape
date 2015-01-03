package me.scape.ti.service;

import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.ItemListVO;
import me.scape.ti.vo.request.ItemListRequest;
import me.scape.ti.vo.request.ItemRequest;

public interface ItemService {
    CurrentPage<ItemListVO> ListItems(ItemListRequest itemListRequest);

    long createItem(ItemRequest itemRequest);
}
