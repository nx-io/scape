package me.scape.ti.dao.impl;

import me.scape.ti.dao.CommentsDAO;
import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dataobject.CommentsDO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:21:43
 */
@Repository("commentsDAO")
public class DefaultCommentsDAO extends EntityManagerSupportGenericDAO<CommentsDO, Long> implements CommentsDAO {

}
