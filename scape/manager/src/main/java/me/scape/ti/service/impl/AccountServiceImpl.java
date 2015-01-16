package me.scape.ti.service.impl;

import java.util.Date;

import me.scape.ti.dao.ManagerDAO;
import me.scape.ti.dataobject.ManagerDO;
import me.scape.ti.service.AccountService;
import me.scape.ti.utils.PasswdUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl extends BaseServiceImpl implements
		AccountService {

	@Autowired
	private ManagerDAO managerDAO;

	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public void changePwd(String password) {
		ManagerDO manager = managerDAO.get(getMerchantUserId());

		String salt = PasswdUtils.genSalt();
		String newPassword = PasswdUtils.encodePassword(password, salt);

		manager.setPassword(newPassword);
		manager.setSalt(salt);
		manager.setGmt_modified(new Date());
	}
}
