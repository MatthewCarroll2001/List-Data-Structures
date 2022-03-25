//	AUTHOR: MATTHEW CARROLL

package data_structures;

import interfaces.ArrayType;
import interfaces.List;
import nodes.Node;

public class ArrayList implements List, ArrayType {

	public final int DEFAULT_CAPACITY = 10;
	
	private Node[] array;
	private int size;
	
	public ArrayList() {
		array = new Node[DEFAULT_CAPACITY];
		size = 0;
	}
	
	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return size == 0; }
	
	@Override
	public void add(Object data) {
		
		if (data == null)
			throw new IllegalArgumentException("Object data cannot be null");
		
		Node node = new Node(data);
		
		if (size == array.length)
			extendArraySize();
		
		array[size] = node;
		size++;
	}
	
	@Override
	public void add(Object data, int index) {
		
		if (data == null)
			throw new IllegalArgumentException("Object data cannot be null");
		
		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("No elements in the ArrayList to remove");
		else if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException("Index out of bounds of the ArrayList");
		
		Node node = new Node(data);
		
		if (size == array.length)
			extendArraySize();
		
		if (index < size)
			for (int i = size; i > index; i--)
				array[i] = array[i - 1];
		
		array[index] = node;
		size++;
	}

	@Override
	public void remove(int index) {
		
		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("No elements in the ArrayList to remove");
		else if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("Index out of bounds of the ArrayList");

		array[index] = null;
		
		if (index < size - 1)
			for (int i = index; i < size - 1; i++)
				array[i] = array[i + 1];
		
		size--;
	}

	@Override
	public Object get(int index) {

		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException("No elements in the ArrayList to get");
		else if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("Index out of bounds of the ArrayList");
		
		return array[index].getValue();
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
		
		for (int i = 0; i < size(); i++)
			str += array[i] + ",";
		
		return str;
	}

}
