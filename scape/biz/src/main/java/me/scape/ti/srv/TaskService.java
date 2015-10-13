package me.scape.ti.srv;

import me.scape.ti.result.Result;
import me.scape.ti.ro.ApplyTaskRequest;
import me.scape.ti.ro.PrivilegedPageRequest;
import me.scape.ti.ro.PublishTaskRequest;
import me.scape.ti.ro.TaskSearchRequest;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 *
 * @version 1.0.0
 * @since 2015年10月13日 下午8:32:36
 */
public interface TaskService {

    Result publishTask(PublishTaskRequest request);
    
    Result applyTask(ApplyTaskRequest request);
    
    Result getTaskDetail(Long taskId);
    
    Result myApplyTask(PrivilegedPageRequest request);
    
    Result myPublishTask(PrivilegedPageRequest request);
    
    Result search(TaskSearchRequest request);
}