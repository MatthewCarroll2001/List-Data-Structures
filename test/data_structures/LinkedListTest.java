//	AUTHOR: MATTHEW CARROLL

package data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void LinkedListConstructorTest() {

		System.out.println("\n" + "LinkedListConstructorTest:");
		
		LinkedList list = new LinkedList();
		
		//	Ensure that the newly created list is empty
		assertEquals(0, list.size());
		assert(list.isEmpty());
		
		System.out.println("The following list should be empty: {" + list + "}");
		
	}
	
	@Test
	void addExceptionTest() {

		System.out.println("\n" + "addExceptionTest:");
		
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		//	Cannot add null values
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
			list.add(null);
		});
		
		//	No negative indexes
		Exception e2 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			list.add(4, -1);
		});
		
		//	Cannot reach outside of list bounds
		Exception e3 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			list.add(4, 4);
		});
		
		System.out.println(e1.getMessage());
		System.out.println(e2.getMessage());
		System.out.println(e3.getMessage());
		
	}
	
	@Test
	void addTest() {

		System.out.println("\n" + "addTest:");
		
		LinkedList list = new LinkedList();
		
		assertEquals(0, list.size());
		assert(list.isEmpty());
		
		//	Add values progressively to the list
		list.add('X');
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		
		System.out.println("List after adding 'X' to empty list: {" + list + "}");
		
		list.add('Y');
		assertEquals(2, list.size());
		
		System.out.println("List after adding 'Y': {" + list + "}");
		
	}
	
	@Test
	void addWithIndexTest() {

		System.out.println("\n" + "addWithIndexTest:");
		
		LinkedList list = new LinkedList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		assertEquals(3, list.size());
		
		System.out.println("List after adding three numbers: {" + list + "}");
		
		//	Add items into the middle of the list
		list.add(1.5, 1);
		list.add(2.5, 3);
		
		assertEquals(5, list.size());
		assertEquals(1.5, list.get(1));
		assertEquals(2.5, list.get(3));
		
		System.out.println("List after adding 1.5 and 2.5 in order: {" + list + "}");
		
	}
	
	@Test
	void removeExceptionTest() {

		System.out.println("\n" + "removeExceptionTest:");
		
		LinkedList list = new LinkedList();
		
		list.add(1);
		list.add(2);
		
		//	Cannot remove from a negative index
		Exception e1 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			list.remove(-1);
		});
		
		//	Cannot remove an item farther than the end of the list
		Exception e2 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			list.remove(2);
		});
		
		System.out.println(e1.getMessage());
		System.out.println(e2.getMessage());
		
	}
	
	@Test
	void removeTest() {

		System.out.println("\n" + "removeTest:");
		
		LinkedList list = new LinkedList();
		
		list.add(true);
		list.add(false);
		list.add("North Carolina");
		
		assertEquals(3, list.size());
		
		System.out.println("List after three values are added: {" + list + "}");
		
		//	Remove item at first index
		list.remove(0);
		
		assertEquals(false, list.get(0));
		assertEquals("North Carolina", list.get(1));
		assertEquals(2, list.size());
		
		System.out.println("List after removing the first value: {" + list + "}");
		
	}

}
