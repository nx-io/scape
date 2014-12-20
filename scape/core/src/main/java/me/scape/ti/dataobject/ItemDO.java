package me.scape.ti.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 景观案例信息。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月17日 下午11:52:23
 */
@Entity
@Table(name = "item", catalog = "scape")
public class ItemDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected Integer id;

    @Column(name = "title", nullable = false, length = 64)
    private String title;// 标题

    @Column(name = "type", nullable = false)
    private Integer type;// 1:原创，2:分享

    @Column(name = "category_id", nullable = false)
    private Integer category_id;// 景观分类

    @Column(name = "area_category_id", nullable = false)
    private Integer area_category_id;// 景观区域分类

    @Column(name = "style_id", nullable = false)
    private Integer style_id;// 风格

    @Column(name = "status", nullable = false)
    private Boolean status;// 状态，1:可用，0:不可用，-1:删除

    @Lob
    @Column(name = "description")
    private String description;// 案例描述, 过长的话考虑以后放入redis缓存

    @Column(name = "designer", length = 64)
    private String designer;// 设计师

    @Column(name = "designer_contact", length = 64)
    private String designer_contact;// 设计师联系方式

    @Column(name = "constructor", length = 64)
    private String constructor;// 施工者

    @Column(name = "constructor_contact", length = 64)
    private String constructor_contact;// 施工者联系方式

    @Column(name = "cover_media", nullable = false, length = 256)
    private String cover_media;// 案例封皮

    @Column(name = "media_count", nullable = false)
    private Integer media_count;// 案例图片个数

    @Column(name = "comment_count", nullable = false)
    private Integer comment_count;// 评论数

    @Column(name = "praise_count", nullable = false)
    private Integer praise_count;// 赞数

    @Column(name = "like_count", nullable = false)
    private Integer like_count;// 收藏数

    @Column(name = "user_id", nullable = false)
    private Integer user_id;// 发布者

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_created", nullable = false)
    protected Date gmt_created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    protected Date gmt_modified;
}
