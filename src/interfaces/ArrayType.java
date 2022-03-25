//	AUTHOR: MATTHEW CARROLL

/*
 * ARRAYTYPE INTERFACE
 * 
 * FUNCTIONAL INTERFACE TO MAKE SURE EVERY ARRAY TYPE COLLECTION CAN
 * EXPAND ITS ARRAY SIZE WHEN IT BECOMES FULL
 */

package interfaces;

@FunctionalInterface
public interface ArrayType {

	//	For array based data structures, a required method for when 
	//	the stored array reaches its maximum size
	public void extendArraySize();
	
}
