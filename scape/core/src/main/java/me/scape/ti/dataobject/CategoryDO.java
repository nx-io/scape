package me.scape.ti.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 景观分类。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月18日 下午10:33:37
 */
@Entity
@Table(name = "category", catalog = "scape")
@NamedQueries({ @NamedQuery(name = "CategoryDO.getCategoriesByIds", query = "FROM CategoryDO WHERE id IN ?"),
        @NamedQuery(name = "CategoryDO.getAllCategories", query = "FROM CategoryDO WHERE display != -1") })
public class CategoryDO implements Serializable {

    private static final long serialVersionUID = -6699900925277840615L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 64)
    private String name;// 分类名称

    @Column(name = "description", length = 255)
    private String description;// 分类描述

    @Column(name = "icon", length = 255)
    private String icon;// 分类图标

    @Column(name = "display", nullable = false)
    private Byte display = 1;// 是否展示 1展示 0不展示 -1删除

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_created", nullable = false)
    private Date gmt_created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    private Date gmt_modified;

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

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((display == null) ? 0 : display.hashCode());
        result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
        result = prime * result + ((gmt_modified == null) ? 0 : gmt_modified.hashCode());
        result = prime * result + ((icon == null) ? 0 : icon.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CategoryDO other = (CategoryDO) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (display == null) {
            if (other.display != null)
                return false;
        } else if (!display.equals(other.display))
            return false;
        if (gmt_created == null) {
            if (other.gmt_created != null)
                return false;
        } else if (!gmt_created.equals(other.gmt_created))
            return false;
        if (gmt_modified == null) {
            if (other.gmt_modified != null)
                return false;
        } else if (!gmt_modified.equals(other.gmt_modified))
            return false;
        if (icon == null) {
            if (other.icon != null)
                return false;
        } else if (!icon.equals(other.icon))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}