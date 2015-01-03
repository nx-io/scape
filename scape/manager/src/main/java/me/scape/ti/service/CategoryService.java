package me.scape.ti.service;

import java.util.List;

import me.scape.ti.vo.CategoryListVO;

public interface CategoryService {
    List<CategoryListVO> getAllCategories();

    List<CategoryListVO> getAllActiveCategories();

}
