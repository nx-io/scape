package me.scape.ti.service;

import java.util.List;

import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.PlantCategoryListVO;
import me.scape.ti.vo.PlantColorListVO;
import me.scape.ti.vo.PlantDetailVO;
import me.scape.ti.vo.PlantListVO;
import me.scape.ti.vo.PlantPeriodListVO;
import me.scape.ti.vo.request.PlantListRequest;
import me.scape.ti.vo.request.PlantRequest;

public interface PlantService {

    List<PlantCategoryListVO> listPlantCategories();

    List<PlantColorListVO> listPlantColors();

    List<PlantPeriodListVO> listPlantPeriods();

    CurrentPage<PlantListVO> ListPlants(PlantListRequest plantListRequest);

    Integer createPlant(PlantRequest plantRequest);

    PlantDetailVO getPlantDetail(int plantId);

    void editPlant(int plantId, PlantRequest plantRequest);

    void deletePlant(int plantId);

}
