package me.scape.ti.dataobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 景观案例评论。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月18日 上午12:12:15
 */
@Entity
@Table(name = "comments", catalog = "scape")
public class CommentsDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "item_id", nullable = false)
    private Long item_id;// 案例ID

    @Column(name = "user_id", nullable = false)
    private Long user_id;// 用户ID, 评论人ID

    @Column(name = "user_name", nullable = false, length = 64)
    private String user_name;// 冗余的设计师/企业名称

    @Column(name = "content", nullable = false, length = 256)
    private String content;// 评论内容

    @Column(name = "status", nullable = false)
    private Integer status;// 状态，1可用，0不可用，-1删除
}