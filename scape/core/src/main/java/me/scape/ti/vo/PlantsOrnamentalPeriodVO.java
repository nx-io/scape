package me.scape.ti.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import me.scape.ti.dataobject.PlantsOrnamentalPeriodDO;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月27日 下午6:53:52
 */
public class PlantsOrnamentalPeriodVO {

    private Integer id;

    private String period;// 植物观赏期

    private Byte display = 1;// 是否展示 1展示 0不展示 -1删除

    private Date gmt_created;

    public static List<PlantsOrnamentalPeriodVO> newInstance(List<PlantsOrnamentalPeriodDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
            return Collections.emptyList();
        }
        List<PlantsOrnamentalPeriodVO> voList = new ArrayList<PlantsOrnamentalPeriodVO>();
        for (PlantsOrnamentalPeriodDO _do : doList) {
            PlantsOrnamentalPeriodVO vo = PlantsOrnamentalPeriodVO.newInstance(_do);
            if (vo == null) {
                continue;
            }
            voList.add(vo);
        }
        return voList;
    }

    public static PlantsOrnamentalPeriodVO newInstance(PlantsOrnamentalPeriodDO _do) {
        if (_do == null) {
            return null;
        }
        return new PlantsOrnamentalPeriodVO().toPlantsOrnamentalPeriod(_do);
    }

    private final PlantsOrnamentalPeriodVO toPlantsOrnamentalPeriod(PlantsOrnamentalPeriodDO _do) {
        setDisplay(_do.getDisplay());
        setGmt_created(_do.getGmt_created());
        setId(_do.getId());
        setPeriod(_do.getPeriod());
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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