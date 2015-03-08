package me.scape.ti.auth;

import me.scape.ti.auth.request.CheckRequest;
import me.scape.ti.auth.request.LoginRequest;
import me.scape.ti.auth.response.CheckResponse;
import me.scape.ti.auth.response.LoginResponse;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年3月8日 下午6:38:51
 */
public interface AuthorizationService {

	String App_Id = "S0wLiaXE6fXUflFy8O9urhW7imsi";

	LoginResponse login(LoginRequest request);
	
	CheckResponse check(CheckRequest request);
}