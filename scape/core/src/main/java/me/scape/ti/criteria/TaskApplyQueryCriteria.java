package me.scape.ti.criteria;

public class TaskApplyQueryCriteria extends PaginationCriteria {
    
    private Long applyUserId;// 申请人

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }
}
