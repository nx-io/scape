package me.scape.ti.controller;

import java.util.HashMap;
import java.util.Map;

import me.scape.ti.constant.ResponseStatus;
import me.scape.ti.service.AreaCategoryService;
import me.scape.ti.service.CategoryService;
import me.scape.ti.service.ItemService;
import me.scape.ti.service.StyleService;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.ItemDetailVO;
import me.scape.ti.vo.ItemListVO;
import me.scape.ti.vo.request.ItemListRequest;
import me.scape.ti.vo.request.ItemRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AreaCategoryService areaCategoryService;

    @Autowired
    private StyleService styleService;

    @RequestMapping("/item/list")
    public String listItem(@ModelAttribute ItemListRequest itemListRequest, Model model) {
        CurrentPage<ItemListVO> result = itemService.ListItems(itemListRequest);
        model.addAttribute("curn", result.getCurn());
        model.addAttribute("totaln", result.getTotaln());
        model.addAttribute("items", result.getItems());
        model.addAttribute("ps", itemListRequest.getPs());

        model.addAttribute("request", itemListRequest);

        StringBuilder condition = new StringBuilder();
        if (null != itemListRequest.getStatus()) {
            condition.append("&status=").append(itemListRequest.getStatus());
        }
        if (StringUtils.isNotEmpty(itemListRequest.getTitle())) {
            condition.append("&title=").append(itemListRequest.getTitle());
        }
        if (null != itemListRequest.getType()) {
            condition.append("&type = ?").append(itemListRequest.getType());
        }
        if (null != itemListRequest.getCategory_id()) {
            condition.append("&category_id = ?").append(itemListRequest.getCategory_id());
        }
        if (null != itemListRequest.getArea_category_id()) {
            condition.append("&area_category_id = ?").append(itemListRequest.getArea_category_id());
        }
        if (null != itemListRequest.getStyle_id()) {
            condition.append("&style_id = ?").append(itemListRequest.getStyle_id());
        }

        model.addAttribute("condition", condition.toString());

        return "item/list";
    }

    @RequestMapping("/item/addPage")
    public String getAddItemPage(Model model) {
        model.addAttribute("item", new ItemDetailVO());
        model.addAttribute("categories", categoryService.getAllActiveCategories());
        model.addAttribute("areaCategories", areaCategoryService.getAllActiveAreaCategories());
        model.addAttribute("styles", styleService.getAllActiveStyles());

        return "item/form";
    }

    @RequestMapping(value = "/item/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute ItemRequest itemRequest, Model model) {
        long itemId = itemService.createItem(itemRequest);

        // return "redirect:/item/detail?id=" + itemId;
        return "redirect:/item/list";
    }

    @RequestMapping("/item/editPage")
    public String getEditContentPage(long itemId, Model model) {
        model.addAttribute("item", itemService.getItemDetail(itemId));
        model.addAttribute("categories", categoryService.getAllActiveCategories());
        model.addAttribute("areaCategories", areaCategoryService.getAllActiveAreaCategories());
        model.addAttribute("styles", styleService.getAllActiveStyles());

        return "item/form";
    }

    @RequestMapping(value = "/item/edit", method = RequestMethod.POST)
    public String getEditContentPage(long id, @ModelAttribute ItemRequest itemRequest) {
        itemService.editItem(id, itemRequest);

        // return "redirect:/item/detail?id=" + itemId;
        return "redirect:/item/list";
    }

    @RequestMapping("/item/delete")
    @ResponseBody
    public Map<String, Object> deleteItem(int itemId) {
        itemService.deleteItem(itemId);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", ResponseStatus.SUCCEED.getValue());

        return map;
    }
}
