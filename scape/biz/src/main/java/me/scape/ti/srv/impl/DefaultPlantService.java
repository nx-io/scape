package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.dataobject.PlantCategoryDO;
import me.scape.ti.dataobject.PlantsDO;
import me.scape.ti.dataobject.PlantsOrnamentalColorDO;
import me.scape.ti.dataobject.PlantsOrnamentalPeriodDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.PlantSearchRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.PageQuery;
import me.scape.ti.srv.PlantService;
import me.scape.ti.vo.PlantCategoryVO;
import me.scape.ti.vo.PlantMediaVO;
import me.scape.ti.vo.PlantsOrnamentalColorVO;
import me.scape.ti.vo.PlantsOrnamentalPeriodVO;
import me.scape.ti.vo.PlantsVO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月27日 下午11:48:53
 */
@Service(value = "plantService")
public class DefaultPlantService extends BaseService implements PlantService {
	
	private static final String QueryColorRelSQL = "SELECT * FROM plant_ornamental_color pc WHERE pc.id IN (SELECT pcr.color_id FROM plant_color_rel pcr WHERE pcr.plant_id = ?)";
	
	private static final String QueryPeriodRelSQL = "SELECT * FROM plant_ornamental_period pp WHERE pp.id IN (SELECT ppr.period_id FROM plant_period_rel ppr WHERE ppr.plant_id = ?)";
	
	@Override
	public Result getPeriods() {
		List<PlantsOrnamentalPeriodDO> plantsOrnamentalPeriodList = plantsOrnamentalPeriodDAO.getDisplayedPlantPeriods();
		return Result.newSuccess().with(ResultCode.Success).with("periodList", PlantsOrnamentalPeriodVO.newInstance(plantsOrnamentalPeriodList));
	}

	@Override
	public Result getColors() {
		List<PlantsOrnamentalColorDO> plantsOrnamentalColorList = plantsOrnamentalColorDAO.getDisplayedPlantColors();
		return Result.newSuccess().with(ResultCode.Success).with("colorList", PlantsOrnamentalColorVO.newInstance(plantsOrnamentalColorList));
	}

	@Override
	public Result getCats() {
		List<PlantCategoryDO> plantCatList = plantCategoryDAO.getDisplayedCategories();
		return Result.newSuccess().with(ResultCode.Success).with("plantCatList", PlantCategoryVO.newInstance(plantCatList));
	}

	@Override
	public Result detail(int plantId) {
		PlantsDO plant = plantsDAO.get(plantId);
		if(plant == null) {
			return Result.newError().with(ResultCode.Error_Plants_Empty);
		}
		PlantsVO vo = PlantsVO.newInstance(plant);
		if (vo == null) {
			return Result.newError().with(ResultCode.Error_Plants_Empty);
		}
		Object[] idArgs = new Object[] { plant.getId() };
		try {
			vo.setPlantCategory(PlantCategoryVO.newInstance(plantCategoryDAO.get(plant.getCat_id())));
		} catch (Exception e) {
			log.error("Query Plants Cat Error.", e);
		}
		try {
			vo.setPlantsMediaList(PlantMediaVO.newInstance(plantMediaDAO.queryNamed("PlantMedia.getPlantMediaByPlantId", idArgs)));
		} catch (Exception e) {
			log.error("Query Plants Media Error.", e);
		}
		try {
			vo.setColorList(PlantsOrnamentalColorVO.newInstance(plantsOrnamentalColorDAO.queryNative(QueryColorRelSQL, idArgs)));
		} catch (Exception e) {
			log.error("Query Plants Color Error.", e);
		}
		try {
			vo.setPeriodList(PlantsOrnamentalPeriodVO.newInstance(plantsOrnamentalPeriodDAO.queryNative(QueryPeriodRelSQL, idArgs)));
		} catch (Exception e) {
			log.error("Query Plants Period Error.", e);
		}
		return Result.newSuccess().with(ResultCode.Success).with("plant", vo);
	}

	@Override
	public Result search(PlantSearchRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM plants p WHERE 1 = 1 ");
		Map<String, Object> args = new HashMap<String, Object>();
		Long id = request.getId();
		if (id != null && id > 0L) {
			sb.append(" AND p.id = :id ");
			args.put("id", id);
		}
		Long catId = request.getCatId();
		if (catId != null && catId > 0L) {
			sb.append(" AND p.cat_id = :cat_id ");
			args.put("cat_id", catId);
		}
		String nameCn = request.getNameCn();
		if (StringUtils.isNotBlank(nameCn)) {
			sb.append(" AND p.name_cn LIKE :name_cn ");
			args.put("name_cn", "%" + nameCn + "%");
		}
		String genus = request.getGenus();
		if (StringUtils.isNotBlank(genus)) {
			sb.append(" AND p.genus LIKE :genus ");
			args.put("genus", "%" + genus + "%");
		}
		Long colorId = request.getColorId();
		if(colorId != null && colorId > 0L) {
			sb.append(" AND p.id in (SELECT pcr.plant_id FROM plant_color_rel pcr WHERE pcr.color_id = :color_id) ");
			args.put("color_id", colorId);
		}
		Long periodId = request.getPeriodId();
		if(periodId != null && periodId > 0L) {
			sb.append(" AND p.id in (SELECT ppr.plant_id FROM plant_period_rel ppr WHERE ppr.period_id = :period_id) ");
			args.put("period_id", periodId);
		}
		String sort = request.getSort();
		if (StringUtils.isNotBlank(sort)) {
			sb.append(" ORDER BY p.gmt_created DESC ");
		}
		sb.append(" LIMIT :start, :size ");
		Integer page = request.getPage();
		page = (page != null && page > 0) ? page : 1;
		PageQuery pageQuery = new PageQuery(page);
		args.put("start", pageQuery.getIndex());
		args.put("size", pageQuery.getSize());
		List<PlantsDO> plantsList = plantsDAO.queryNative(sb.toString(), args);
		if (CollectionUtils.isEmpty(plantsList)) {
			return Result.newError().with(ResultCode.Error_Plants_Empty);
		}
		List<PlantsVO> voList = new ArrayList<PlantsVO>();
		for (PlantsDO plants : plantsList) {
			PlantsVO vo = PlantsVO.newInstance(plants);
			if (vo == null) {
				continue;
			}
			Object[] idArgs = new Object[] { plants.getId() };
			try {
				vo.setPlantCategory(PlantCategoryVO.newInstance(plantCategoryDAO.get(plants.getCat_id())));
			} catch (Exception e) {
				log.error("Query Plants Cat Error.", e);
			}
			try {
				vo.setPlantsMediaList(PlantMediaVO.newInstance(plantMediaDAO.queryNamed("PlantMedia.getPlantMediaByPlantId", idArgs)));
			} catch (Exception e) {
				log.error("Query Plants Media Error.", e);
			}
			try {
				vo.setColorList(PlantsOrnamentalColorVO.newInstance(plantsOrnamentalColorDAO.queryNative(QueryColorRelSQL, idArgs)));
			} catch (Exception e) {
				log.error("Query Plants Color Error.", e);
			}
			try {
				vo.setPeriodList(PlantsOrnamentalPeriodVO.newInstance(plantsOrnamentalPeriodDAO.queryNative(QueryPeriodRelSQL, idArgs)));
			} catch (Exception e) {
				log.error("Query Plants Period Error.", e);
			}
			voList.add(vo);
		}
		return Result.newSuccess().with(ResultCode.Success).with("plantsList", voList);
	}
}