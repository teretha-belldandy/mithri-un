package net.learn.sdkstudy;

import java.util.Date;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class orikaDemo {

	public static void main(String[] args) {
		MapperFacade mapperFacade = new ConfigurableMapper();
		Cma cma = new Cma();
		cma.setI(5);
		cma.setS("test mapperFacade");
		cma.setD(new Date());
		Cmb cmb = mapperFacade.map(cma, Cmb.class);
		System.out.printf("%s -- %s -- %s", cmb.i, cmb.s, cmb.d);
	}
}

class Cma {
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	int i;
	String s;
	Date d;

}

class Cmb {
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	int i;
	String s;
	Date d;
}