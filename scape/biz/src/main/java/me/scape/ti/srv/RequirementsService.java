package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.ro.PublishRequirementsRequest;
import me.scape.ti.ro.RequirementsSearchRequest;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月13日 上午11:33:20
 */
public interface RequirementsService {

	Result publishRequirements(PublishRequirementsRequest request);
	
	Result search(RequirementsSearchRequest request);
	
	Result getRequirements(Long reqId);
	
	Result getProvinceList();
	
	Result getCityList(Integer provinceId);
	
	Result getRegionList(Integer cityId);
	
	Result getTopCategoryList();
	
	Result getSecondCategoryList(Integer topCatId);
}