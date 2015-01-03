package me.scape.ti.service;

import java.util.List;

import me.scape.ti.vo.AreaCategoryListVO;

public interface AreaCategoryService {
    List<AreaCategoryListVO> getAllAreaCategories();

    List<AreaCategoryListVO> getAllActiveAreaCategories();

}
