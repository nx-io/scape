package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.ro.TalentsSearchRequest;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月27日 下午3:09:43
 */
public interface TalentsService {
	
	Result search(TalentsSearchRequest request);
	
	Result queryTalents(String guid);
}