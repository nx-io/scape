package me.scape.ti.dao.impl;

import me.scape.ti.dao.LabelDAO;
import me.scape.ti.dataobject.LabelDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:27:13
 */
@Repository(value = "labelDAO")
public class DefaultLabelDAO extends DefaultGenericDAO<LabelDO, Long> implements LabelDAO {

}