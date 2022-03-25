//	AUTHOR: MATTHEW CARROLL

/*
 * LIST INTERFACE
 * 
 * USED TO SPECIFY IMPLEMENTATION OF ARRAY LISTS AND LINKED LISTS
 */

package interfaces;

public interface List extends Collection {
	
	//	Add data to end of list
	public void add(Object data);
	
	//	Add data into a specific index of list
	public void add(Object data, int index);
	
	//	Remove data from list at given index
	public void remove(int index);
	
	//	Get data at index
	public Object get(int index);
	
}
