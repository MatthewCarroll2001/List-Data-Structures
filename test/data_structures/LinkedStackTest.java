//	AUTHOR: MATTHEW CARROLL

package data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedStackTest {

	@Test
	void LinkedStackConstructorTest() {
		
		System.out.println("\n" + "LinkedStackConstructorTest:");
		
		LinkedStack stack = new LinkedStack();
		
		assertEquals(0, stack.size());
		assert(stack.isEmpty());
		
		System.out.println("The following stack should be empty: {" + stack + "}");
		
	}

	@Test
	void pushExceptionTest() {
		
		System.out.println("\n" + "pushExceptionTest:");
		
		LinkedStack stack = new LinkedStack();
		
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			stack.push(null);
		});
		
		System.out.println(e.getMessage());
		
	}
	
	@Test
	void pushTest() {
		
		System.out.println("\n" + "pushTest:");
		
		LinkedStack stack = new LinkedStack();
		
		stack.push(5);
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
		
		System.out.println("Stack after pushing 5 onto the top: {" + stack + "}");
		
		stack.push('C');
		stack.push("Roller Coaster");
		assertEquals(3, stack.size());
		
		System.out.println("Stack(top to bottom order) after pushing 'C' then Roller Coaster': {" + stack + "}");
		
	}
	
	@Test
	void popExceptionTest() {
		
		System.out.println("\n" + "popExceptionTest:");
		
		LinkedStack stack = new LinkedStack();
		
		Exception e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			stack.pop();
		});
		
		System.out.println(e.getMessage());
		
	}
	
	@Test
	void popTest() {
		
		System.out.println("\n" + "popTest:");
		
		LinkedStack stack = new LinkedStack();
		
		stack.push("Matthew");
		assertEquals(1, stack.size());
		
		System.out.println("Stack after pushing my name onto the top: {" + stack + "}");
		
		Object data = stack.pop();
		assertEquals(0, stack.size());
		assertEquals("Matthew", data);
		
		System.out.println("Empty stack after popping the top item: {" + stack + "}");
		System.out.println("Previous item popped of the top of the stack: " + data);
		
	}
	
	@Test
	void peekExceptionTest() {
		
		System.out.println("\n" + "peekExceptionTest:");
		
		LinkedStack stack = new LinkedStack();
		
		Exception e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			stack.peek();
		});
		
		System.out.println(e.getMessage());
		
	}
	
	@Test
	void peekTest() {
		
		System.out.println("\n" + "peekTest:");
		
		LinkedStack stack = new LinkedStack();
		
		stack.push(100);
		stack.push("Texas");
		stack.push(5000.6);
		assertEquals(3, stack.size());
		
		System.out.println("Stack(top to bottom order) after pushing three large items: {" + stack + "}");
		
		Object data = stack.peek();
		assertEquals(5000.6, data);
		
		System.out.println("Stack after peeking(should be the same): {" + stack + "}");
		System.out.println("Item on the top of the stack: " + data);
		
	}

}
