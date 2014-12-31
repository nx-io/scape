package me.scape.ti.srv.impl;

import java.util.Date;

import me.scape.ti.dataobject.CommentsDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.CommentsRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.RelationService;
import me.scape.ti.vo.CommentsVO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 评论、赞、收藏的关系业务处理.
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午3:36:23
 */
@Service(value = "relationService")
public class DefaultRelationService extends BaseService implements RelationService {

	/**
	 * 发布评论
	 */
	@Override
	@Transactional(value = "transactionManager", rollbackFor = Throwable.class)
	public Result comments(CommentsRequest request) {
		CommentsDO comments = new CommentsDO();
		comments.setContent(request.getContent());
		Date now = new Date();
		comments.setGmt_created(now);
		comments.setGmt_modified(now);
		comments.setItem_id(request.getItem_id());
		comments.setRef_id(request.getRef_id());
		comments.setStatus(CommentsDO.Available);
		comments.setUser_id(request.getUser_id());
		comments.setUser_name(request.getUser_name());
		commentsDAO.persist(comments);
		return Result.newSuccess().with(ResultCode.Success).with("comments", CommentsVO.newInstance(comments));
	}
}