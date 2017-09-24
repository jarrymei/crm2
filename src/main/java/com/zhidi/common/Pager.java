package com.zhidi.common;

import java.util.List;

public class Pager<T> {

	private Integer pageSize = 10;
	private Integer pageNumber = 1;
	private Integer totalPage = 0;
	private Integer totalRows = 0;
	private List<T> data;
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		if (pageNumber < 1) {
			return pageNumber = 1;
		} 
		if (totalPage != 0 && pageNumber > totalPage) {
			return pageNumber = totalPage;
		}
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getTotalPage() {
		if (pageSize != 0) {
			totalPage = (totalRows + pageSize -1)/pageSize;
		}
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
		this.totalPage = getTotalPage();
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
