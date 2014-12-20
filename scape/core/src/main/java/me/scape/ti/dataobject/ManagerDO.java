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
 * 管理员。
 * 
 * @author WangJianZheng E-mail:zing.wang@look.com
 * @version 1.0.0
 * @since 2014年12月21日 上午01:30:00
 */
@Entity
@Table(name = "manager", catalog = "scape")
public class ManagerDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;// 用户名

    @Column(name = "email", unique = true, nullable = false)
    private String email;// 邮箱/账号

    @Column(name = "avatar")
    private String avatar;// 头像

    @Column(name = "status", nullable = false)
    private Boolean status;// 状态，1:可用，0:不可用，-1:删除

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
