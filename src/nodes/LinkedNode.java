//	AUTHOR: MATTHEW CARROLL

/*
 * LINKEDNODE
 * 
 * MODIFIED NODE THAT INCLUDES A REFERENCE TO THE NEXT NODE
 * USED IN LINKED-TYPE DATA STRUCTURES
 */

package nodes;

public class LinkedNode extends Node{

	private LinkedNode next;
	
	public LinkedNode(Object value) {
		super(value);
	}
	
	public void setNext(LinkedNode next) {
		this.next = next;
	}
	
	public LinkedNode getNext() {
		return this.next;
	}
	
}
