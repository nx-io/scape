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
 * 相关展示图片, 视频。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月18日 上午12:41:16
 */
@Entity
@Table(name = "item_media", catalog = "scape")
public class ItemMediaDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "item_id", nullable = false)
    private Integer item_id;// 案例ID

    @Column(name = "url", nullable = false, length = 256)
    private String url;// 图片, 视频地址

    @Column(name = "status", nullable = false)
    private Integer status;// 状态， 1:可用， -1:删除

    @Column(name = "type", nullable = false)
    private Integer type;// 类型 1:图片, 2:视频

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_created", nullable = false)
    protected Date gmt_created;
}