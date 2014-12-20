package me.scape.ti.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class CategoryDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected Integer id;

    @Column(name = "name", unique = true, nullable = false, length = 64)
    private String name;// 分类名称

    @Column(name = "description", length = 256)
    private String description;// 分类描述

    @Column(name = "icon", length = 256)
    private String icon;// 分类图标

    @Column(name = "is_listed", nullable = false)
    private Boolean is_listed;// 是否展示

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_created", nullable = false)
    protected Date gmt_created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    protected Date gmt_modified;

}