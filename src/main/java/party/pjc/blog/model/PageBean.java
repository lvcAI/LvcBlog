package party.pjc.blog.model;

public class PageBean {

	private int page; // 当前页
	private int pageSize; // 一页大小
	@SuppressWarnings("unused")
	private int start;  // 一页 开始的位置
	
	
	public PageBean(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	public void setStart(int start) {
		this.start = start;
	}

	public int getStart() {
		return (page-1)*pageSize;
	}
	
}
