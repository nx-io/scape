package me.scape.ti.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.UserQueryCriteria;
import me.scape.ti.dao.CategoryDAO;
import me.scape.ti.dao.UserDAO;
import me.scape.ti.dataobject.CategoryDO;
import me.scape.ti.dataobject.UserDO;
import me.scape.ti.service.UserService;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.UserListVO;
import me.scape.ti.vo.request.UserListRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public CurrentPage<UserListVO> ListUsers(UserListRequest userListRequest) {
        UserQueryCriteria criteria = new UserQueryCriteria();

        criteria.setStatus(userListRequest.getStatus());
        criteria.setName(userListRequest.getName());

        int curn = userListRequest.getCurn() > 0 ? userListRequest.getCurn() : 1;
        int pageSize = userListRequest.getPs();
        criteria.setOffset((curn - 1) * pageSize);
        criteria.setLimit(pageSize);

        Pagination<UserDO> users = userDAO.ListUsers(criteria);

        List<UserListVO> userVOs = formatUsers(users.getItems());

        return new CurrentPage(curn, users.getCount(), pageSize, userVOs);
    }

    private List<UserListVO> formatUsers(List<UserDO> users) {
        List<UserListVO> userVOs = new ArrayList<UserListVO>();
        if (null == users || users.isEmpty()) {
            return userVOs;
        }

        List<CategoryDO> categories = categoryDAO.findAll();
        Map<Long, String> categoryMap = new HashMap<Long, String>();
        for (CategoryDO categoryDO : categories) {
            categoryMap.put(categoryDO.getId(), categoryDO.getName());
        }

        for (UserDO user : users) {
            long userId = user.getId();

            UserListVO vo = new UserListVO();
            vo.setId(userId);
            vo.setName(user.getName());
            vo.setFullname(user.getFullname());
            vo.setEmail(user.getEmail());
            vo.setMobile(user.getMobile());
            vo.setStatus(user.getStatus());
            vo.setSpeciality(null != user.getCategory_id() ? categoryMap.get(user.getCategory_id()) : null);

            userVOs.add(vo);
        }

        return userVOs;
    }
}
