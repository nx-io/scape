package me.scape.ti.srv;

import me.scape.ti.result.Result;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月29日 下午11:21:40
 */
public interface CatService {
	Result getAllCat();
	Result getAllAreaCat();
	Result getAllStyle();
}