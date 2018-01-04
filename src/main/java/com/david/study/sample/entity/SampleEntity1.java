package com.david.study.sample.entity;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public class SampleEntity1 extends GenericEntity {

	public String string;
	public int number;

	public SampleEntity1(String s, int i) {
		this.string = s;
		this.number = i;
	}

	public SampleEntity1(int i) {
		this.string = null;		
		this.number = i;
	}

	public SampleEntity1() {
	}	
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "NodeData [string=" + string + ", number=" + number + "]";
	}

}
