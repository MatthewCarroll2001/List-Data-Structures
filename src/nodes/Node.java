//	AUTHOR: MATTHEW CARROLL

/*
 * NODE
 * 
 * GENERIC NODE FOR HOLDING A GENERALIZED OBJECT VALUE
 * FOR USE IN ARRAY-TYPE DATA STRUCTURES
 */

package nodes;

public class Node {

	private Object value;
	
	public Node(Object value) {
		this.value = value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	public String toString() {
		return value.toString();
	}
	
}
