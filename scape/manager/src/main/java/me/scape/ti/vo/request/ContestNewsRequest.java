package me.scape.ti.vo.request;


public class ContestNewsRequest {

    private Long id;

    private String title;

    private Integer contest_id;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getContest_id() {
        return contest_id;
    }

    public void setContest_id(Integer contest_id) {
        this.contest_id = contest_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
