package com.david.study.sample.node;

/**
 * @author A148830
 * @Version 2018-01-03
 * @param <T>
 */
public class Node<T> {
	
	public String datakey;
	public T nodedata;
	public Node<T> nextnode;
	public NodeStatus nodestatus;
	//Will be dealed with it in class NodeStatus instead.
	//public NodeStatusField nodestatusfield;
	
	public Node(T nd) {
		this.nodedata = nd;
	}

	@Override
	public String toString() {
		return "Node [nodedata=" + nodedata + "]";
	}

}
