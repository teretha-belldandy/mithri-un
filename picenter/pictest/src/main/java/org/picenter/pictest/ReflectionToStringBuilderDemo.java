package org.picenter.pictest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class ReflectionToStringBuilderDemo {

	public static void main(String[] args) {
		Ca ca = new Ca(1, "ca", new Ib(2, "ib"));
		ReflectionToStringBuilder refToStrBuilder = new ReflectionToStringBuilder(ca);
		refToStrBuilder.setExcludeFieldNames(new String[] {"sa"});
		refToStrBuilder.setExcludeFieldNames(new String[] {"ia"});
		refToStrBuilder.setExcludeFieldNames(new String[] {"iba"});
		refToStrBuilder.append("sa", "aaaaa");
		System.out.println(refToStrBuilder.toString());
	}

}

class Ca {
	public Ca(int ia, String sa, Ib iba) {
		this.ia = ia;
		this.sa = sa;
		this.iba = iba;
	}
	public int ia;
	public String sa;
	public Ib iba;
}

class Ib {
	public Ib(int ib, String sb) {
		this.ib = ib;
		this.sb = sb;
	}
	public int ib;
	public String sb;
}
