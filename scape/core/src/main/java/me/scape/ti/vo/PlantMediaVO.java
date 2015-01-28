package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.scape.ti.dataobject.PlantMediaDO;
import me.scape.ti.utils.ImageUtils;

import org.springframework.util.CollectionUtils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月28日 上午1:00:07
 */
public class PlantMediaVO {

	private Long plant_id;// 植物ID

	private String url;// 图片, 视频地址

	private Byte status;// 状态， 1:可用， -1:删除

	private Byte type;// 类型 1:图片, 2:视频

	private Long id;

	public static PlantMediaVO newInstance(PlantMediaDO _do) {
		if(_do == null) {
			return null;
		}
		return new PlantMediaVO().toMedia(_do);
	}
	
	public static List<PlantMediaVO> newInstance(List<PlantMediaDO> doList) {
		if(CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<PlantMediaVO> voList = new ArrayList<PlantMediaVO>();
		for (PlantMediaDO media : doList) {
			PlantMediaVO vo = newInstance(media);
			if(vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return voList;
	}
	
	private final PlantMediaVO toMedia(PlantMediaDO _do) {
		setId(_do.getId());
		setPlant_id(_do.getPlant_id());
		setStatus(_do.getStatus());
		setType(_do.getType());
		setUrl(ImageUtils.urlWrapper(_do.getUrl()));
		return this;
	}

	public Long getPlant_id() {
		return plant_id;
	}

	public void setPlant_id(Long plant_id) {
		this.plant_id = plant_id;
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