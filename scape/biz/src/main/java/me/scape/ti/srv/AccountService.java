package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.ro.PubfavRequest;
import me.scape.ti.ro.RegisterRequest;
import me.scape.ti.ro.ResetPasswdRequest;
import me.scape.ti.ro.UserProfileRequest;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:29:28
 */
public interface AccountService {

	Result register(RegisterRequest request);
	
	Result updateUserProfile(UserProfileRequest request);

	Result login(String name, String password);

	Result reset_passwd(ResetPasswdRequest request);

	Result queryPubOrFavItem(PubfavRequest request);
}