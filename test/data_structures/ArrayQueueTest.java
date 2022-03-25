//	AUTHOR: MATTHEW CARROLL

package data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayQueueTest {

	@Test
	void ArrayQueueConstructorTest() {
		
		System.out.println("\n" + "ArrayQueueConstructorTest:");
		
		ArrayQueue queue = new ArrayQueue();
		
		//	Check that queue is instantiated as empty
		assertEquals(0, queue.size());
		assert(queue.isEmpty());
		
		System.out.println("The following queue should be empty: {" + queue + "}");
	
	}
	
	@Test
	void enqueueExceptionTest() {
		
		System.out.println("\n" + "enqueueExceptionTest:");
		
		ArrayQueue queue = new ArrayQueue();
		
		//	Check for when null data is passed through
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			queue.enqueue(null);
		});
		
		System.out.println(e.getMessage());
	
	}
	
	@Test
	void enqueueTest() {
		
		System.out.println("\n" + "enqueueTest:");
		
		ArrayQueue queue = new ArrayQueue();
		
		//	Queue a few people and make sure they are added in order
		queue.enqueue("Mom");
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
		
		System.out.println("Queue(front to back) after enqueueing my mother into the line: {" + queue + "}");
		
		queue.enqueue("Dad");
		assertEquals(2, queue.size());
		
		System.out.println("Queue after enqueueing my father next: {" + queue + "}");
		
		queue.enqueue("Brother");
		assertEquals(3, queue.size());
		
		System.out.println("Queue after enqueueing my brother so he has to wait in the back of the line: {" + queue + "}");
	
	}
	
	@Test
	void dequeueExceptionTest() {
		
		System.out.println("\n" + "dequeueExceptionTest:");
		
		ArrayQueue queue = new ArrayQueue();
		
		//	Check to make sure dequeueing cannot happen with an empty queue
		Exception e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			queue.dequeue();
		});
		
		System.out.println(e.getMessage());
	
	}
	
	@Test
	void dequeueTest() {
		
		System.out.println("\n" + "dequeueTest:");
		
		ArrayQueue queue = new ArrayQueue();
		
		//	Check to make sure that the front of the line (printed front to back order)
		//		is removed after dequeueing (should be the opposite side to enqueueing)
		queue.enqueue("Dog");
		queue.enqueue("Cat");
		queue.enqueue("Rooster");
		queue.enqueue("George");
		assertEquals(4, queue.size());
		
		System.out.println("Queue(front to back) after enqueueing some beings: {" + queue + "}");
		
		Object data = queue.dequeue();
		assertEquals(3, queue.size());
		assertEquals("Dog", data);
	
		System.out.println("Queue after dequeueing the front most item: {" + queue + "}");
		System.out.println("Data dequeued: " + data);
		
	}
	
	@Test
	void frontExceptionTest() {
		
		System.out.println("\n" + "frontExceptionTest:");
		
		ArrayQueue queue = new ArrayQueue();
		
		//	Check to make sure the front cannot be checked for an empty queue
		Exception e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			queue.front();
		});
		
		System.out.println(e.getMessage());
	
	}
	
	@Test
	void frontTest() {
		
		System.out.println("\n" + "frontTest:");
		
		ArrayQueue queue = new ArrayQueue();
		
		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(6);
		queue.enqueue(8);
		queue.enqueue(10);
		assertEquals(5, queue.size());
		
		System.out.println("Queue after enqueueing 5 even numbers: {" + queue + "}");
		
		Object data = queue.front();
		assertEquals(5, queue.size());
		assertEquals(2, data);
		
		//	Queue should not change after a front check and front item should be returned after method call
		System.out.println("Queue after checking the front(should be the same): {" + queue + "}");
		System.out.println("Front item: " + data);
		
	}
	
	@Test
	void extendArraySizeTest() {
		
		System.out.println("\n" + "extendArraySizeTest:");
		
		ArrayQueue queue = new ArrayQueue();
		
		for (int i = 0; i < 10; i++)
			queue.enqueue("Item " + (i + 1));
		assertEquals(10, queue.size());
	
		System.out.println("Queue after adding 10 items (max default size): {" + queue + "}");
		
		//	Queue should automatically update its array size once an 11th item is added
		queue.enqueue("Item 11");
		assertEquals(11, queue.size());
		
		System.out.println("Queue with 11th line added (queue should expand to accomodate): {" + queue + "}");
		
	}

}
