package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.PlantsDO;

import org.apache.commons.collections.CollectionUtils;

/**
 * 植物.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午6:19:22
 */
public class PlantsVO {
	
	private Long id;

	private Long catId;

	private String nameCn;// 中文名

	private String shortNameCn;// 中文名简称

	private String nameEn;// 英文名

	private String shortNameEn;// 英文名简称

	private String aliasName;// 别名

	private String genus;// 科属
	
	private String cover_media;// 植物封皮

	private String habits;// 习性

	private String gardenUtilization;// 园林用途

	private String areaApplicable;// 适用地区
	
	private Date gmt_created;
	
	private Date gmt_modified;
	
	private PlantCategoryVO plantCategory;
	
	private List<PlantMediaVO> plantsMediaList;
	
	private List<PlantsOrnamentalColorVO> colorList;
	
	private List<PlantsOrnamentalPeriodVO> periodList;
	
	public static List<PlantsVO> newInstance(List<PlantsDO> doList) {
		if(CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<PlantsVO> voList = new ArrayList<PlantsVO>();
		for (PlantsDO _do : doList) {
			PlantsVO vo = PlantsVO.newInstance(_do);
			if(vo == null) {
				continue;
			}
			voList.add(vo);
		}
		return voList;
	}
	
	public static PlantsVO newInstance(PlantsDO _do) {
		if(_do == null) {
			return null;
		}
		return new PlantsVO().toPlants(_do);
	}
	
	private final PlantsVO toPlants(PlantsDO _do) {
		setAliasName(_do.getAliasName());
		setAreaApplicable(_do.getAreaApplicable());
		setCatId(_do.getCatId());
		setGardenUtilization(_do.getGardenUtilization());
		setGenus(_do.getGenus());
		setGmt_created(_do.getGmt_created());
		setGmt_modified(_do.getGmt_modified());
		setHabits(_do.getHabits());
		setId(_do.getId());
		setNameCn(_do.getNameCn());
		setNameEn(_do.getNameEn());
		setCover_media(_do.getCover_media());
		setShortNameCn(_do.getShortNameCn());
		setShortNameEn(_do.getShortNameEn());
		return this;
	}

	public String getCover_media() {
		return cover_media;
	}

	public void setCover_media(String cover_media) {
		this.cover_media = cover_media;
	}

	public List<PlantsOrnamentalPeriodVO> getPeriodList() {
		return periodList;
	}

	public void setPeriodList(List<PlantsOrnamentalPeriodVO> periodList) {
		this.periodList = periodList;
	}

	public List<PlantsOrnamentalColorVO> getColorList() {
		return colorList;
	}

	public void setColorList(List<PlantsOrnamentalColorVO> colorList) {
		this.colorList = colorList;
	}

	public List<PlantMediaVO> getPlantsMediaList() {
		return plantsMediaList;
	}

	public void setPlantsMediaList(List<PlantMediaVO> plantsMediaList) {
		this.plantsMediaList = plantsMediaList;
	}

	public PlantCategoryVO getPlantCategory() {
		return plantCategory;
	}

	public void setPlantCategory(PlantCategoryVO plantCategory) {
		this.plantCategory = plantCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getShortNameCn() {
		return shortNameCn;
	}

	public void setShortNameCn(String shortNameCn) {
		this.shortNameCn = shortNameCn;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getShortNameEn() {
		return shortNameEn;
	}

	public void setShortNameEn(String shortNameEn) {
		this.shortNameEn = shortNameEn;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getHabits() {
		return habits;
	}

	public void setHabits(String habits) {
		this.habits = habits;
	}

	public String getGardenUtilization() {
		return gardenUtilization;
	}

	public void setGardenUtilization(String gardenUtilization) {
		this.gardenUtilization = gardenUtilization;
	}

	public String getAreaApplicable() {
		return areaApplicable;
	}

	public void setAreaApplicable(String areaApplicable) {
		this.areaApplicable = areaApplicable;
	}

	public Date getGmt_created() {
		return gmt_created;
	}

	public void setGmt_created(Date gmt_created) {
		this.gmt_created = gmt_created;
	}

	public Date getGmt_modified() {
		return gmt_modified;
	}

	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
}