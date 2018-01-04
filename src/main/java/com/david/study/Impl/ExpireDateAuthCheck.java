package com.david.study.Impl;

public class ExpireDateAuthCheck extends ResultsAuthCheck {

	private String expireDate = "2017-12-20";
	
	public ExpireDateAuthCheck() {
		//System.out.println("ExpireDateAuthCheck constructor");
	}

	public String getexpireDate() {
		System.out.println("tiger head:" + expireDate);
		return expireDate;
	}

	public void setexpireDate(String head) {
		this.expireDate = head;
	}

	public void processing() {
		// TODO Auto-generated method stub
		System.out.println("++++ExpireDateAuthCheck-ExpireDate Check execute!++++");
		super.CheckResults();
	}

}
