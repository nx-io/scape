package me.scape.ti.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import me.scape.ti.dao.AreaCategoryDAO;
import me.scape.ti.dataobject.AreaCategoryDO;
import me.scape.ti.service.AreaCategoryService;
import me.scape.ti.vo.AreaCategoryListVO;

import org.springframework.stereotype.Service;

@Service
public class AreaCategoryServiceImpl implements AreaCategoryService {

    @Resource
    private AreaCategoryDAO areaCategoryDAO;

    @Override
    public List<AreaCategoryListVO> getAllAreaCategories() {
        List<AreaCategoryListVO> areaCategoryVOs = new ArrayList<AreaCategoryListVO>();

        List<AreaCategoryDO> categories = areaCategoryDAO.getAllAreaCategories();
        for (AreaCategoryDO category : categories) {
            AreaCategoryListVO vo = new AreaCategoryListVO();
            vo.setId(category.getId());
            vo.setName(category.getName());
            vo.setIcon(category.getIcon());
            vo.setGmt_created(category.getGmt_created());

            areaCategoryVOs.add(vo);
        }

        return areaCategoryVOs;
    }

    @Override
    public List<AreaCategoryListVO> getAllActiveAreaCategories() {
        List<AreaCategoryListVO> areaCategoryVOs = new ArrayList<AreaCategoryListVO>();

        List<AreaCategoryDO> categories = areaCategoryDAO.getAllAreaCategories();
        for (AreaCategoryDO category : categories) {
            if (1 == category.getDisplay().intValue()) {
                AreaCategoryListVO vo = new AreaCategoryListVO();
                vo.setId(category.getId());
                vo.setName(category.getName());
                vo.setIcon(category.getIcon());
                vo.setGmt_created(category.getGmt_created());

                areaCategoryVOs.add(vo);
            }
        }

        return areaCategoryVOs;
    }

}
