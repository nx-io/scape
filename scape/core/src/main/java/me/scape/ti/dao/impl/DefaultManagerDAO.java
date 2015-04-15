package me.scape.ti.dao.impl;

import me.scape.ti.dao.ManagerDAO;
import me.scape.ti.dataobject.ManagerDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:49:36
 */
@Repository("managerDAO")
public class DefaultManagerDAO extends DefaultGenericDAO<ManagerDO, Integer> implements ManagerDAO {

	@Override
	public ManagerDO getByEmail(String email) {
		return queryNamedForObject("ManagerDO.getByEmail", new Object[] { email });
	}

}