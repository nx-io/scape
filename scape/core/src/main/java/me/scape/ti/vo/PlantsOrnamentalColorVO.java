package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.PlantsOrnamentalColorDO;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午6:49:09
 */
public class PlantsOrnamentalColorVO {

    private Integer id;

    private String color;// 植物观赏色

    private String icon;// 植物观赏色图标

    private Byte display = 1;// 是否展示 1展示 0不展示 -1删除

    private Date gmt_created;

    public static List<PlantsOrnamentalColorVO> newInstance(List<PlantsOrnamentalColorDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
            return Collections.emptyList();
        }
        List<PlantsOrnamentalColorVO> voList = new ArrayList<PlantsOrnamentalColorVO>();
        for (PlantsOrnamentalColorDO _do : doList) {
            PlantsOrnamentalColorVO vo = PlantsOrnamentalColorVO.newInstance(_do);
            if (vo == null) {
                continue;
            }
            voList.add(vo);
        }
        return voList;
    }

    public static PlantsOrnamentalColorVO newInstance(PlantsOrnamentalColorDO _do) {
        if (_do == null) {
            return null;
        }
        return new PlantsOrnamentalColorVO().toPlantsOrnamentalColor(_do);
    }

    private final PlantsOrnamentalColorVO toPlantsOrnamentalColor(PlantsOrnamentalColorDO _do) {
        setColor(_do.getColor());
        setDisplay(_do.getDisplay());
        setGmt_created(_do.getGmt_created());
        setIcon(_do.getIcon());
        setId(_do.getId());
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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