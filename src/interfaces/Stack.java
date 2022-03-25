//	AUTHOR: MATTHEW CARROLL

/*
 * STACK INTERFACE
 * 
 * USED TO SPECIFY IMPLEMENTATION OF ARRAY STACKS AND LINKED STACKS
 */

package interfaces;

public interface Stack extends Collection {

	//	Push data to the top of the stack
	public void push(Object data);
	
	//	Return and remove data at the top of the stack
	public Object pop();
	
	//	Peek at the data at the top of the stack
	public Object peek();
	
}
