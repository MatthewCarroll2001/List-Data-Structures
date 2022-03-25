//	AUTHOR: MATTHEW CARROLL

package data_structures;

import interfaces.ArrayType;
import interfaces.Stack;
import nodes.Node;

public class ArrayStack implements Stack, ArrayType {

	public final int DEFAULT_CAPACITY = 10;
	
	private Node[] array;
	private int top;
	
	public ArrayStack() {
		array = new Node[DEFAULT_CAPACITY];
		top = 0;
	}
	
	@Override
	public int size() { return top; }

	@Override
	public boolean isEmpty() { return top == 0; }

	@Override
	public void push(Object data) {
		
		if (data == null)
			throw new IllegalArgumentException("Data cannot be null");
		
		if (top == array.length)
			extendArraySize();
		
		Node node = new Node(data);
		
		array[top] = node;
		
		top++;
	}

	@Override
	public Object pop() {

		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("Cannot pop an empty stack");
		
		Node node = array[top - 1];
		array[top - 1] = null;
		
		top--;
		
		return node.getValue();
		
	}

	@Override
	public Object peek() {
		
		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("Cannot peek an empty stack");
		
		return array[top - 1].getValue();
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
		
		for (int i = size() - 1; i >= 0; i--)
			str += array[i] + ",";
		
		return str;
	}

}
