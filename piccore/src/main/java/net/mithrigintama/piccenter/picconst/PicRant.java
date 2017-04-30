package net.mithrigintama.piccenter.picconst;

public enum PicRant {

	GOOD(1, "good"), EXCELLENT(2, "excellent"), PERFECT(3, "perfect"), UNBELIVABLE(4, "unbelivable"), FAIRY(5, "fairy");

	private PicRant(int rant, String desc) {
		this.rant = rant;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.format("rant is %s, description is %s", this.rant, this.desc);
	}

	private int rant;

	private String desc;

}
