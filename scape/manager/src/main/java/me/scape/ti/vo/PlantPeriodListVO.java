package me.scape.ti.vo;

import java.io.Serializable;
import java.util.Date;

public class PlantPeriodListVO implements Serializable {

    private static final long serialVersionUID = 2484003238105499312L;

    private Integer id;

    private String period;

    private Byte display;

    private Date gmt_created;

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