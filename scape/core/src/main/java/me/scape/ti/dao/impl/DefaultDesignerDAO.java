package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.DesignerDAO;
import me.scape.ti.dataobject.DesignerDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:25:31
 */
@Repository(value = "designerDAO")
public class DefaultDesignerDAO extends DefaultGenericDAO<DesignerDO, Long> implements DesignerDAO {
	
}