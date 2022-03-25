//	AUTHOR: MATTHEW CARROLL

/*
 * QUEUE INTERFACE
 * 
 * USED TO SPECIFY IMPLEMENTATION OF ARRAY QUEUES AND LINKED QUEUES
 */

package interfaces;

public interface Queue extends Collection {

	//	Enqueue data into the back of the queue
	public void enqueue(Object data);
	
	//	Dequeue data from the front of the queue
	public Object dequeue();
	
	//	Check the data at the front of the queue
	public Object front();
}
