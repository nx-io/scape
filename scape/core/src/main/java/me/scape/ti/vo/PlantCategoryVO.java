package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.PlantCategoryDO;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午6:37:34
 */
public class PlantCategoryVO {

	private Integer id;

	private String name;// 植物类别名称

	private String description;// 植物类别描述

	private String icon;// 植物类别图标

	private Byte display = 1;// 是否展示 1展示 0不展示 -1删除

	private Date gmt_created;

	public static List<PlantCategoryVO> newInstance(List<PlantCategoryDO> doList) {
		if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<PlantCategoryVO> voList = new ArrayList<PlantCategoryVO>();
		for (PlantCategoryDO _do : doList) {
			PlantCategoryVO vo = PlantCategoryVO.newInstance(_do);
			if (vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return voList;
	}

	public static PlantCategoryVO newInstance(PlantCategoryDO _do) {
		if (_do == null) {
			return null;
		}
		return new PlantCategoryVO().toPlantCategory(_do);
	}

	private final PlantCategoryVO toPlantCategory(PlantCategoryDO _do) {
		setDescription(_do.getDescription());
		setDisplay(_do.getDisplay());
		setGmt_created(_do.getGmt_created());
		setIcon(_do.getIcon());
		setId(_do.getId());
		setName(_do.getName());
		return this;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Byte getDisplay() {
		return display;
	}

	public void setDisplay(Byte display) {
		this.display = display;
	}

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}
}