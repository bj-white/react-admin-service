package com.it.bw.pojo;

public class BaseQueryVo {
	private Integer page;
	private Integer rows;
	private Integer start;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getStart() {
		if (page != null && rows != null) {
			return (page - 1) * rows;
		}
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
}
