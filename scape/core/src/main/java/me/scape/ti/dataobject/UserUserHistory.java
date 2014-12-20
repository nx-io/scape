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
 * 收藏的用户。
 * 
 * @author WangJianZheng E-mail:zing.wang@look.com
 * @version 1.0.0
 * @since 2014年12月21日 上午01:30:00
 */
@Entity
@Table(name = "user_user_history", catalog = "scape")
public class UserUserHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;// 用户ID

    @Column(name = "favorite_id", nullable = false)
    private Integer favorite_id;// 被收藏的用户ID

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_created", nullable = false)
    protected Date gmt_created;
}
