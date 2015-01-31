package me.scape.ti.controller;

import me.scape.ti.service.impl.PlantServiceImpl;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.PlantListVO;
import me.scape.ti.vo.request.PlantListRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlantController extends BaseController {

    @Autowired
    private PlantServiceImpl plantServiceImpl;

    @RequestMapping("/plant/list")
    public String listPlant(@ModelAttribute PlantListRequest plantListRequest, Model model) {
        CurrentPage<PlantListVO> result = plantServiceImpl.ListPlants(plantListRequest);
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
}
