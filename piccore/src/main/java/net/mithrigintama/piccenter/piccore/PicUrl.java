package net.mithrigintama.piccenter.piccore;

public class PicUrl {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.format("name is %s, url is %s, desc is %s.", name, purl, desc);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (null == obj || !obj.getClass().equals(this.getClass())) {
			return false;
		}
		PicUrl pobj = (PicUrl) obj;
		return name.equals(pobj.getName()) && purl.equals(pobj.getPurl());
	}

	@Override
	public int hashCode() {
		return name.hashCode() + purl.hashCode();
	}

	private String name;

	private String purl;

	private String desc;

}
