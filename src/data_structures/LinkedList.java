//	AUTHOR: MATTHEW CARROLL

package data_structures;

import interfaces.List;
import nodes.LinkedNode;

public class LinkedList implements List {

	private int size;
	private LinkedNode start;
	private LinkedNode end;
	
	public LinkedList() {
		size = 0;
		start = null;
		end = null;
	}
	
	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return size == 0; }
	
	@Override
	public void add(Object data) {

		if (data == null)
			throw new IllegalArgumentException("Object data cannot be null");
		
		LinkedNode node = new LinkedNode(data);
		
		if (isEmpty()) {
			start = node;
			end = node;
		}
		else {
			end.setNext(node);
			end = node;
		}
		
		size++;
			
	}
	
	@Override
	public void add(Object data, int index) {

		if (data == null)
			throw new IllegalArgumentException("Object data cannot be null");
		else if (index < 0)
			throw new ArrayIndexOutOfBoundsException("Index cannot be less than zero");
		else if (index > size)
			throw new ArrayIndexOutOfBoundsException("Index cannot be greater than the next open slot in the list");
		
		LinkedNode node = new LinkedNode(data);
		
		if (index == 0) {
			node.setNext(start);
			start = node;
		}
		else if (index == size) {
			end.setNext(node);
			end = node;
		}
		else {
			LinkedNode prevNode = find(index - 1);
			
			node.setNext(prevNode.getNext());
			prevNode.setNext(node);
		}
		
		size++;
		
	}

	@Override
	public void remove(int index) {

		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("Cannot remove from an empty list");
		if (index < 0)
			throw new ArrayIndexOutOfBoundsException("Index cannot be less than zero");
		else if (index > size - 1)
			throw new ArrayIndexOutOfBoundsException("Index cannot be greater than the last item in the list");
		
		LinkedNode node = find(index);
		
		if (index == 0)
			start = node.getNext();
		else {
			LinkedNode prevNode = find(index - 1);
			prevNode.setNext(node.getNext());
		}

		size--;
		
	}

	@Override
	public Object get(int index) {

		if (index < 0)
			throw new ArrayIndexOutOfBoundsException("Index cannot be less than zero");
		else if (index >= size)
			throw new ArrayIndexOutOfBoundsException("Index out of bounds of array");
		
		LinkedNode curr = start;
		for (int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		
		return curr.getValue();
	}
	
	/*
	 * PRIVATE UTILITY METHOD FOR FINDING NODES IN A LINKED LIST
	 */
	private LinkedNode find(int index) {
		
		LinkedNode curr = start;
		for (int i = 0; i < index; i++)
			curr = curr.getNext();
		
		return curr;
	}
	
	@Override
	public String toString() {
		
		String str = "";
		
		LinkedNode curr = start;
		while (curr != null) {
			str += curr + ",";
			curr = curr.getNext();
		}
		
		return str;
	}
}
