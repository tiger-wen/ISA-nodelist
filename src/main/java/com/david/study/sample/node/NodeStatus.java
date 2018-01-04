package com.david.study.sample.node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public class NodeStatus {

	@Deprecated
	public Map<String, Map<String, String>> entityStatus = new HashMap<String, Map<String, String>>();
	public String FieldMap;
	// the columns number in entity
	public int fieldsNumber;
	// for commit node list usage
	public int lastUpdatedNumber;
	// entity identification indicator
	public String dgpentityidentity;
	// entity description
	public String dgpentitydescription;
	// A - Available 
	// U - USE 
	public String dgpstatuscondition;
	// R - SQL select
	// U - SQL update
	// A - SQL insert
	public String dgpdatacondition;
	// for security usage table record level
	public int dgpreadcondition;
	// for security usage table record level
	public int dgpupdatecondition;
	// for security usage table record level
	public int dgpinsertcondition;

	public Map<String, NodeStatusField> fieldStatus = new HashMap<>();
	
	public NodeStatus() {

	}
	
	@Deprecated
	public void setFieldNullCondition(String fieldName, String value) {
		Map<String, String> fieldStatus = new HashMap<String, String>();

		if (fieldStatus.containsKey("fieldNullCondition")) {
			fieldStatus.replace("fieldNullCondition", value);
		} else {
			fieldStatus.put("fieldNullCondition", value);
		}

		if (entityStatus.containsKey(fieldName)) {
			entityStatus.replace(fieldName, fieldStatus);
		} else {
			entityStatus.put(fieldName, fieldStatus);
		}
	}

	@Deprecated
	public String getFieldReadConditionSatus(String fieldName) {
		Map<String, String> fieldStatus = entityStatus.get(fieldName);
		return fieldStatus.get("fieldNullCondition");
	}

	public int getfieldsNumber() {
		return fieldsNumber;
	}

	public void setfieldsNumber(int fieldsNumber) {
		this.fieldsNumber = fieldsNumber;
	}

	public int getlastUpdatedNumber() {
		return lastUpdatedNumber;
	}

	public void setlastUpdatedNumber(int lastUpdatedNumber) {
		this.lastUpdatedNumber = lastUpdatedNumber;
	}
	
	public String getDgpstatuscondition() {
		return dgpstatuscondition;
	}

	public void setDgpstatuscondition(String dgpstatuscondition) {
		this.dgpstatuscondition = dgpstatuscondition;
	}

	public String getDgpdatacondition() {
		return dgpdatacondition;
	}

	public void setDgpdatacondition(String dgpdatacondition) {
		this.dgpdatacondition = dgpdatacondition;
	}

	public int getDgpreadcondition() {
		return dgpreadcondition;
	}

	public void setDgpreadcondition(int dgpreadcondition) {
		this.dgpreadcondition = dgpreadcondition;
	}

	public int getDgpupdatecondition() {
		return dgpupdatecondition;
	}

	public void setDgpupdatecondition(int dgpupdatecondition) {
		this.dgpupdatecondition = dgpupdatecondition;
	}

	public int getDgpinsertcondition() {
		return dgpinsertcondition;
	}

	public void setDgpinsertcondition(int dgpinsertcondition) {
		this.dgpinsertcondition = dgpinsertcondition;
	}

	public String getEntityFieldMap() {
		return FieldMap;
	}
	
	public String getDgpentityidentity() {
		return dgpentityidentity;
	}

	public void setDgpentityidentity(String dgpentityidentity) {
		this.dgpentityidentity = dgpentityidentity;
	}

	public String getDgpentitydescription() {
		return dgpentitydescription;
	}

	public void setDgpentitydescription(String dgpentitydescription) {
		this.dgpentitydescription = dgpentitydescription;
	}

	public String getFieldIndicator(int fieldNumber) {
		return this.FieldMap.substring(fieldNumber - 1, fieldNumber);
	}

	public void setFiledIndicator(int fieldNumber, String indicator) {

		String stringhead, stringtail, newstring;

		if (this.FieldMap.length() > fieldNumber) {
			stringhead = this.FieldMap.substring(0, fieldNumber - 1);
			stringtail = this.FieldMap.substring(fieldNumber, this.FieldMap.length());
			newstring = stringhead + indicator + stringtail;
			this.FieldMap = newstring;
		}
	}

	@Override
	public String toString() {
		return "NodeStatus [ + DGPDataCondition=" + dgpdatacondition + ", DGPStatusCondition=" + dgpstatuscondition
				+ ", lastUpdatedNumber=" + lastUpdatedNumber + ", entityID=" + dgpentityidentity + ", entityDescription="
				+ dgpentitydescription + ", fieldStatus=" + fieldStatus + "]";
	}

	
}
