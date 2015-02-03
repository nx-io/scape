package me.scape.ti.srv.impl;

import java.util.UUID;

import me.scape.ti.constant.CommonConstant;
import me.scape.ti.dataobject.SystemSettingDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.CommonService;
import me.scape.ti.utils.CDNUtil;
import me.scape.ti.utils.FileUtil;

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
        return Result.newSuccess().with(ResultCode.Success).with(CommonConstant.IMAGE_PATH, path)
        		.with(CommonConstant.ORIGINAL_IMAGE_URL, CDNUtil.getFullPath(path));
	}

	@Override
	public Result getVersion(String key) {
		Object[] args = new Object[]{ key };
		SystemSettingDO setting = systemSettingDAO.queryNativeForObject("SELECT * FROM system_setting WHERE group_id = 1 AND setting_key = ?", args);
		if(setting != null) {
			return Result.newSuccess().with(ResultCode.Success).with(setting.getExtend(), setting.getSettingValue());
		}
		return Result.newSuccess().with(ResultCode.Error_Empty_Setting);
	}
}