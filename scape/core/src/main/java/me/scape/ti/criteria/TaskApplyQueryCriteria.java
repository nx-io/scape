package me.scape.ti.criteria;

public class TaskApplyQueryCriteria extends PaginationCriteria {
    
    private Long applyUserId;// 申请人
    
    private Long task_id;// 任务

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }
}
