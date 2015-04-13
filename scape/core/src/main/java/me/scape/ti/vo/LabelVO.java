package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;

import me.scape.ti.dataobject.LabelDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月31日 上午12:06:21
 */
public class LabelVO {
	private Long id;

	private String name;// 标签名称

	private String description;// 标签描述

	private String icon;// 标签图标

	private Date gmt_created;

	public static LabelVO newInstance(LabelDO _do) {
		if (_do == null) {
			return null;
		}
		LabelVO vo = new LabelVO();
		vo.setDescription(_do.getDescription());
		vo.setGmt_created(_do.getGmt_created());
		vo.setIcon(_do.getIcon());
		vo.setId(_do.getId());
		vo.setName(_do.getName());
		return vo;
	}

	public static List<LabelVO> newInstance(List<LabelDO> doList) {
		if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<LabelVO> voList = new ArrayList<LabelVO>();
		for (LabelDO label : doList) {
			LabelVO vo = newInstance(label);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return voList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}
}