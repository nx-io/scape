package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.scape.ti.dataobject.ItemMediaDO;

import org.springframework.util.CollectionUtils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月28日 上午1:00:07
 */
public class ItemMediaVO {

	private Long item_id;// 案例ID

	private String url;// 图片, 视频地址

	private Byte status;// 状态， 1:可用， -1:删除

	private Byte type;// 类型 1:图片, 2:视频

	private Long id;

	public static ItemMediaVO newInstance(ItemMediaDO _do) {
		return new ItemMediaVO().toItemMedia(_do);
	}
	
	public static List<ItemMediaVO> newInstance(List<ItemMediaDO> doList) {
		if(CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<ItemMediaVO> voList = new ArrayList<ItemMediaVO>();
		for (ItemMediaDO itemMediaDO : doList) {
			voList.add(newInstance(itemMediaDO));
		}
		return voList;
	}
	
	public ItemMediaVO toItemMedia(ItemMediaDO _do) {
		if(_do == null) {
			return this;
		}
		setId(_do.getId());
		setItem_id(_do.getItem_id());
		setStatus(_do.getStatus());
		setType(_do.getType());
		setUrl(_do.getUrl());
		return this;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}