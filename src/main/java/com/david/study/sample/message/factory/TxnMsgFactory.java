package com.david.study.sample.message.factory;

import com.david.study.sample.entity.GenericEntity;
import com.david.study.sample.message.TxnMsg;
import com.david.study.sample.node.NodeList;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public class TxnMsgFactory {

	public TxnMsg<?> createTxnMsg() {
		
		NodeList<GenericEntity> commitlist = new NodeList<>();
		TxnMsg<?> msg = new TxnMsg<>(commitlist);
		return msg;
	}
	
}
