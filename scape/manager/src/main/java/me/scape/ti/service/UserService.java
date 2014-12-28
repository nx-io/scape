package me.scape.ti.service;

import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.UserListVO;
import me.scape.ti.vo.request.UserListRequest;

public interface UserService {
    CurrentPage<UserListVO> ListUsers(UserListRequest userListRequest);
}
