package me.scape.ti.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.PlantQueryCriteria;
import me.scape.ti.dao.PlantCategoryDAO;
import me.scape.ti.dao.PlantsDAO;
import me.scape.ti.dao.PlantsOrnamentalColorDAO;
import me.scape.ti.dao.PlantsOrnamentalPeriodDAO;
import me.scape.ti.dataobject.PlantCategoryDO;
import me.scape.ti.dataobject.PlantsDO;
import me.scape.ti.dataobject.PlantsOrnamentalColorDO;
import me.scape.ti.dataobject.PlantsOrnamentalPeriodDO;
import me.scape.ti.service.PlantService;
import me.scape.ti.utils.CDNUtil;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.PlantCategoryListVO;
import me.scape.ti.vo.PlantColorListVO;
import me.scape.ti.vo.PlantListVO;
import me.scape.ti.vo.PlantPeriodListVO;
import me.scape.ti.vo.request.PlantListRequest;

import org.springframework.stereotype.Service;

@Service
public class PlantServiceImpl implements PlantService {

    @Resource
    private PlantCategoryDAO plantCategoryDAO;

    @Resource
    private PlantsOrnamentalColorDAO plantsOrnamentalColorDAO;

    @Resource
    private PlantsOrnamentalPeriodDAO plantsOrnamentalPeriodDAO;

    @Resource
    private PlantsDAO plantsDAO;

    @Override
    public List<PlantCategoryListVO> listPlantCategories() {
        List<PlantCategoryListVO> categoryVOs = new ArrayList<PlantCategoryListVO>();

        List<PlantCategoryDO> categories = plantCategoryDAO.getAllCategories();
        for (PlantCategoryDO category : categories) {
            PlantCategoryListVO vo = new PlantCategoryListVO();
            vo.setId(category.getId());
            vo.setName(category.getName());
            vo.setIcon(CDNUtil.getFullPath(category.getIcon()));
            vo.setDisplay(category.getDisplay());
            vo.setGmt_created(category.getGmt_created());

            categoryVOs.add(vo);
        }

        return categoryVOs;
    }

    @Override
    public List<PlantColorListVO> listPlantColors() {
        List<PlantColorListVO> plantColorVOs = new ArrayList<PlantColorListVO>();

        List<PlantsOrnamentalColorDO> plantColors = plantsOrnamentalColorDAO.getAllPlantColors();
        for (PlantsOrnamentalColorDO plantColor : plantColors) {
            PlantColorListVO vo = new PlantColorListVO();
            vo.setId(plantColor.getId());
            vo.setColor(plantColor.getColor());
            vo.setIcon(CDNUtil.getFullPath(plantColor.getIcon()));
            vo.setDisplay(plantColor.getDisplay());
            vo.setGmt_created(plantColor.getGmt_created());

            plantColorVOs.add(vo);
        }

        return plantColorVOs;
    }

    @Override
    public List<PlantPeriodListVO> listPlantPeriods() {
        List<PlantPeriodListVO> plantPeriodVOs = new ArrayList<PlantPeriodListVO>();

        List<PlantsOrnamentalPeriodDO> plantPeriods = plantsOrnamentalPeriodDAO.getAllPlantPeriods();
        for (PlantsOrnamentalPeriodDO plantPeriod : plantPeriods) {
            PlantPeriodListVO vo = new PlantPeriodListVO();
            vo.setId(plantPeriod.getId());
            vo.setPeriod(plantPeriod.getPeriod());
            vo.setDisplay(plantPeriod.getDisplay());
            vo.setGmt_created(plantPeriod.getGmt_created());

            plantPeriodVOs.add(vo);
        }

        return plantPeriodVOs;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public CurrentPage<PlantListVO> ListPlants(PlantListRequest plantListRequest) {
        PlantQueryCriteria criteria = new PlantQueryCriteria();

        criteria.setName(plantListRequest.getName());
        criteria.setCat_id(plantListRequest.getCat_id());

        int curn = plantListRequest.getCurn() > 0 ? plantListRequest.getCurn() : 1;
        int pageSize = plantListRequest.getPs();
        criteria.setOffset((curn - 1) * pageSize);
        criteria.setLimit(pageSize);

        Pagination<PlantsDO> plants = plantsDAO.listPlants(criteria);

        List<PlantListVO> plantVOs = formatPlants(plants.getItems());

        return new CurrentPage(curn, plants.getCount(), pageSize, plantVOs);
    }

    private List<PlantListVO> formatPlants(List<PlantsDO> plants) {
        List<PlantListVO> plantVOs = new ArrayList<PlantListVO>();
        if (null == plants || plants.size() <= 0) {
            return plantVOs;
        }

        List<Integer> categoryIds = new ArrayList<Integer>();
        for (PlantsDO plant : plants) {
            Integer categoryId = plant.getCat_id();
            if (!categoryIds.contains(categoryId)) {
                categoryIds.add(categoryId);
            }
        }

        Map<Integer, String> categoryMap = new HashMap<Integer, String>();
        List<PlantCategoryDO> categories = plantCategoryDAO.getCategoriesByIds(categoryIds);
        for (PlantCategoryDO category : categories) {
            categoryMap.put(category.getId(), category.getName());
        }

        for (PlantsDO plant : plants) {
            PlantListVO vo = new PlantListVO();
            vo.setId(plant.getId());
            vo.setName_cn(plant.getName_cn());
            vo.setName_en(plant.getName_en());
            vo.setAlias_name(plant.getAlias_name());

            Integer categoryId = plant.getCat_id();
            vo.setCat_id(categoryId);
            vo.setCategory(categoryMap.get(categoryId));

            vo.setCover_media(CDNUtil.getFullPath(plant.getCover_media()));

            vo.setGenus(plant.getGenus());
            vo.setGmt_created(plant.getGmt_created());

            plantVOs.add(vo);
        }

        return plantVOs;
    }
}
