package kr.co.from.common.dto;

public class PageDTO {

	private String path = "/";
	protected int page = 1;
	protected int rows = 10;
	protected int total = 0;
	protected int navi = 10;
	protected int totalPageSize = 0;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
		totalPageSize = (int)Math.ceil( (double)total / getRows() );
	}
	public int getNavi() {
		return navi;
	}
	public void setNavi(int navi) {
		this.navi = navi;
	}
	public int getTotalPageSize() {
		return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	public int getRows() {
		return rows;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
}

