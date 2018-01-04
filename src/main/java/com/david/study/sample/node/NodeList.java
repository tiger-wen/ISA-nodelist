package com.david.study.sample.node;

/**
 * @author A148830
 * @Version 2018-01-03
 * @param <T>
 */
public class NodeList<T> {

	public Node<T> head;
	public Node<T> tail;
	public Node<T> current;
	int size = 0;
	
	//private final NodeTList<T> nodelist = new NodeTList<>();
		
	//public NodeTList<T> getNodeTList(){
	//	return nodelist;
	//}

	/*
	 * scenario 1:the nodelist is emtpy scenario 2:the nodelist is not empty
	 */
	public void add(T data) {
		//super.add(data);

		Node<T> node = new Node<>(data);

		if (tail == null) {
			head = node;
			tail = node;
			current = tail;
		} else {
			tail.nextnode = node;
			tail = node;
			current = tail;
		}
		size++;

	}

	/*
	 * scenario 1:the nodelist is emtpy scenario 2:the nodelist is not empty
	 */
	public void add(Node<T> t) {
		//super.add(data);

		if (tail == null) {
			head = t;
			tail = t;
			current = tail;
		} else {
			tail.nextnode = t;
			tail = t;
			current = tail;
		}
		size++;

	}


	/*	
	 * the wanted delete node is the head the wanted delete node is the tail the
	 * wanted delete node is in the middle of the list the nodelist is empty the
	 * nodelist just have one node Please pay attention to this,It is very important
	 * here the return node is the nodelist's head node
*/	 
	public Node<T> remove(T data) {

		if (head == null) {
			current = null;
			return head;
		}

		if (head.nodedata == data) {
			if (head == tail) {
				head = null;
				tail = null;
				current = null;
				size = 0;
				return null;
			} else {
				head = head.nextnode;
				current = tail;
				return head;
			}
		}

		Node<T> node = this.search(data);
		Node<T> nodeprev = this.searchPrevious(data);

		if (null != nodeprev) {

			if (tail == nodeprev.nextnode) {
				nodeprev.nextnode = null;
				tail = nodeprev;

			} else {
				nodeprev.nextnode = node.nextnode;
			}
			size--;

		}
		current = tail;
		return head;
	}

	/*
	 *  find the previous node which contain 
	 *  the desired data in nodelist
	 */
	public Node<T> searchPrevious(T data) {
		if (head == null)
			return null;

		if (head.nodedata == data) {
			return head;
		}

		current = head;
		while (current.nextnode != null) {
			if (current.nextnode.nodedata == data) {
				return current;
			}
			current = current.nextnode;
		}
		return null;
	}

	/*
	 *  search for the 
	 */
	public Node<T> search(T data) {
		if (head == null)
			return null;

		if (head.nodedata == data)
			return head;

		current = head;
		while (current.nextnode != null) {
			current = current.nextnode;
			if (current.nodedata == data) {
				return current;
			}
		}
		return null;
	}

	/*
	 *  search for the 
	 */
	public Node<T> search(String data) {
		//System.out.println("NodeList: search nodelist");
		if (head == null)
			return null;

		if (head.datakey == data)
			return head;

		current = head;
		while (current.nextnode != null) {
			current = current.nextnode;
			if (current.datakey == data) {
				return current;
			}
		}
		return null;
	}
	
	/*
	 * List all the node data in nodelist
	 */
	public void listAll() {
		if (head == null);

		current = head;
		while (current.nextnode != null) {
			System.out.println(current.nodestatus.dgpentityidentity + " " + current.nodedata + " " + current.nodestatus);
			current = current.nextnode;
		}
		System.out.println(current.nodestatus.dgpentityidentity + " " + current.nodedata + " " + current.nodestatus);
	}

	
}
