package me.scape.ti.srv.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import me.scape.ti.commons.Pagination;
import me.scape.ti.criteria.TaskApplyQueryCriteria;
import me.scape.ti.criteria.TaskQueryCriteria;
import me.scape.ti.dataobject.TaskDO;
import me.scape.ti.dataobject.TaskUserDO;
import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.ApplyTaskRequest;
import me.scape.ti.ro.PrivilegedPageRequest;
import me.scape.ti.ro.PublishTaskRequest;
import me.scape.ti.ro.TaskSearchRequest;
import me.scape.ti.srv.BaseService;
import me.scape.ti.srv.PageQuery;
import me.scape.ti.srv.TaskService;
import me.scape.ti.vo.ApplyTaskVO;
import me.scape.ti.vo.TaskVO;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 *
 * @version 1.0.0
 * @since 2015年10月13日 下午8:38:03
 */
@Service("taskService")
public class DefaultTaskService extends BaseService implements TaskService {

    @Override
    public Result search(TaskSearchRequest request) {
        TaskQueryCriteria criteria = new TaskQueryCriteria();
        criteria.setDescription(request.getDescription());
        criteria.setFromCreated(request.getFromCreated());
        criteria.setFromReward(request.getFromReward());
        criteria.setFromStartDate(request.getFromStartDate());
        Integer page = request.getPage();
        page = (page != null && page > 0) ? page : 1;
        PageQuery pageQuery = new PageQuery(page);
        criteria.setLimit(pageQuery.getSize());
        criteria.setOffset(pageQuery.getIndex());
        criteria.setPublishUserId(criteria.getPublishUserId());
        criteria.setStatus(criteria.getStatus());
        criteria.setToCreated(criteria.getToCreated());
        criteria.setToReward(request.getToReward());
        criteria.setToStartDate(request.getToStartDate());
        criteria.setType(criteria.getType());
        Pagination<TaskDO> taskPage = taskDAO.query(criteria);
        List<TaskDO> taskList = taskPage.getItems();
        if (CollectionUtils.isNotEmpty(taskList)) {
            List<TaskVO> taskVOList = new ArrayList<TaskVO>();
            for (TaskDO task : taskList) {
                try {
                    taskVOList.add(TaskVO.newInstance(task));
                } catch (Exception ingore) {
                }
            }
            return Result.newSuccess().with(ResultCode.Success).with("taskList", taskVOList);
        }
        return Result.newSuccess().with(ResultCode.Error_Task_NotExists);
    }

    @Override
    public Result myApplyTask(PrivilegedPageRequest request) {
        Result privileged = doPrivileged(request);
        if (!privileged.isSuccess()) {
            return privileged;
        }
        Long userId = privileged.getResponse(Long.class);
        TaskApplyQueryCriteria criteria = new TaskApplyQueryCriteria();
        criteria.setApplyUserId(userId);
        Integer page = request.getPage();
        page = (page != null && page > 0) ? page : 1;
        PageQuery pageQuery = new PageQuery(page);
        criteria.setLimit(pageQuery.getSize());
        criteria.setOffset(pageQuery.getIndex());
        Pagination<TaskUserDO> taskUserPage = taskUserDAO.query(criteria);
        List<TaskUserDO> taskUserList = taskUserPage.getItems();
        if (CollectionUtils.isNotEmpty(taskUserList)) {
            List<ApplyTaskVO> applyTaskList = new ArrayList<ApplyTaskVO>();
            for (TaskUserDO taskUser : taskUserList) {
                try {
                    Long taskId = taskUser.getTask_id();
                    TaskDO task = taskDAO.get(taskId);
                    if (task == null) {
                        continue;
                    }
                    applyTaskList.add(ApplyTaskVO.newInstance(task).applyTask(taskUser));
                } catch (Exception ingore) {
                }
            }
            return Result.newSuccess().with(ResultCode.Success).with("taskList", applyTaskList);
        }
        return Result.newSuccess().with(ResultCode.Error_Task_NotExists);
    }

    @Override
    public Result myPublishTask(PrivilegedPageRequest request) {
        Result privileged = doPrivileged(request);
        if (!privileged.isSuccess()) {
            return privileged;
        }
        Long userId = privileged.getResponse(Long.class);
        TaskQueryCriteria criteria = new TaskQueryCriteria();
        criteria.setPublishUserId(userId);
        Pagination<TaskDO> taskPage = taskDAO.query(criteria);
        List<TaskDO> taskList = taskPage.getItems();
        if (CollectionUtils.isNotEmpty(taskList)) {
            List<TaskVO> taskVOList = new ArrayList<TaskVO>();
            for (TaskDO task : taskList) {
                try {
                    taskVOList.add(TaskVO.newInstance(task));
                } catch (Exception ingore) {
                }
            }
            return Result.newSuccess().with(ResultCode.Success).with("taskList", taskVOList);
        }
        return Result.newSuccess().with(ResultCode.Error_Task_NotExists);
    }

    @Override
    public Result getTaskDetail(Long taskId) {
        TaskDO task = taskDAO.get(taskId);
        if (task == null) {
            return Result.newSuccess().with(ResultCode.Error_Task_NotExists);
        }
        return Result.newSuccess().with(ResultCode.Success).with("task", TaskVO.newInstance(task));
    }

    @Override
    public Result publishTask(PublishTaskRequest request) {
        Result privileged = doPrivileged(request);
        if (!privileged.isSuccess()) {
            return privileged;
        }
        Long userId = privileged.getResponse(Long.class);
        TaskDO task = new TaskDO();
        task.setDescription(request.getDescription());
        task.setEnd_date(request.getEnd_date());
        task.setGmt_created(new Date());
        task.setGmt_modified(new Date());
        task.setReward(request.getReward());
        task.setStart_date(request.getStart_date());
        task.setStatus(TaskDO.NEED_BIDS);
        task.setType(request.getType());
        task.setUser_id(userId);
        taskDAO.persist(task);
        return Result.newSuccess().with(ResultCode.Success).with("task", TaskVO.newInstance(task));
    }

    @Override
    public Result applyTask(ApplyTaskRequest request) {
        Result privileged = doPrivileged(request);
        if (!privileged.isSuccess()) {
            return privileged;
        }
        TaskDO task = taskDAO.get(request.getTask_id());
        if (task == null) {
            return Result.newSuccess().with(ResultCode.Error_Task_NotExists);
        }
        Long userId = privileged.getResponse(Long.class);
        TaskUserDO applyTask = new TaskUserDO();
        applyTask.setGmt_created(new Date());
        applyTask.setGmt_modified(new Date());
        applyTask.setIsBid(TaskUserDO.BIDS);
        applyTask.setTask_id(request.getTask_id());
        applyTask.setUser_id(userId);
        taskUserDAO.persist(applyTask);
        return Result.newSuccess().with(ResultCode.Success).with("apply_task", ApplyTaskVO.newInstance(task).applyTask(applyTask));
    }
}
