//	AUTHOR: MATTHEW CARROLL

package data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayStackTest {

	@Test
	void ArrayStackConstructorTest() {
		
		System.out.println("\n" + "ArrayStackConstructorTest:");
		
		ArrayStack stack = new ArrayStack();
		
		assertEquals(0, stack.size());
		assert(stack.isEmpty());
		
		System.out.println("The following stack should be empty: {" + stack + "}");
		
	}
	
	@Test
	void pushExceptionTest() {
		
		System.out.println("\n" + "pushExceptionTest:");
		
		ArrayStack stack = new ArrayStack();
		
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			stack.push(null);
		});
		
		System.out.println(e.getMessage());
		
	}
	
	@Test
	void pushTest() {
		
		System.out.println("\n" + "pushTest:");
		
		ArrayStack stack = new ArrayStack();
		
		stack.push('*');
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
		
		System.out.println("Stack(top to bottom order) after pushing one item: {" + stack + "}");
		
		stack.push('$');
		assertEquals(2, stack.size());
		
		System.out.println("Stack after pushing a second item: {" + stack + "}");
		
		stack.push('%');
		assertEquals(3, stack.size());
		
		System.out.println("Stack after pushing a third item: {" + stack + "}");
		
	}
	
	@Test
	void popExceptionTest() {
		
		System.out.println("\n" + "popExceptionTest:");
		
		ArrayStack stack = new ArrayStack();
		
		Exception e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			stack.pop();
		});
		
		System.out.println(e.getMessage());
		
	}
	
	@Test
	void popTest() {
		
		System.out.println("\n" + "popTest:");
		
		ArrayStack stack = new ArrayStack();
		
		stack.push(false);
		stack.push(false);
		stack.push(true);
		
		assertEquals(3, stack.size());
		
		System.out.println("Stack(top to bottom order) after pushing 3 items: {" + stack + "}");
		
		Object data = stack.pop();
		
		assertEquals(2, stack.size());
		assertEquals(true, data);
		
		System.out.println("Stack after popping the top value: {" + stack + "}");
		System.out.println("Data popped off the top of the stack: " + data);
		
	}
	
	@Test
	void peekExceptionTest() {
		
		System.out.println("\n" + "peekExceptionTest:");
		
		ArrayStack stack = new ArrayStack();
		
		Exception e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			stack.peek();
		});
		
		System.out.println(e.getMessage());
		
	}
	
	@Test
	void peekTest() {
		
		System.out.println("\n" + "peekTest:");
		
		ArrayStack stack = new ArrayStack();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		assertEquals(4, stack.size());
		
		System.out.println("Stack(top to bottom order) after pushing 4 items: {" + stack + "}");
		
		Object data = stack.peek();
		
		assertEquals(4, stack.size());
		assertEquals(40, data);
		
		System.out.println("Stack after peeking (should be the same) : {" + stack + "}");
		System.out.println("Data on the top of the stack found by peeking: " + data);
		
	}
	
	@Test
	void extendArraySizeTest() {
		
		System.out.println("\n" + "extendArraySizeTest:");
		
		ArrayStack stack = new ArrayStack();
		
		for (int i = 10; i <= 100; i += 10)
			stack.push(i);
		
		assertEquals(10, stack.size());
		
		System.out.println("Stack(top to bottom order) after pushing numbers 10 to 100: {" + stack + "}");
		
		stack.push(110);
		
		assertEquals(11, stack.size());
		
		System.out.println("Stack after pushing the 11th item: {" + stack + "}");
		
	}

}
