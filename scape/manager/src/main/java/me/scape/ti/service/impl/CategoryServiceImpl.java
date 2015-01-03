package me.scape.ti.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import me.scape.ti.dao.CategoryDAO;
import me.scape.ti.dataobject.CategoryDO;
import me.scape.ti.service.CategoryService;
import me.scape.ti.vo.CategoryListVO;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDAO categoryDAO;

    @Override
    public List<CategoryListVO> getAllCategories() {
        List<CategoryListVO> categoryVOs = new ArrayList<CategoryListVO>();

        List<CategoryDO> categories = categoryDAO.getAllCategories();
        for (CategoryDO category : categories) {
            CategoryListVO vo = new CategoryListVO();
            vo.setId(category.getId());
            vo.setName(category.getName());
            vo.setIcon(category.getIcon());
            vo.setGmt_created(category.getGmt_created());

            categoryVOs.add(vo);
        }

        return categoryVOs;
    }

    @Override
    public List<CategoryListVO> getAllActiveCategories() {
        List<CategoryListVO> categoryVOs = new ArrayList<CategoryListVO>();

        List<CategoryDO> categories = categoryDAO.getAllCategories();
        for (CategoryDO category : categories) {
            if (1 == category.getDisplay().intValue()) {
                CategoryListVO vo = new CategoryListVO();
                vo.setId(category.getId());
                vo.setName(category.getName());
                vo.setIcon(category.getIcon());
                vo.setGmt_created(category.getGmt_created());

                categoryVOs.add(vo);
            }
        }

        return categoryVOs;
    }

}
