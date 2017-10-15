package org.picenter.pictest.testclass;

import java.util.Date;

public class TestClassA {
	public final void setStra(String stra) {
		this.stra = stra;
	}

	public final void setInta(int inta) {
		this.inta = inta;
	}

	public final void setDatea(Date datea) {
		this.datea = datea;
	}

	public final String getStra() {
		return stra;
	}

	public final int getInta() {
		return inta;
	}

	public final Date getDatea() {
		return datea;
	}

	public String stra;
	public int inta;
	public Date datea;
	
	public TestClassA (String stra, int inta, Date datea) {
		this.stra = stra;
		this.inta = inta;
		this.datea = datea;
	}
}
