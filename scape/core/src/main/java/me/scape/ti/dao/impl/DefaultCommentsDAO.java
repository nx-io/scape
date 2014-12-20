package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.commons.DefaultGenericDAO;
import me.scape.ti.dao.CommentsDAO;
import me.scape.ti.dataobject.CommentsDO;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月19日 上午12:21:43
 */
@Repository(value = "commentsDAO")
public class DefaultCommentsDAO extends DefaultGenericDAO<CommentsDO, Long> implements CommentsDAO {
	
}
