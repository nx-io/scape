package me.scape.ti.ro;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 发布任务
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午3:33:06
 */
public class ApplyTaskRequest extends PrivilegedRequest {
	
	private static final long serialVersionUID = -4565857987031446409L;
    @NotEmpty
    private Long task_id;// 任务

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }
}