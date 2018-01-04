package com.david.study.sample.entity;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public class SampleEntity2 extends GenericEntity {

	public String string1;
	public String string2;

	public SampleEntity2(String s1, String s2) {
		this.string1 = s1;
		this.string2 = s2;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	@Override
	public String toString() {
		return "NodeData [string=" + string1 + ", number=" + string2 + "]";
	}

}
