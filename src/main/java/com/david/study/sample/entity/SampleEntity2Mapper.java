package com.david.study.sample.entity;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public class SampleEntity2Mapper {
	
public SampleEntity2 selectByPrimaryKey(String s) {

		SampleEntity2 test = null;
		switch (s) {
		case "A":{
			test = new SampleEntity2("A", "AAAAAAA Test String");
			break;			
		}
		case "B":{
			test = new SampleEntity2("B", "BBBBBBB Test String");
			break;			
		}
		default:{
			test = new SampleEntity2("Z", "ZZZZZZZ Test String");
			break;
		}
		}
		return test;
	}
}
