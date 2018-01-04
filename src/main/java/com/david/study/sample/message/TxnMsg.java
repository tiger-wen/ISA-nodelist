package com.david.study.sample.message;

import com.david.study.sample.node.NodeList;

/**
 * @author A148830
 * @Version 2018-01-03
 * @param <T>
 */
public class TxnMsg<T> {

	private TxnMsgHead txnmsghead;
	private TxnMsgArgument txnmsgarg;
	// the node list
	private NodeList<T> txnmsgcommitlist;
	// the calling list
	private NodeList<T> txnmsgcallinglist;
	// the result list
	private NodeList<T> txnmsgresultslist;
	//public T data;
	// each entity DGP list
	//public Map<String,NodeList<?>> maps;
	// All the same entity's highest key and lowest key
	//public Map<String,String[]> mapv;

	public TxnMsg(NodeList<T> p) {
		
		this.setTxnmsghead(new TxnMsgHead());
		this.setTxnmsgarg(new TxnMsgArgument());
		this.txnmsgcommitlist = p;
		this.txnmsgcallinglist = null;
		this.txnmsgresultslist = null;
		//maps = new HashMap<>();
		//mapv = new HashMap<>();
		
	}
	
	public TxnMsgHead getTxnmsghead() {
		return txnmsghead;
	}

	public void setTxnmsghead(TxnMsgHead txnmsghead) {
		this.txnmsghead = txnmsghead;
	}

	public TxnMsgArgument getTxnmsgarg() {
		return txnmsgarg;
	}

	public void setTxnmsgarg(TxnMsgArgument txnmsgarg) {
		this.txnmsgarg = txnmsgarg;
	}

	public NodeList<T> getTxnmsgcalling() {
		return txnmsgcallinglist;
	}

	public void setTxnmsgcalling(NodeList<T> txnmsgcalling) {
		this.txnmsgcallinglist = txnmsgcalling;
	}

	public NodeList<T> getTxnmsgresults() {
		return txnmsgresultslist;
	}

	public void setTxnmsgresults(NodeList<T> txnmsgresults) {
		this.txnmsgresultslist = txnmsgresults;
	}

	@Override
	public String toString() {
		return "TxnMsg [txnmsghead=" + txnmsghead + ", txnmsgarg=" + txnmsgarg + ", txnmsgcalling=" + txnmsgcallinglist
				+ ", txnmsgresults=" + txnmsgresultslist + "]";
	}

	public NodeList<T> getTxnmsgcommitlist() {
		return txnmsgcommitlist;
	}

	public void setTxnmsgcommitlist(NodeList<T> txnmsgcommitlist) {
		this.txnmsgcommitlist = txnmsgcommitlist;
	}
	
}
