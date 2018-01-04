/*
 * not in action
 */

package com.david.study.sample.node;

public class NodeStatusField {

	// for security usage table column level
	/**
	 * 
	 */
	private int fieldReadCondition;
	// for security usage table column level
	private int fieldUpdateCondition;
	// for security usage table column level
	private int fieldDisplayCodition;
	private int fieldAmmendIndicator;
	private int fieldNullIndicator;
	// field check result code
	private int fieldResultCode;

	public int getFieldReadCondition() {
		return fieldReadCondition;
	}

	public void setFieldReadCondition(int fieldReadCondition) {
		this.fieldReadCondition = fieldReadCondition;
	}

	public int getFieldUpdateCondition() {
		return fieldUpdateCondition;
	}

	public void setFieldUpdateCondition(int fieldUpdateCondition) {
		this.fieldUpdateCondition = fieldUpdateCondition;
	}

	public int getFieldDisplayCodition() {
		return fieldDisplayCodition;
	}

	public void setFieldDisplayCodition(int fieldDisplayCodition) {
		this.fieldDisplayCodition = fieldDisplayCodition;
	}

	public int getFieldAmmendIndicator() {
		return fieldAmmendIndicator;
	}

	public void setFieldAmmendIndicator(int fieldAmmendIndicator) {
		this.fieldAmmendIndicator = fieldAmmendIndicator;
	}

	public int getFieldNullIndicator() {
		return fieldNullIndicator;
	}

	public void setFieldNullIndicator(int fieldNullIndicator) {
		this.fieldNullIndicator = fieldNullIndicator;
	}

	public int getFieldResultCode() {
		return fieldResultCode;
	}

	public void setFieldResultCode(int fieldResultCode) {
		this.fieldResultCode = fieldResultCode;
	}

	@Override
	public String toString() {
		return "NodeStatusField [fieldReadCondition=" + fieldReadCondition + ", fieldUpdateCondition="
				+ fieldUpdateCondition + ", fieldDisplayCodition=" + fieldDisplayCodition + ", fieldAmmendIndicator="
				+ fieldAmmendIndicator + ", fieldNullIndicator=" + fieldNullIndicator + ", fieldResultCode="
				+ fieldResultCode + "]";
	}

	
}
