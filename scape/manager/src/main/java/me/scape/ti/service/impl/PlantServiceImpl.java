package me.scape.ti.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.PlantQueryCriteria;
import me.scape.ti.dao.PlantCategoryDAO;
import me.scape.ti.dao.PlantMediaDAO;
import me.scape.ti.dao.PlantsColorRelDAO;
import me.scape.ti.dao.PlantsDAO;
import me.scape.ti.dao.PlantsOrnamentalColorDAO;
import me.scape.ti.dao.PlantsOrnamentalPeriodDAO;
import me.scape.ti.dao.PlantsPeriodRelDAO;
import me.scape.ti.dataobject.PlantCategoryDO;
import me.scape.ti.dataobject.PlantMediaDO;
import me.scape.ti.dataobject.PlantsColorRelDO;
import me.scape.ti.dataobject.PlantsDO;
import me.scape.ti.dataobject.PlantsOrnamentalColorDO;
import me.scape.ti.dataobject.PlantsOrnamentalPeriodDO;
import me.scape.ti.dataobject.PlantsPeriodRelDO;
import me.scape.ti.service.PlantService;
import me.scape.ti.utils.CDNUtil;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.MediaVO;
import me.scape.ti.vo.PlantCategoryListVO;
import me.scape.ti.vo.PlantColorListVO;
import me.scape.ti.vo.PlantDetailVO;
import me.scape.ti.vo.PlantListVO;
import me.scape.ti.vo.PlantPeriodListVO;
import me.scape.ti.vo.request.PlantListRequest;
import me.scape.ti.vo.request.PlantRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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

    @Resource
    private PlantMediaDAO plantMediaDAO;

    @Resource
    private PlantsColorRelDAO plantsColorRelDAO;

    @Resource
    private PlantsPeriodRelDAO plantsPeriodRelDAO;

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

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public Integer createPlant(PlantRequest plantRequest) {
        Date now = new Date();

        PlantsDO plantsDO = new PlantsDO();
        plantsDO.setName_cn(plantRequest.getName_cn());
        plantsDO.setName_en(plantRequest.getName_en());
        plantsDO.setAlias_name(plantRequest.getAlias_name());
        plantsDO.setCat_id(plantRequest.getCat_id());
        plantsDO.setGenus(plantRequest.getGenus());
        plantsDO.setHabits(plantRequest.getHabits());
        plantsDO.setArea_applicable(plantRequest.getArea_applicable());
        plantsDO.setGarden_utilization(plantRequest.getGarden_utilization());

        plantsDO.setCover_media(plantRequest.getCover_media());

        plantsDO.setGmt_created(now);
        plantsDO.setGmt_modified(now);

        plantsDAO.persist(plantsDO);

        Integer plantId = plantsDO.getId();

        List<String> medias = plantRequest.getMedias();
        if (null != medias) {
            for (String media : medias) {
                if (StringUtils.isNotBlank(media)) {
                    PlantMediaDO plantMedia = new PlantMediaDO();
                    plantMedia.setPlant_id(plantId);
                    plantMedia.setUrl(media);
                    plantMedia.setStatus(PlantMediaDO.AVAILABLE);
                    plantMedia.setType(PlantMediaDO.IMG);
                    plantMedia.setGmt_created(now);
                    plantMedia.setGmt_modified(now);

                    plantMediaDAO.persist(plantMedia);
                }
            }
        }

        List<Integer> colorIds = plantRequest.getColors();
        if (null != colorIds) {
            for (Integer colorId : colorIds) {
                if (null != colorId && 0 != colorId) {
                    PlantsColorRelDO colorRel = new PlantsColorRelDO();
                    colorRel.setPlant_id(plantId);
                    colorRel.setColor_id(colorId);
                    colorRel.setGmt_created(now);
                    colorRel.setGmt_modified(now);

                    plantsColorRelDAO.persist(colorRel);
                }
            }
        }

        List<Integer> periodIds = plantRequest.getPeriods();
        if (null != periodIds) {
            for (Integer periodId : periodIds) {
                if (null != periodId && 0 != periodId) {
                    PlantsPeriodRelDO periodRel = new PlantsPeriodRelDO();
                    periodRel.setPlant_id(plantId);
                    periodRel.setPeriod_id(periodId);
                    periodRel.setGmt_created(now);
                    periodRel.setGmt_modified(now);

                    plantsPeriodRelDAO.persist(periodRel);
                }
            }
        }

        return plantId;
    }

    @Override
    public PlantDetailVO getPlantDetail(int plantId) {
        PlantDetailVO plantDetailVO = new PlantDetailVO();

        PlantsDO plant = plantsDAO.get(plantId);
        if (null == plant) {
            return plantDetailVO;
        }

        plantDetailVO.setId(plant.getId());
        plantDetailVO.setCat_id(plant.getCat_id());
        plantDetailVO.setName_cn(plant.getName_cn());
        plantDetailVO.setName_en(plant.getName_en());
        plantDetailVO.setAlias_name(plant.getAlias_name());
        plantDetailVO.setGenus(plant.getGenus());
        plantDetailVO.setHabits(plant.getHabits());
        plantDetailVO.setGarden_utilization(plant.getGarden_utilization());
        plantDetailVO.setArea_applicable(plant.getArea_applicable());
        plantDetailVO.setGmt_created(plant.getGmt_created());

        MediaVO coverMedia = new MediaVO();
        String coverMediaPath = plant.getCover_media();
        coverMedia.setPath(coverMediaPath);
        coverMedia.setUrl(CDNUtil.getFullPath(coverMediaPath));
        plantDetailVO.setCover_media(coverMedia);

        List<PlantMediaDO> plantMedias = plantMediaDAO.getMediasByPlantId(plantId);
        if (!CollectionUtils.isEmpty(plantMedias)) {
            List<MediaVO> medias = new ArrayList<MediaVO>();
            for (PlantMediaDO plantMedia : plantMedias) {
                MediaVO media = new MediaVO();
                String path = plantMedia.getUrl();
                media.setPath(path);
                media.setUrl(CDNUtil.getFullPath(path));

                medias.add(media);
            }

            plantDetailVO.setMedias(medias);
        }

        List<PlantsOrnamentalColorDO> plantColors = plantsOrnamentalColorDAO.getPlantColorsByPlantId(plantId);
        if (!CollectionUtils.isEmpty(plantColors)) {
            List<PlantColorListVO> colors = new ArrayList<PlantColorListVO>();
            for (PlantsOrnamentalColorDO plantColor : plantColors) {
                PlantColorListVO plantColorVO = new PlantColorListVO();
                plantColorVO.setId(plantColor.getId());
                plantColorVO.setColor(plantColor.getColor());
                plantColorVO.setIcon(CDNUtil.getFullPath(plantColor.getIcon()));

                colors.add(plantColorVO);
            }

            plantDetailVO.setColors(colors);
        }

        List<PlantsOrnamentalPeriodDO> plantPeriods = plantsOrnamentalPeriodDAO.getPlantPeriodsByPlantId(plantId);
        if (!CollectionUtils.isEmpty(plantPeriods)) {
            List<PlantPeriodListVO> periods = new ArrayList<PlantPeriodListVO>();
            for (PlantsOrnamentalPeriodDO plantPeriod : plantPeriods) {
                PlantPeriodListVO plantPeriodVO = new PlantPeriodListVO();
                plantPeriodVO.setId(plantPeriod.getId());
                plantPeriodVO.setPeriod(plantPeriod.getPeriod());

                periods.add(plantPeriodVO);
            }

            plantDetailVO.setPeriods(periods);
        }

        return plantDetailVO;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public void editPlant(int plantId, PlantRequest plantRequest) {
        PlantsDO plantsDO = plantsDAO.get(plantId);
        if (null == plantsDO) {
            return;
        }

        Date now = new Date();

        plantsDO.setName_cn(plantRequest.getName_cn());
        plantsDO.setName_en(plantRequest.getName_en());
        plantsDO.setAlias_name(plantRequest.getAlias_name());
        plantsDO.setCat_id(plantRequest.getCat_id());
        plantsDO.setGenus(plantRequest.getGenus());
        plantsDO.setHabits(plantRequest.getHabits());
        plantsDO.setArea_applicable(plantRequest.getArea_applicable());
        plantsDO.setGarden_utilization(plantRequest.getGarden_utilization());

        plantsDO.setCover_media(plantRequest.getCover_media());

        plantsDO.setGmt_modified(now);

        plantMediaDAO.deleteByPlantId(plantId);
        List<String> medias = plantRequest.getMedias();
        if (null != medias) {
            for (String media : medias) {
                if (StringUtils.isNotBlank(media)) {
                    PlantMediaDO plantMedia = new PlantMediaDO();
                    plantMedia.setPlant_id(plantId);
                    plantMedia.setUrl(media);
                    plantMedia.setStatus(PlantMediaDO.AVAILABLE);
                    plantMedia.setType(PlantMediaDO.IMG);
                    plantMedia.setGmt_created(now);
                    plantMedia.setGmt_modified(now);

                    plantMediaDAO.persist(plantMedia);
                }
            }
        }

        plantsColorRelDAO.deleteByPlantId(plantId);
        List<Integer> colorIds = plantRequest.getColors();
        if (null != colorIds) {
            for (Integer colorId : colorIds) {
                if (null != colorId && 0 != colorId) {
                    PlantsColorRelDO colorRel = new PlantsColorRelDO();
                    colorRel.setPlant_id(plantId);
                    colorRel.setColor_id(colorId);
                    colorRel.setGmt_created(now);
                    colorRel.setGmt_modified(now);

                    plantsColorRelDAO.persist(colorRel);
                }
            }
        }

        plantsPeriodRelDAO.deleteByPlantId(plantId);
        List<Integer> periodIds = plantRequest.getPeriods();
        if (null != periodIds) {
            for (Integer periodId : periodIds) {
                if (null != periodId && 0 != periodId) {
                    PlantsPeriodRelDO periodRel = new PlantsPeriodRelDO();
                    periodRel.setPlant_id(plantId);
                    periodRel.setPeriod_id(periodId);
                    periodRel.setGmt_created(now);
                    periodRel.setGmt_modified(now);

                    plantsPeriodRelDAO.persist(periodRel);
                }
            }
        }

    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Throwable.class)
    public void deletePlant(int plantId) {
        PlantsDO plantsDO = plantsDAO.get(plantId);
        if (null == plantsDO) {
            return;
        }

        plantsDAO.remove(plantsDO);

        plantMediaDAO.deleteByPlantId(plantId);

        plantsColorRelDAO.deleteByPlantId(plantId);

        plantsPeriodRelDAO.deleteByPlantId(plantId);
    }
}
