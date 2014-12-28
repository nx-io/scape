package me.scape.ti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController extends BaseController {

    @RequestMapping("/no_permission")
    public String noPermission() {

        return "no_permission";
    }

    @RequestMapping("/loginPage")
    public String loginView() {
        if (getMerchantUserId() > 0) {
            return "redirect:/homePage";
        }

        return "index";
    }

    @RequestMapping(value = "/loginHandle")
    public String loginHandle() {
        return "redirect:/loginPage";
    }

    @RequestMapping(value = "/timeout")
    public String timeout() {
        return "redirect:/loginPage";
    }

    @RequestMapping(value = "/homePage")
    public String home() {
        return "home";
    }
}
