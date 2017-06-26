package net.learn.sdkstudy.testclass;

import java.util.Date;

public class TestInheritA extends TestClassA {

	public final void setStrina(String strina) {
		this.strina = strina;
	}

	public final void setIntina(int intina) {
		this.intina = intina;
	}

	public final String getStrina() {
		return strina;
	}

	public final int getIntina() {
		return intina;
	}

	String strina;
	int intina;

	public TestInheritA(String stra, int inta, Date datea, String strina, int intina) {
		super(stra, inta, datea);
		this.strina = strina;
		this.intina = intina;
	}

}
