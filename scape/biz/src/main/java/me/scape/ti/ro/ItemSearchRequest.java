package me.scape.ti.ro;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月28日 下午3:13:29
 */
public class ItemSearchRequest extends NonPrivilegedPageRequest {

	private Long cid;// 景观分类

	private Long acid;// 景观区域分类

	private Long sid;// 风格

	private String title;// 标题

	private Long id;// 案例ID

	private String sort;// 排序字段

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getAcid() {
		return acid;
	}

	public void setAcid(Long acid) {
		this.acid = acid;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}