package com.jing.edu.model;

public class PageSet {

	private int size ;//每页显示的记录数
	private int page ;//当前页(从1开始)
	private int offset ;//(记录的偏移量)
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getOffset() {
		return (this.page - 1) * this.size;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
}
