package data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedQueueTest {

	@Test
	void LinkedQueueConstructorTest() {
		
		System.out.println("\n" + "LinkedQueueConstructorTest:");
		
		LinkedQueue queue = new LinkedQueue();
		
		//	Check that the queue is instantiated to be empty
		assertEquals(0, queue.size());
		assert(queue.isEmpty());
		
		System.out.println("The following queue should be empty: {" + queue + "}");
		
	}
	
	@Test
	void enqueueExceptionTest() {
		
		System.out.println("\n" + "enqueueExceptionTest:");
		
		LinkedQueue queue = new LinkedQueue();
		
		//	Check to make sure null values are not passed into the queue
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			queue.enqueue(null);
		});
		
		System.out.println(e.getMessage());
		
	}
	
	@Test
	void enqueueTest() {
		
		System.out.println("\n" + "enqueueTest:");
		
		LinkedQueue queue = new LinkedQueue();
		
		//	Periodically enqueue and check items into the queue
		queue.enqueue("Person 1");
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
		
		System.out.println("Queue(front to back order) after first person enqueued: {" + queue + "}");
		
		queue.enqueue("Person 2");
		assertEquals(2, queue.size());
		
		System.out.println("Queue after second person enqueued: {" + queue + "}");
		
		queue.enqueue("Person 3");
		assertEquals(3, queue.size());
		
		System.out.println("Queue after third person enqueued: {" + queue + "}");
		
	}
	
	@Test
	void dequeueExceptionTest() {
		
		System.out.println("\n" + "dequeueExceptionTest:");
		
		LinkedQueue queue = new LinkedQueue();
		
		//	Make sure that you cannot dequeue from an empty list
		Exception e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			queue.dequeue();
		});
		
		System.out.println(e.getMessage());
		
	}
	
	@Test
	void dequeueTest() {
		
		System.out.println("\n" + "dequeueTest:");
		
		LinkedQueue queue = new LinkedQueue();
		
		//	Enqueue false and then a bunch of truth values, then dequeue just the false value in the front
		queue.enqueue(false);
		queue.enqueue(true);
		queue.enqueue(true);
		queue.enqueue(true);
		assertEquals(4, queue.size());
		
		System.out.println("Queue after enqueueing some true or false values: {" + queue + "}");
		
		Object data = queue.dequeue();
		assertEquals(3, queue.size());
		assertEquals(false, data);
		
		System.out.println("Queue after dequeueing the front value: {" + queue + "}");
		System.out.println("Value dequeued: " + data);
		
	}
	
	@Test
	void frontExceptionTest() {
		
		System.out.println("\n" + "frontExceptionTest:");
		
		LinkedQueue queue = new LinkedQueue();
		
		//	Make sure that an empty queue cannot be checked for its front value
		Exception e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			queue.front();
		});
		
		System.out.println(e.getMessage());
		
	}
	
	@Test
	void frontTest() {
		
		System.out.println("\n" + "frontTest:");
		
		LinkedQueue queue = new LinkedQueue();
		
		//	Check a queue to make sure after peeking the front that the
		//		queue is the same and the front value is returned
		queue.enqueue('Q');
		queue.enqueue('U');
		queue.enqueue('E');
		queue.enqueue('U');
		queue.enqueue('E');
		assertEquals(5, queue.size());
		
		System.out.println("Queue after queueing each letter of queue: {" + queue + "}");
		
		Object data = queue.front();
		assertEquals(5, queue.size());
		assertEquals('Q', data);
		
		System.out.println("Queue still spelling queue: {" + queue + "}");
		System.out.println("First letter of queue: " + data);
		
	}

}
