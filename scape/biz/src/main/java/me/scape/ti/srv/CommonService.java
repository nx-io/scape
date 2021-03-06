package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.utils.SystemSettingGroup;
import me.scape.ti.utils.SystemSettingKey;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月18日 下午12:21:54
 */
public interface CommonService {

	Result upload(MultipartFile file);

	Result getSystemSetting(SystemSettingGroup group, SystemSettingKey key);
	
	Result getProvinceList();
	
	Result getCityList(Integer provinceId);
	
	Result getRegionList(Integer cityId);
}