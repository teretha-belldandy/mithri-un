package net.mithrigintama.piccenter.picpojo;

import net.mithrigintama.piccenter.picconst.PicRant;

public class PicInfo {

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getPicDescription() {
		return picDescription;
	}

	public void setPicDescription(String picDescription) {
		this.picDescription = picDescription;
	}

	public PicRant getPicRant() {
		return picRant;
	}

	public void setPicRant(PicRant picRant) {
		this.picRant = picRant;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	private int picId;
	private String picName;
	private String picDescription;
	private PicRant picRant;
	private String picUrl;

}
