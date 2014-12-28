package me.scape.ti.vo.request;

public class UserListRequest extends PaginationRequest {

    private Integer status;

    private String name;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
