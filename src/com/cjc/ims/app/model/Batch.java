package com.cjc.ims.app.model;

public class Batch {
	private int bid;
	private String BatchName;
	private Faculty f;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBatchName() {
		return BatchName;
	}
	public void setBatchName(String batchName) {
		BatchName = batchName;
	}
	public Faculty getF() {
		return f;
	}
	public void setF(Faculty f) {
		this.f = f;
	}
	
	

}
