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
 * 收藏/赞的景观。
 * 
 * @author WangJianZheng E-mail:zing.wang@look.com
 * @version 1.0.0
 * @since 2014年12月21日 上午01:30:00
 */
@Entity
@Table(name = "user_item_history", catalog = "scape")
public class UserItemHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;// 用户ID

    @Column(name = "item_id", nullable = false)
    private Integer item_id;// 案例ID

    @Column(name = "type", nullable = false)
    private Integer type;// 1:赞，2:收藏

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_created", nullable = false)
    protected Date gmt_created;
}
