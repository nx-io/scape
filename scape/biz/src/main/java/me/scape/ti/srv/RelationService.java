package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.ro.CommentsRequest;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午3:35:44
 */
public interface RelationService {

	Result comments(CommentsRequest request);

}