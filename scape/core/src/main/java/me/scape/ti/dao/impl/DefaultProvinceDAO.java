package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.ProvinceDAO;
import me.scape.ti.dataobject.ProvinceDO;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年4月12日 下午11:07:47
 */
@Repository("provinceDAO")
public class DefaultProvinceDAO extends DefaultGenericDAO<ProvinceDO, Integer> implements ProvinceDAO {

}