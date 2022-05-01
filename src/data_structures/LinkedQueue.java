//	AUTHOR: MATTHEW CARROLL

package data_structures;

import interfaces.Queue;
import nodes.LinkedNode;

public class LinkedQueue implements Queue {

	int size;
	LinkedNode front;
	LinkedNode back;
	
	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return size == 0; }

	@Override
	public void enqueue(Object data) {
		
		if (data == null)
			throw new IllegalArgumentException("Data cannot be null");
		
		LinkedNode node = new LinkedNode(data);
		
		if (isEmpty())
			front = node;
		else
			back.setNext(node);
		back = node;
		
		size++;
	}

	@Override
	public Object dequeue() {

		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("Cannot dequeue from an empty queue");
		
		LinkedNode node = front;
		
		if (size == 1) {
			front = null;
			back = null;
		}
		else {
			front = front.getNext();
		}
		node.setNext(null);
		
		size--;
		return node.getValue();
	}

	@Override
	public Object front() {

		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("Cannot dequeue from an empty queue");
		
		return front.getValue();
		
	}
	
	@Override
	public String toString() {
		String str = "";
		
		LinkedNode curr = front;
		while (curr != null) {
			str += curr + ",";
			curr = curr.getNext();
		}
			
		return str;
	}

}
