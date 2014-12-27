package me.scape.ti.srv;

import me.scape.ti.result.Result;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:29:28
 */
public interface AccountService {

	Result register(String name, String password, String mobile, String avatar);

}