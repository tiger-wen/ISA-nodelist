package com.david.study.sample.crud;

import com.david.study.sample.entity.SampleEntity2;
import com.david.study.sample.entity.SampleEntity2Mapper;
import com.david.study.sample.message.TxnMsg;
import com.david.study.sample.node.Node;
import com.david.study.sample.node.NodeList;
import com.david.study.sample.utils.EntityConstants;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public class SampleEntity2CRUD extends AbstractEntityCRUD  {
	
	private static NodeList<SampleEntity2> node2List = new NodeList<>();
	private static SampleEntity2Mapper nd2m = new SampleEntity2Mapper();
	private static String[] dgpkeys = {null,null};
	
	public NodeList<SampleEntity2> getDGPList() {
		return node2List;	
	}
	
	@SuppressWarnings("unchecked")
	public <T> void select(TxnMsg<T> txnmsg) {
		//NodeStatus ns = new NodeStatus();
		
		//boolean fnd = beforeAction(txnmsg,Constants.SAMPLEENTITY2,node2List);
		boolean fnd = beforeSelect(txnmsg,EntityConstants.SAMPLEENTITY2,dgpkeys,this.getDGPList());
		
		if (!fnd) {
		
			String i = txnmsg.getTxnmsghead().getCrbKeyText();
			SampleEntity2 test = nd2m.selectByPrimaryKey(i);

			//node2List.add(test);
			//txnmsg.getTxnmsgresults().add((T) test);
			//System.out.println(node2List.toString());
			
			afterSelect(txnmsg,EntityConstants.SAMPLEENTITY2,dgpkeys,(T) test);
			
		}
	}

	@Override
	public <T> void doCommit(Node<T> current) {
		System.out.println("SampleEntity2 commit processing");
		
	}
}
