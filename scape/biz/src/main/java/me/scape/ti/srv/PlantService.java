package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.ro.PlantSearchRequest;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午8:40:22
 */
public interface PlantService {

	Result search(PlantSearchRequest request);
	
	Result getCats();
	
	Result getColors();
	
	Result getPeriods();
}