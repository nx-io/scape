package me.scape.ti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.constant.ResponseStatus;
import me.scape.ti.service.PlantService;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.PlantCategoryListVO;
import me.scape.ti.vo.PlantColorListVO;
import me.scape.ti.vo.PlantDetailVO;
import me.scape.ti.vo.PlantListVO;
import me.scape.ti.vo.PlantPeriodListVO;
import me.scape.ti.vo.request.PlantListRequest;
import me.scape.ti.vo.request.PlantRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlantController extends BaseController {

    @Autowired
    private PlantService plantService;

    @RequestMapping("/plant/list")
    public String listPlant(@ModelAttribute PlantListRequest plantListRequest, Model model) {
        CurrentPage<PlantListVO> result = plantService.ListPlants(plantListRequest);
        model.addAttribute("curn", result.getCurn());
        model.addAttribute("totaln", result.getTotaln());
        model.addAttribute("plants", result.getItems());
        model.addAttribute("ps", plantListRequest.getPs());

        model.addAttribute("request", plantListRequest);

        StringBuilder condition = new StringBuilder();
        if (StringUtils.isNotEmpty(plantListRequest.getName())) {
            condition.append("&name=").append(plantListRequest.getName());
        }
        if (null != plantListRequest.getCat_id()) {
            condition.append("&cat_id = ?").append(plantListRequest.getCat_id());
        }

        model.addAttribute("condition", condition.toString());

        return "plant/list";
    }

    @RequestMapping("/plant/addPage")
    public String getAddPlantPage(Model model) {
        model.addAttribute("plant", new PlantDetailVO());

        List<PlantCategoryListVO> plantCategories = plantService.listPlantCategories();
        List<PlantColorListVO> plantColors = plantService.listPlantColors();
        List<PlantPeriodListVO> plantPeriods = plantService.listPlantPeriods();
        model.addAttribute("plantCategories", plantCategories);
        model.addAttribute("plantColors", plantColors);
        model.addAttribute("plantPeriods", plantPeriods);

        return "plant/form";
    }

    @RequestMapping(value = "/plant/add", method = RequestMethod.POST)
    public String addPlant(@ModelAttribute PlantRequest plantRequest, Model model) {
        int plantId = plantService.createPlant(plantRequest);

        // return "redirect:/plant/detail?id=" + plantId;
        return "redirect:/plant/list";
    }

    @RequestMapping("/plant/editPage")
    public String getEditPlantPage(int id, Model model) {

        model.addAttribute("plant", plantService.getPlantDetail(id));

        List<PlantCategoryListVO> plantCategories = plantService.listPlantCategories();
        List<PlantColorListVO> plantColors = plantService.listPlantColors();
        List<PlantPeriodListVO> plantPeriods = plantService.listPlantPeriods();
        model.addAttribute("plantCategories", plantCategories);
        model.addAttribute("plantColors", plantColors);
        model.addAttribute("plantPeriods", plantPeriods);

        return "plant/form";
    }

    @RequestMapping(value = "/plant/edit", method = RequestMethod.POST)
    public String editPlant(int id, @ModelAttribute PlantRequest plantRequest) {
        plantService.editPlant(id, plantRequest);

        // return "redirect:/plant/detail?id=" + id;
        return "redirect:/plant/list";
    }

    @RequestMapping("/plant/delete")
    @ResponseBody
    public Map<String, Object> deletePlant(int id) {
        plantService.deletePlant(id);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", ResponseStatus.SUCCEED.getValue());

        return map;
    }
}
