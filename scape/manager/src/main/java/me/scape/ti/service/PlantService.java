package me.scape.ti.service;

import java.util.List;

import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.PlantCategoryListVO;
import me.scape.ti.vo.PlantColorListVO;
import me.scape.ti.vo.PlantListVO;
import me.scape.ti.vo.PlantPeriodListVO;
import me.scape.ti.vo.request.PlantListRequest;

public interface PlantService {

    List<PlantCategoryListVO> listPlantCategories();

    List<PlantColorListVO> listPlantColors();

    List<PlantPeriodListVO> listPlantPeriods();

    CurrentPage<PlantListVO> ListPlants(PlantListRequest plantListRequest);

}
