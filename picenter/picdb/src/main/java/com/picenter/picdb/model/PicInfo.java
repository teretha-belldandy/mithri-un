package com.picenter.picdb.model;

public class PicInfo {
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Double getPsize() {
		return psize;
	}

	public void setPsize(Double psize) {
		this.psize = psize;
	}

	public String getPpath() {
		return ppath;
	}

	public void setPpath(String ppath) {
		this.ppath = ppath;
	}

	private Integer pid;
	
	private String pname;
	
	private String pdesc;
	
	private Double psize;
	
	private String ppath;
	
	public String toString() {
		return String.format("id:%s, name:%s, description:%s, size:%s, path:%s", pid, pname, pdesc, psize, ppath);
	}

}
