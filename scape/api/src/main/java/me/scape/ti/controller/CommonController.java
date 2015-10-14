package me.scape.ti.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import me.scape.ti.result.Result;
import me.scape.ti.utils.SystemSettingGroup;
import me.scape.ti.utils.SystemSettingKey;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月18日 下午12:39:22
 */
@Controller("commonController")
public class CommonController extends BaseController {

	@RequestMapping(value = "/file/upload", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> upload(@RequestParam(value = "file", required = true) MultipartFile file) {
		Result result = commonService.upload(file);
		return toResponse(result);
	}

	@RequestMapping(value = "/version/android", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> version_android() {
		Result result = commonService.getSystemSetting(SystemSettingGroup.APP_VERSION, SystemSettingKey.APP_VERSION_ANDROID);
		return toResponse(result);
	}

	@RequestMapping(value = "/version/ios", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> version_ios() {
		Result result = commonService.getSystemSetting(SystemSettingGroup.APP_VERSION, SystemSettingKey.APP_VERSION_IOS);
		return toResponse(result);
	}

	@RequestMapping(value = "/commons/provinces", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> provinceList() {
		Result result = commonService.getProvinceList();
		return toResponse(result);
	}

	@RequestMapping(value = "/commons/city/{provinceId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> cityList(@PathVariable Integer provinceId) {
		Result result = commonService.getCityList(provinceId);
		return toResponse(result);
	}

	@RequestMapping(value = "/commons/region/{cityId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> regionList(@PathVariable Integer cityId) {
		Result result = commonService.getRegionList(cityId);
		return toResponse(result);
	}
}
