package com.david.study.sample.entity;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public class SampleEntity1Mapper {

	public SampleEntity1 selectByPrimaryKey(int i) {

		SampleEntity1 test = null;
		
		switch (i) {
		case 1: {
			test = new SampleEntity1("AAAAA", 1);
			break;
		}
		case 2: {
			test = new SampleEntity1("BBBBBB", 2);
			break;
		}
		case 9: {
			test = new SampleEntity1("CCCCCC",9);
			break;
		}
		}

		return test;
	}
}
