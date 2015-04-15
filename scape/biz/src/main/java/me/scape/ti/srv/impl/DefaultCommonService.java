package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.scape.ti.constant.CommonConstant;
import me.scape.ti.dataobject.CityDO;
import me.scape.ti.dataobject.ProvinceDO;
import me.scape.ti.dataobject.RegionDO;
import me.scape.ti.dataobject.SystemSettingDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.CommonService;
import me.scape.ti.utils.CDNUtil;
import me.scape.ti.utils.FileUtil;
import me.scape.ti.utils.SystemSettingGroup;
import me.scape.ti.utils.SystemSettingKey;
import me.scape.ti.vo.CityVO;
import me.scape.ti.vo.ProvinceVO;
import me.scape.ti.vo.RegionVO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月18日 下午12:32:39
 */
@Service(value = "commonService")
public class DefaultCommonService extends BaseService implements CommonService {

	@Override
	public Result upload(MultipartFile file) {
		String fileType = FileUtil.getFileType(file.getOriginalFilename());
		String fileName = new StringBuilder().append(UUID.randomUUID()).append(".").append(fileType).toString();
		String path = null;
		try {
			path = CDNUtil.uploadFile(file.getInputStream(), fileName);
		} catch (Exception e) {
			return Result.newError().with(ResultCode.Error_Exception);
		}
		return Result.newSuccess().with(ResultCode.Success).with(CommonConstant.IMAGE_PATH, path).with(CommonConstant.ORIGINAL_IMAGE_URL, CDNUtil.getFullPath(path));
	}

	@Override
	public Result getSystemSetting(SystemSettingGroup group, SystemSettingKey key) {
		SystemSettingDO setting = systemSettingDAO.getSystemSetting(group, key);
		if (setting != null) {
			return Result.newSuccess().with(ResultCode.Success).with("url", setting.getSettingValue()).with("version", setting.getExtend());
		}
		return Result.newSuccess().with(ResultCode.Error_Empty_Setting);
	}

	@Override
	public Result getProvinceList() {
		List<ProvinceDO> provinceList = provinceDAO.findAll();
		List<ProvinceVO> voList = new ArrayList<ProvinceVO>();
		if (provinceList != null && !provinceList.isEmpty()) {
			for (ProvinceDO province : provinceList) {
				voList.add(ProvinceVO.newInstance(province));
			}
		}
		return Result.newSuccess().with(ResultCode.Success).with("provinceList", voList);
	}

	@Override
	public Result getCityList(Integer provinceId) {
		ProvinceDO _do = provinceDAO.get(provinceId);
		ProvinceVO province = ProvinceVO.newInstance(_do);
		List<CityDO> cityList = cityDAO.query("FROM CityDO WHERE province_id = ?", new Object[] { provinceId });
		List<CityVO> voList = new ArrayList<CityVO>();
		if (cityList != null && !cityList.isEmpty()) {
			for (CityDO city : cityList) {
				CityVO vo = CityVO.newInstance(city);
				vo.setProvince(province);
				voList.add(vo);
			}
		}
		return Result.newSuccess().with(ResultCode.Success).with("cityList", voList);
	}

	@Override
	public Result getRegionList(Integer cityId) {
		CityDO _do = cityDAO.get(cityId);
		CityVO city = CityVO.newInstance(_do);
		List<RegionDO> regionList = regionDAO.query("FROM RegionDO WHERE city_id = ?", new Object[] { cityId });
		List<RegionVO> voList = new ArrayList<RegionVO>();
		if (regionList != null && !regionList.isEmpty()) {
			for (RegionDO region : regionList) {
				RegionVO vo = RegionVO.newInstance(region);
				vo.setCity(city);
				voList.add(vo);
			}
		}
		return Result.newSuccess().with(ResultCode.Success).with("regionList", voList);
	}
}