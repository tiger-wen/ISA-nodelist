package com.david.study.sample.crud;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.david.study.sample.message.TxnMsg;
import com.david.study.sample.message.TxnMsgHead;
import com.david.study.sample.node.Node;
import com.david.study.sample.node.NodeList;
import com.david.study.sample.node.NodeStatus;
import com.david.study.sample.node.NodeStatusField;
import com.david.study.sample.utils.DGPConstants;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public abstract class AbstractEntityCRUD {

	// String[] value = { null, null };
	public NodeStatus ns = new NodeStatus();

	public boolean parmChk(TxnMsgHead commonMsg) {
		System.out.println("The input parm check here!");
		return true;
	}

	public boolean selectCheck() {
		// TODO Auto-generated method stub
		System.out.println("The select check here!");
		return false;
	}

	public boolean updateChk() {
		// TODO Auto-generated method stub
		System.out.println("The update check here!");
		return false;
	}

	public boolean deleteChk() {
		// TODO Auto-generated method stub
		System.out.println("The delete check here!");
		return false;
	}

	public boolean insertChk() {
		// TODO Auto-generated method stub
		System.out.println("The insert check here!");
		return false;
	}

	/*
	 * add the get data group to the current node list
	 */
	public <T> void addToNode(TxnMsg<T> txnmsg) {

		// txnmsg.getTxnmsgnodelist().add(txnmsg.getTxnmsgresults().tail.nodedata);
		// txnmsg.getTxnmsgresults().add(txnmsg.data);

		txnmsg.getTxnmsgcommitlist().add(txnmsg.getTxnmsgresults().tail);

	}

	@Deprecated
	public <T> void init(TxnMsg<T> txnmsg, String type) {

		// if (!txnmsg.mapv.containsKey(type)) {
		// value[0] = null;
		// value[1] = null;

		// txnmsg.mapv.put(type, value);
		// }
	}

	/*
	 * 
	 */
	@Deprecated
	public <T> void updateKey(TxnMsg<T> txnmsg, String type) {
		// int bl;

		// String[] high = null; //txnmsg.mapv.get(type);
		// String str1 = txnmsg.getTxnmsgarg().getCrbKeyText();

		// if ((high[0] == null) | (high[1] == null)) {
		// value[0] = str1;
		// value[1] = str1;
		// //txnmsg.mapv.put(type, value);
		// } else {
		// bl = str1.compareTo(high[0]);
		// //if (bl > 0)
		// // txnmsg.mapv.get(type)[0] = str1;

		// bl = str1.compareTo(high[1]);
		// //if (bl < 0)
		// // txnmsg.mapv.get(type)[1] = str1;
		// }

	}

	/*
	 * 
	 */
	public <T> void updateKey(String keys, String[] string) {
		int bl;

		if ((string[0] == null) | (string[1] == null)) {
			string[0] = keys;
			string[1] = keys;

		} else {
			bl = keys.compareTo(string[0]);
			if (bl > 0)
				string[0] = keys;

			bl = keys.compareTo(string[1]);
			if (bl < 0)
				string[1] = keys;
		}

	}

	/*
	 * 
	 */
	@SuppressWarnings("unchecked")
	public <T> boolean beforeSelect(TxnMsg<T> txnmsg, String type, String[] string, NodeList<?> list) {

		int bl;
		String keytxt = txnmsg.getTxnmsghead().getCrbKeyText();

		// init(txnmsg, type);

		// if (!txnmsg.maps.containsKey(type))
		// txnmsg.maps.put(type, list);

		// list = txnmsg.maps.get(type);
		txnmsg.setTxnmsgresults((NodeList<T>) list);
		// System.out.println("keytxt:" + keytxt + "High:" + string[0] + "Low :" +
		// string[1]);

		if (string[0] == null || string[1] == null)
			return false;

		bl = keytxt.compareTo(string[0]);
		if (bl > 0)
			return false;

		bl = keytxt.compareTo(string[1]);
		if (bl < 0)
			return false;

		Node<T> t = txnmsg.getTxnmsgresults().search(keytxt);
		if (t != null) {
			// txnmsg.getTxnmsgresults().current.nodedata = t.nodedata;
			// System.out.println("Find "+ txnmsg.getTxnmsgarg().getCrbKeyText() + " in node
			// list! " + t.nodedata.toString());
			return true;

		} else {
			return false;
		}

	}

	/*
	 * before insert
	 */
	public <T> void afterSelect(TxnMsg<T> txnmsg, String type, String[] string, T data) {

		String keys = null;

		txnmsg.getTxnmsgresults().add(data);

		keys = txnmsg.getTxnmsghead().getCrbKeyText();
		setDGPStatus(txnmsg, type);

		updateKey(keys, string);

		initDGPFieldsStatus(txnmsg, data);
		addToNode(txnmsg);

	}


	/*
	 * before insert
	 */
	public <T> void afterInsert(TxnMsg<T> txnmsg, String type, String[] string, T data) {

		String keys = null;
		keys = txnmsg.getTxnmsghead().getCrbKeyText();
		
		ns = txnmsg.getTxnmsgcalling().tail.nodestatus;
		ns.setDgpdatacondition(DGPConstants.DGP_DATA_INSERT);
		ns.setDgpstatuscondition(DGPConstants.DGP_USEING);
		ns.setDgpentitydescription(type);
		ns.setDgpentityidentity(type);

		txnmsg.setTxnmsgresults(txnmsg.getTxnmsgresults());
		txnmsg.getTxnmsgresults().add(txnmsg.getTxnmsgcalling().tail);
		txnmsg.getTxnmsgresults().tail.nodestatus = ns;
		
		updateKey(keys, string);
		addToNode(txnmsg);
		
		txnmsg.setTxnmsgcalling(null);

	}

	
	/*
	 * 
	 */
	public <T> void setDGPStatus(TxnMsg<T> txnmsg, String type) {

		String keys = txnmsg.getTxnmsghead().getCrbKeyText();
		
		txnmsg.getTxnmsgresults().tail.datakey = keys;

		ns.dgpentitydescription = type;
		ns.dgpentityidentity = type;
		ns.dgpstatuscondition = DGPConstants.DGP_USEING;
		ns.dgpdatacondition = DGPConstants.DGP_DATA_READ;
		ns.dgpinsertcondition = DGPConstants.DGP_FALSE;
		ns.dgpupdatecondition = DGPConstants.DGP_FALSE;
		ns.dgpreadcondition = DGPConstants.DGP_FALSE;

		txnmsg.getTxnmsgresults().tail.nodestatus = ns;

		// System.out.println("The Key is:" + p.two.tail.key + p.two.tail.nodedata);
	}

	public <T> void initDGPFieldsStatus(TxnMsg<T> txnmsg, Object obj) {

		Class<?> clazz = obj.getClass();
		Object value = null;
		NodeStatusField nsf = new NodeStatusField();

		nsf.setFieldAmmendIndicator(DGPConstants.DGP_FALSE);
		nsf.setFieldDisplayCodition(DGPConstants.DGP_FALSE);
		// nsf.setFieldNullIndicator(0);
		nsf.setFieldUpdateCondition(DGPConstants.DGP_FALSE);
		nsf.setFieldResultCode(DGPConstants.DGP_FALSE);

		for (Field field : clazz.getDeclaredFields()) {

			String fieldname = field.getName();
			String firstletter = fieldname.substring(0, 1).toUpperCase();
			String getter = "get" + firstletter + fieldname.substring(1);

			try {
				Method method = clazz.getMethod(getter, new Class[] {});
				value = method.invoke(obj, new Object[] {});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (null == value)
				nsf.setFieldNullIndicator(DGPConstants.DGP_TRUE);
			txnmsg.getTxnmsgresults().tail.nodestatus.fieldStatus.put(field.getName(), nsf);

		}

	}

	
	/*
	 * before insert
	 */
	public <T> void commit(TxnMsg<T> txnmsg) {
		
		Node<T> head,current;
		
		head = txnmsg.getTxnmsgcommitlist().head;
		if (head == null);
		
		current = head;
		while (current.nextnode != null) {
					
			commitCheck(current);
			current = current.nextnode;
		}
		ns = current.nodestatus;
		commitCheck(current);

		//System.out.println(ns.toString() + "?" + current.datakey + "?" + current.nodedata.toString());
		
	}

	public <T> void commitCheck(Node<T> current) {

		NodeStatus ns = null;
		ns = current.nodestatus;
				
		if (ns.getDgpstatuscondition()  == DGPConstants.DGP_USEING) {
			if ((ns.getDgpdatacondition() == DGPConstants.DGP_DATA_INSERT) |
				(ns.getDgpdatacondition() == DGPConstants.DGP_DATA_UPDATE) ) {

				doCommit(current);
								
			}
		}
		ns.setDgpstatuscondition(DGPConstants.DGP_AVAILABLE);

	}


	public <T> void callinglist(TxnMsg<T> txnmsg, Node<T> node) {
		
		if (null == txnmsg.getTxnmsgcalling()) {
			txnmsg.setTxnmsgcalling(new  NodeList<>());
		}
		
		txnmsg.getTxnmsgcalling().add(node);
		//txnmsg.getTxnmsgcalling().tail.nodestatus = ns;
		
	}	
	
	public abstract <T> void doCommit(Node<T> current);

	//public abstract <T> void insert(TxnMsg<T> txnmsg);

}
