package me.scape.ti.dao.impl;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.SystemSettingDAO;
import me.scape.ti.dataobject.SystemSettingDO;
import me.scape.ti.utils.SystemSettingGroup;
import me.scape.ti.utils.SystemSettingKey;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年2月3日 上午10:37:57
 */
@Repository("systemSettingDAO")
public class DefaultSystemSettingDAO extends EntityManagerSupportGenericDAO<SystemSettingDO, Long> implements SystemSettingDAO {

	@Override
	public SystemSettingDO getSystemSetting(SystemSettingGroup group, SystemSettingKey key) {
		return queryNativeForObject("SELECT * FROM system_setting WHERE group_id = ? AND setting_key = ?", new Object[] { group.groupId, key.key });
	}
}
