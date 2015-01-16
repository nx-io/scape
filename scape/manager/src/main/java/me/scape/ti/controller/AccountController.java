package me.scape.ti.controller;

import javax.annotation.Resource;

import me.scape.ti.security.model.UserDetailsImpl;
import me.scape.ti.security.utils.ContextUtil;
import me.scape.ti.service.AccountService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController extends BaseController {

	@Resource
	private AccountService accountService;

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

	@RequestMapping(value = "/account/info")
	public String getAccountInfo(Model model) {
		UserDetailsImpl account = ContextUtil.getUserDetail();
		model.addAttribute("account", account);

		return "account/info";
	}

	@RequestMapping(value = "/password/change")
	public String changePassword(String passwrd, Model model) {
		accountService.changePwd(passwrd);
		model.addAttribute("success", true);

		UserDetailsImpl account = ContextUtil.getUserDetail();
		model.addAttribute("account", account);
		return "account/info";
	}
}
