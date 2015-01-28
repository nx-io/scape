package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.PlantMediaDAO;
import me.scape.ti.dataobject.PlantMediaDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月28日 下午2:48:53
 */
@Repository(value = "plantMediaDAO")
public class DefaultPlantMediaDAO extends DefaultGenericDAO<PlantMediaDO, Long> implements PlantMediaDAO {

}
