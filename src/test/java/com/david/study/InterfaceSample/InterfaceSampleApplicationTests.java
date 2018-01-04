package com.david.study.InterfaceSample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.david.study.sample.crud.SampleEntity1CRUD;
import com.david.study.sample.entity.GenericEntity;
import com.david.study.sample.entity.SampleEntity1;
import com.david.study.sample.message.TxnMsg;
import com.david.study.sample.message.factory.TxnMsgFactory;
import com.david.study.sample.node.Node;
import com.david.study.sample.node.NodeList;
import com.david.study.sample.node.NodeStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceSampleApplicationTests {

	@Test
	public void contextLoads() {
		NodeList<GenericEntity> nodelist = new NodeList<>();
		TxnMsgFactory tf = new TxnMsgFactory();
		TxnMsg<?> txnmsg = tf.createTxnMsg();
		
		// Select testing
		txnmsg.getTxnmsghead().setCrbDescription("CRB");
		txnmsg.getTxnmsghead().setCrbKeyText("10");
		/*		
		System.out.println("11111111111111111111111111");
		SampleEntity1CRUD ndm1 = new SampleEntity1CRUD();
		txnmsg.getTxnmsghead().setCrbKeyText("1");
		ndm1.select(txnmsg);
		NodeStatus ns0 = txnmsg.getTxnmsgresults().tail.nodestatus;
		System.out.println(ns0.toString());

		Node<GenericEntity> n = (Node<GenericEntity>) txnmsg.getTxnmsgresults().tail;
		nodelist.add(n);
		System.out.println("Nodelist:");
		nodelist.listAll();

		txnmsg.getTxnmsghead().setCrbKeyText("9");
		ndm1.select(txnmsg);
		NodeStatus ns1 = txnmsg.getTxnmsgresults().tail.nodestatus;
		System.out.println(ns1.toString());

		txnmsg.getTxnmsghead().setCrbKeyText("1");
		ndm1.select(txnmsg);
		System.out.println("Result List:");
		txnmsg.getTxnmsgresults().listAll();

		System.out.println("22222222222222222222222222");
		SampleEntity2CRUD ndm2 = new SampleEntity2CRUD();
		
		txnmsg.getTxnmsghead().setCrbKeyText("A");
		ndm2.select(txnmsg);
		SampleEntity2CRUD ndm23 = new SampleEntity2CRUD();
		txnmsg.getTxnmsghead().setCrbKeyText("B");
		ndm23.select(txnmsg);
		SampleEntity2CRUD ndm22 = new SampleEntity2CRUD();		

		txnmsg.getTxnmsghead().setCrbKeyText("C");
		ndm22.select(txnmsg);
		
		NodeStatus ns = txnmsg.getTxnmsgresults().tail.nodestatus;
		System.out.println(ns.toString());
		//NodeList<SampleEntity2> nd = (NodeList<SampleEntity2>) txnmsg.getTxnmsgresults();
		txnmsg.getTxnmsgresults().listAll();
	
		System.out.println("--------------------------");
		txnmsg.getTxnmsgcommitlist().listAll();
		*/
		// Insert testing

		System.out.println("11111111111111111111111111");		
		SampleEntity1 sei = new SampleEntity1();
		NodeStatus nsi = new NodeStatus();
		
		sei.setNumber(10);
		sei.setString("Insert Testing");
		
		//NodeList<SampleEntity1> callinglist = null;
		Node<SampleEntity1> nn = new Node<>(sei);
		nn.datakey = "10";
		nn.nodestatus = nsi;
		//txnmsg.setTxnmsgcalling(new NodeList<>());
		//callinglist = (NodeList<SampleEntity1>) txnmsg.getTxnmsgcalling();
		//callinglist.add(nn);
		
		SampleEntity1CRUD ndm1 = new SampleEntity1CRUD();
		ndm1.createcallinglist(txnmsg,nn);
		txnmsg.getTxnmsgcalling().listAll();
		
		ndm1.insert(txnmsg);
		txnmsg.getTxnmsgresults().listAll();

		ndm1.commit(txnmsg);
		txnmsg.getTxnmsgcommitlist().listAll();
		
	}

}
