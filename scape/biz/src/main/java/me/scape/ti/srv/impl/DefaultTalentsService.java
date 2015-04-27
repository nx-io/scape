package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import me.scape.ti.dataobject.ItemDO;
import me.scape.ti.dataobject.UserDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.TalentsSearchRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.PageQuery;
import me.scape.ti.srv.TalentsService;
import me.scape.ti.vo.TalentsVO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月27日 下午3:10:13
 */
@Service("talentsService")
public class DefaultTalentsService extends BaseService implements TalentsService {

	@Override
	public Result queryTalents(String guid) {
		UserDO user = userDAO.queryForObject("FROM UserDO WHERE guid = ?", new Object[] { guid });
		if(user == null) {
			return Result.newError().with(ResultCode.Error_User_Not_Exist);
		}
		TalentsVO talents = TalentsVO.newInstance(user);
		
		List<ItemDO> publishedItems = itemDAO.getUserItems(user.getId(), ItemDO.published);
		List<ItemDO> sharedItems = itemDAO.getUserItems(user.getId(), ItemDO.shared);
		return Result.newSuccess().with(ResultCode.Success).with("talents", talents);
	}

	@Override
	public Result search(TalentsSearchRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM user i WHERE 1 = 1 ");
		Map<String, Object> args = new HashMap<String, Object>();
		Long category_id = request.getCategory_id();
		if (category_id != null && category_id > 0L) {
			sb.append(" AND i.category_id = :category_id ");
			args.put("category_id", category_id);
		}
		Integer province_id = request.getProvince_id();
		if (province_id != null && province_id > 0L) {
			sb.append(" AND i.province_id = :province_id ");
			args.put("province_id", province_id);
		}
		Integer city_id = request.getCity_id();
		if (city_id != null && city_id > 0L) {
			sb.append(" AND i.city_id = :city_id ");
			args.put("city_id", city_id);
		}
		// 搜索类型 1:最近更新 2:最多案例 3:最多关注
		Byte type = request.getType();
		if (type != null && type > 0) {
			if (type == 1) {
				sb.append(" ORDER BY i.gmt_modified DESC, i.gmt_created DESC ");
			} else if (type == 2) {
				sb.append(" ORDER BY i.item_count DESC, i.gmt_created DESC ");
			} else if (type == 3) {
				sb.append(" ORDER BY i.attention_count DESC, i.gmt_created DESC ");
			} else {
				sb.append(" ORDER BY i.gmt_created DESC ");
			}
		}
		sb.append(" LIMIT :start, :size ");
		Integer page = request.getPage();
		page = (page != null && page > 0) ? page : 1;
		PageQuery pageQuery = new PageQuery(page);
		args.put("start", pageQuery.getIndex());
		args.put("size", pageQuery.getSize());
		List<UserDO> userList = userDAO.queryNative(sb.toString(), args);
		if (CollectionUtils.isEmpty(userList)) {
			return Result.newError().with(ResultCode.Error_Talents_Empty);
		}
		List<TalentsVO> voList = new ArrayList<TalentsVO>();
		for (UserDO user : userList) {
			TalentsVO vo = TalentsVO.newInstance(user);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return Result.newSuccess().with(ResultCode.Success).with("talents", voList);
	}
}