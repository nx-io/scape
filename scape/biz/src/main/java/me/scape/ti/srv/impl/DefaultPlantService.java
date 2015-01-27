package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.dataobject.PlantsDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.PlantSearchRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.PageQuery;
import me.scape.ti.srv.PlantService;
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

	@Override
	public Result search(PlantSearchRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM plants p WHERE 1 = 1 ");
		Map<String, Object> args = new HashMap<String, Object>();
		Long id = request.getId();
		if(id != null && id > 0L) {
			sb.append(" AND p.id = :id ");
			args.put("id", id);
		}
		Long catId = request.getCatId();
		if(catId != null && catId > 0L) {
			sb.append(" AND p.cat_id = :cat_id ");
			args.put("cat_id", catId);
		}
		String nameCn = request.getNameCn();
		if(StringUtils.isNotBlank(nameCn)) {
			sb.append(" AND p.name_cn LIKE :name_cn ");
			args.put("name_cn", "%" + nameCn + "%");
		}
		String genus = request.getGenus();
		if(StringUtils.isNotBlank(genus)) {
			sb.append(" AND p.genus LIKE :genus ");
			args.put("genus", "%" + genus + "%");
		}
		String sort = request.getSort();
		if(StringUtils.isNotBlank(sort)) {
			sb.append(" ORDER BY p.gmt_created DESC ");
		}
		sb.append(" LIMIT :start, :size ");
		Integer page = request.getPage();
		page = (page != null && page > 0) ? page : 1;
		PageQuery pageQuery = new PageQuery(page);
		args.put("start", pageQuery.getIndex());
		args.put("size", pageQuery.getSize());
		
		List<PlantsDO> plantsList = plantsDAO.queryNative(sb.toString(), args);
		if(CollectionUtils.isEmpty(plantsList)) {
			return Result.newError().with(ResultCode.Error_Plants_Empty);
		}
		List<PlantsVO> voList = new ArrayList<PlantsVO>();
		for (PlantsDO plants : plantsList) {
			PlantsVO vo = PlantsVO.newInstance(plants);
			if(vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return Result.newSuccess().with(ResultCode.Success).with("plantsList", voList);
	}
}