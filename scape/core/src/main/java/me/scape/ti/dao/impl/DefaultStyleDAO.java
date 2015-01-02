package me.scape.ti.dao.impl;

import me.scape.ti.dao.StyleDAO;
import me.scape.ti.dataobject.StyleDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:55:02
 */
@Repository(value = "styleDAO")
public class DefaultStyleDAO extends DefaultGenericDAO<StyleDO, Long> implements StyleDAO {
	
}