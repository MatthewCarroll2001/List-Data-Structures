//	AUTHOR: MATTHEW CARROLL

package data_structures;

import interfaces.ArrayType;
import interfaces.Queue;
import nodes.Node;

public class ArrayQueue implements Queue, ArrayType {

	private final int DEFAULT_CAPACITY = 10;
	
	private Node[] array;
	private int size;
	
	public ArrayQueue() {
		size = 0;
		array = new Node[DEFAULT_CAPACITY];
	}
	
	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return size == 0; }

	@Override
	public void enqueue(Object data) {

		if (data == null)
			throw new IllegalArgumentException("Data cannot be null");
		
		Node node = new Node(data);
		
		if (size == array.length)
			extendArraySize();
		
		for (int i = size; i > 0; i--)
			array[i] = array[i - 1];
		
		array[0] = node;
		size++;
	}

	@Override
	public Object dequeue() {

		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("Cannot dequeue from an empty queue");
		
		Node node = array[size - 1];
		array[size - 1] = null;
		size--;
		
		return node.getValue();
	}

	@Override
	public Object front() {

		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("Cannot dequeue from an empty queue");
		
		return array[size - 1].getValue();
	}

	@Override
	public void extendArraySize() {

		Node[] temp = new Node[array.length * 2];
		for (int i = 0; i < array.length; i++)
			temp[i] = array[i];
		
		array = temp;
	}
	
	@Override
	public String toString() {
		
		String str = "";
		
		for (int i = size - 1; i >= 0; i--)
			str += array[i] + ",";
		
		return str;
	}

}
