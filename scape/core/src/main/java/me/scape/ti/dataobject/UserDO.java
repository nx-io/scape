package me.scape.ti.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * 用户信息。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月17日 下午11:55:39
 */
@Entity
@Table(name = "user", catalog = "scape")
public class UserDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected Integer id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;// 设计师/企业名称

    @Column(name = "fullname", length = 64)
    private String fullname;// 真实姓名

    @Column(name = "status", nullable = false)
    private Boolean status;// 状态，1:可用，0:不可用，-1:删除

    @Column(name = "avatar", length = 256)
    private String avatar;// 头像

    @Column(name = "password", nullable = false, length = 64)
    private String password;// 密码

    @Column(name = "salt", nullable = false, length = 64)
    private String salt;// 密码salt

    @Column(name = "email", length = 64)
    private String email;// 邮箱

    @Column(name = "mobile", length = 64)
    private String mobile;// 手机

    @Column(name = "contact", length = 64)
    private String contact;// 联系方式

    @Column(name = "category_id")
    private Integer category_id;// 特长

    @Lob
    @Column(name = "profile", nullable = false)
    private String profile;// 简介

    @Column(name = "is_email_verified", nullable = false)
    private Boolean is_email_verified = false;// 邮箱是否验证

    @Column(name = "is_mobile_verified", nullable = false)
    private Boolean is_mobile_verified = false;// 手机是否验证

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login")
    private Date last_login;// 最后一次登录的时间

    @Column(name = "last_ip", nullable = false)
    private long last_ip;// 最后一次登录的IP

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_created", nullable = false)
    protected Date gmt_created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    protected Date gmt_modified;

}