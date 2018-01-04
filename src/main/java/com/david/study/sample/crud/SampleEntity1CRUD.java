package com.david.study.sample.crud;

import com.david.study.sample.entity.SampleEntity1;
import com.david.study.sample.entity.SampleEntity1Mapper;
import com.david.study.sample.message.TxnMsg;
import com.david.study.sample.node.Node;
import com.david.study.sample.node.NodeList;
import com.david.study.sample.utils.DGPConstants;
import com.david.study.sample.utils.EntityConstants;
import com.david.study.sample.utils.ISAHeadConstant;
import com.david.study.sample.utils.StringUtils;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public class SampleEntity1CRUD extends AbstractEntityCRUD {

	// Singleton Lazy Pattern
	private static NodeList<SampleEntity1> node1List = new NodeList<>();
	private static SampleEntity1Mapper nd1m = new SampleEntity1Mapper();
	private static String[] dgpkeys = { null, null };
	public String key;

	public NodeList<SampleEntity1> getDGPList() {
		return node1List;
	}

	/*
	 * select table sample code
	 */
	@SuppressWarnings("unchecked")
	public <T> boolean select(TxnMsg<T> txnmsg) {

		key = txnmsg.getTxnmsghead().getCrbKeyText();
		// txnmsg.getTxnmsghead().setCrbOperationCode(crbOperationCode);

		boolean fnd = beforeSelect(txnmsg, EntityConstants.SAMPLEENTITY1, dgpkeys, this.getDGPList());

		if (!fnd) {

			int i = StringUtils.parseInteger(key);
			SampleEntity1 test = nd1m.selectByPrimaryKey(i);

			if (null != test) {
				afterSelect(txnmsg, EntityConstants.SAMPLEENTITY1, dgpkeys, (T) test);
				fnd = true;
			}
		}

		return fnd;
	}

	/*
	 * insert into a table sample code
	 */
	//@Override
	public <T> void insert(TxnMsg<T> txnmsg) {

		key = txnmsg.getTxnmsghead().getCrbKeyText();

		/*
		 * parm check process here
		 */
		if (null == txnmsg.getTxnmsgcalling()) {
			txnmsg.getTxnmsghead().setCrbResultCode(ISAHeadConstant.ISA_INVALID_CALLING_LIST);
			return;
		}

		// search if already exists
		boolean fnd = select(txnmsg);

		/*
		 * already existed.
		 */
		if (fnd) {
			txnmsg.getTxnmsghead().setCrbResultCode(ISAHeadConstant.ISA_ADD_ALREADY_FOUND);
			return;
		}

		/*
		 * business check and cross check process here
		 */
		insertChk();

		/*
		 * 
		 */
		// int i = StringUtils.parseInteger(txnmsg.getTxnmsghead().getCrbKeyText());
		SampleEntity1 test = (SampleEntity1) txnmsg.getTxnmsgcalling().tail.nodedata;

		afterInsert(txnmsg, EntityConstants.SAMPLEENTITY1, dgpkeys, (T) test);

	}

	public <T> void doCommit(Node<T> current) {
		
		String actioncode;
		
		actioncode = current.nodestatus.getDgpdatacondition();

		if (actioncode == DGPConstants.DGP_DATA_INSERT)
			System.out.println("SampleEntity1 INSERT processing");
		
		if (actioncode == DGPConstants.DGP_DATA_UPDATE) 
			System.out.println("SampleEntity1 UPDATE processing");
	
	}
	
	public <T> void createcallinglist(TxnMsg<T> txnmsg, Node<?> node) {
		Node<T> n = (Node<T>) node;
		super.callinglist(txnmsg, n);
	}

}
