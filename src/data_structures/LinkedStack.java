//	AUTHOR: MATTHEW CARROLL

package data_structures;

import interfaces.Stack;
import nodes.LinkedNode;

public class LinkedStack implements Stack {

	private int size;
	private LinkedNode top;
	
	public LinkedStack() {
		size = 0;
		top = null;
	}
	
	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return size == 0; }

	@Override
	public void push(Object data) {
		
		if (data == null)
			throw new IllegalArgumentException("Data cannot be null");
		
		LinkedNode node = new LinkedNode(data);
		
		node.setNext(top);
		top = node;
		
		size++;
		
	}

	@Override
	public Object pop() {

		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("Cannot pop from an empty stack");
		
		LinkedNode node = top;
		top = node.getNext();
		
		size--;
		
		return node.getValue();
		
	}

	@Override
	public Object peek() {
		
		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("Cannot peek an empty stack");
		
		return top.getValue();
	}
	
	@Override
	public String toString() {
		
		String str = "";
		
		LinkedNode curr = top;
		while(curr != null){
			str += curr + ",";
			curr = curr.getNext();
		}
		
		return str;
		
	}

}
