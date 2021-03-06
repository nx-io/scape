package me.scape.ti.dao;

import me.ocs.commons.jpa.GenericDAO;
import me.scape.ti.dataobject.SystemSettingDO;
import me.scape.ti.utils.SystemSettingGroup;
import me.scape.ti.utils.SystemSettingKey;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年2月3日 上午10:37:04
 */
public interface SystemSettingDAO extends GenericDAO<SystemSettingDO, Long> {

	SystemSettingDO getSystemSetting(SystemSettingGroup group, SystemSettingKey key);
}