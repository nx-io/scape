package me.scape.ti.dao;

import me.scape.ti.dataobject.ManagerDO;
import me.scape.ti.jpa.GenericDAO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:48:48
 */
public interface ManagerDAO extends GenericDAO<ManagerDO, Integer> {

    ManagerDO getByEmail(String email);
}