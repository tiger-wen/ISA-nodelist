package com.david.study.sample.message;

import com.david.study.sample.utils.IdUtils;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public class TxnMsgHead {

	private static ThreadLocal<Long> TRACE_ID = new InheritableThreadLocal<>();

	private String crbDescription;
	private long crbRecordCtr;
	private long crbProcessDate;
	private String crbOperationCode;
	private String crbKeyText;
	private String crbInstCode;
	private String crbInsPrimaryCurrencyCode;
	private int crbCommitPendingIndicator;
	private String crbOperationSystemCode;
	private int crbResultCode;

	private String crbCompressIndicator;
	private String crbEngycptIndicator;
	private long crbTraceNumber;
	private String crbUserInfo;
	private long crbLength;

	// for distribute system logging usage
	private String className;
	private String packageName;
	private String methodName;
	private int pidNumber;
	private long startTime;
	private long endTime;
	public String txnSource;
	public String txnChannel;
	public String txnNetwork;

	public TxnMsgHead() {
		long id = IdUtils.get();
		this.crbTraceNumber = id;
		this.crbDescription = "*I*S*A";
		//this.startTime = 
		//System.out.println("traceNumber: " + crbTraceNumber);
	}

	public String getCrbDescription() {
		return crbDescription;
	}

	public void setCrbDescription(String crbDescription) {
		this.crbDescription = crbDescription;
	}

	public long getCrbProcessDate() {
		return crbProcessDate;
	}

	public void setCrbProcessDate(long crbProcessDate) {
		this.crbProcessDate = crbProcessDate;
	}

	public String getCrbOperationCode() {
		return crbOperationCode;
	}

	public void setCrbOperationCode(String crbOperationCode) {
		this.crbOperationCode = crbOperationCode;
	}

	public String getCrbKeyText() {
		return crbKeyText;
	}

	public void setCrbKeyText(String crbKeyText) {
		this.crbKeyText = crbKeyText;
	}

	public String getCrbInstCode() {
		return crbInstCode;
	}

	public void setCrbInstCode(String crbInstCode) {
		this.crbInstCode = crbInstCode;
	}

	public String getCrbInsPrimaryCurrencyCode() {
		return crbInsPrimaryCurrencyCode;
	}

	public void setCrbInsPrimaryCurrencyCode(String crbInsPrimaryCurrencyCode) {
		this.crbInsPrimaryCurrencyCode = crbInsPrimaryCurrencyCode;
	}
	
	public String getCrbCompressIndicator() {
		return crbCompressIndicator;
	}

	public void setCrbCompressIndicator(String crbCompressIndicator) {
		this.crbCompressIndicator = crbCompressIndicator;
	}

	public String getCrbEngycptIndicator() {
		return crbEngycptIndicator;
	}

	public void setCrbEngycptIndicator(String crbEngycptIndicator) {
		this.crbEngycptIndicator = crbEngycptIndicator;
	}

	public long getCrbLength() {
		return crbLength;
	}

	public void setCrbLength(long crbLength) {
		this.crbLength = crbLength;
	}

	public long getCrbRecordCtr() {
		return crbRecordCtr;
	}

	public void setCrbRecordCtr(long crbRecordCtr) {
		this.crbRecordCtr = crbRecordCtr;
	}

	public long getCrbTraceNumber() {
		return crbTraceNumber;
	}

	public void setCrbTraceNumber(long crbTraceNumber) {
		TRACE_ID.set(crbTraceNumber);
		this.crbTraceNumber = crbTraceNumber;
	}

	public String getCrbUserInfo() {
		return crbUserInfo;
	}

	public void setCrbUserInfo(String crbUserInfo) {
		this.crbUserInfo = crbUserInfo;
	}

	public static ThreadLocal<Long> getTRACE_ID() {
		return TRACE_ID;
	}

	public static void setTRACE_ID(ThreadLocal<Long> tRACE_ID) {
		TRACE_ID = tRACE_ID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public int getPidNumber() {
		return pidNumber;
	}

	public void setPidNumber(int pidNumber) {
		this.pidNumber = pidNumber;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getTxnSource() {
		return txnSource;
	}

	public void setTxnSource(String txnSource) {
		this.txnSource = txnSource;
	}

	public String getTxnChannel() {
		return txnChannel;
	}

	public void setTxnChannel(String txnChannel) {
		this.txnChannel = txnChannel;
	}

	public String getTxnNetwork() {
		return txnNetwork;
	}

	public void setTxnNetwork(String txnNetwork) {
		this.txnNetwork = txnNetwork;
	}

	public int getCrbCommitPendingIndicator() {
		return crbCommitPendingIndicator;
	}

	public void setCrbCommitPendingIndicator(int crbCommitPendingIndicator) {
		this.crbCommitPendingIndicator = crbCommitPendingIndicator;
	}

	public String getCrbOperationSystemCode() {
		return crbOperationSystemCode;
	}

	public void setCrbOperationSystemCode(String crbOperationSystemCode) {
		this.crbOperationSystemCode = crbOperationSystemCode;
	}

	public int getCrbResultCode() {
		return crbResultCode;
	}

	public void setCrbResultCode(int crbResultCode) {
		this.crbResultCode = crbResultCode;
	}

}
