package me.scape.ti.srv.impl;

import org.springframework.stereotype.Service;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.CatService;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月29日 下午11:23:48
 */
@Service("catService")
public class DefaultCatService extends BaseService implements CatService {

	@Override
	public Result getAllCat() {
		return Result.newSuccess().with(ResultCode.Success).with("cats", categoryDAO.findAll());
	}

	@Override
	public Result getAllAreaCat() {
		return Result.newSuccess().with(ResultCode.Success).with("cats", areaCategoryDAO.findAll());
	}

	@Override
	public Result getAllStyle() {
		return Result.newSuccess().with(ResultCode.Success).with("styles", styleDAO.findAll());
	}
}
