package me.scape.ti.dao;

import java.util.List;

import me.scape.ti.dataobject.PlantMediaDO;
import me.scape.ti.jpa.GenericDAO;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月28日 下午2:48:23
 */
public interface PlantMediaDAO extends GenericDAO<PlantMediaDO, Long> {
    List<PlantMediaDO> getMediasByPlantId(Integer plantId);

    void deleteByPlantId(Integer plantId);
}