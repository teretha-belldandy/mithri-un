package com.picenter.picservice.model;

import com.picenter.picservice.common.PicSearchBaseModel;

public class PicInfo extends PicSearchBaseModel {

	private static final long serialVersionUID = 4724854832413100893L;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	private String pid;
	private String desc;
	private String urlPath;
	private byte[] content;

}
