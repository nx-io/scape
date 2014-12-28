package me.scape.ti.controller;

import me.scape.ti.service.UserService;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.UserListVO;
import me.scape.ti.vo.request.UserListRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/list")
    public String listUser(@ModelAttribute UserListRequest userListRequest, Model model) {
        CurrentPage<UserListVO> result = userService.ListUsers(userListRequest);
        model.addAttribute("curn", result.getCurn());
        model.addAttribute("totaln", result.getTotaln());
        model.addAttribute("users", result.getItems());
        model.addAttribute("ps", userListRequest.getPs());

        model.addAttribute("request", userListRequest);

        StringBuilder condition = new StringBuilder();
        if (null != userListRequest.getStatus()) {
            condition.append("&status=").append(userListRequest.getStatus());
        }
        if (StringUtils.isNotEmpty(userListRequest.getName())) {
            condition.append("&name=").append(userListRequest.getName());
        }

        model.addAttribute("condition", condition.toString());

        return "user/list";
    }
}
