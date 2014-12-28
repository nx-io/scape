package me.scape.ti.srv;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月28日 下午4:00:19
 */
public class PageQuery {
	
	private final static int DEFAULT_PAGE_SIZE = 10;

	private final int index;
	private final int size;

	public PageQuery(int page) {
		this(page, DEFAULT_PAGE_SIZE);
	}

	public PageQuery(int page, int size) {
		super();
		page = page < 1 ? 1 : page;
		index = (page - 1) * size;
		this.size = size;
	}

	public int getIndex() {
		return index;
	}

	public int getSize() {
		return size;
	}
}