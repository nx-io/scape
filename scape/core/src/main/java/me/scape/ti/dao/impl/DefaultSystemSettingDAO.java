package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.SystemSettingDAO;
import me.scape.ti.dataobject.SystemSettingDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年2月3日 上午10:37:57
 */
@Repository(value = "systemSettingDAO")
public class DefaultSystemSettingDAO extends DefaultGenericDAO<SystemSettingDO, Long> implements SystemSettingDAO {
	
}
