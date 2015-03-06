package me.scape.ti.vo.request;

public class ContestJudgeListRequest extends PaginationRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
