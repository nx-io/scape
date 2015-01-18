package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.ro.RegisterRequest;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:29:28
 */
public interface AccountService {

	Result register(RegisterRequest request);

	Result login(String name, String password);

	Result reset_passwd(Long user_id, String old_passwd, String new_passwd);
	
	Result queryPubOrFavItem(Long user_id, Byte type);
}