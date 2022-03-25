//	AUTHOR: MATTHEW CARROLL

package data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayListTest {

	@Test
	void ArrayListConstructorTest() {

		System.out.println("\n" + "ArrayListConstructorTest:");
		
		//	Array should instantiate empty with a size of zero
		//	This will test both the size() and isEmpty() methods
		ArrayList list = new ArrayList();
		assertEquals(0, list.size());
		assert(list.isEmpty());
		
		System.out.println("The following list should be empty: {" + list + "}");
		
	}
	
	@Test
	void addExceptionTest(){
		
		System.out.println("\n" + "addExceptionTest:");
		
		ArrayList list = new ArrayList();
		
		assertEquals(0, list.size());
		
		//	Check for null object being passed in
		Object nullObj = null;
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
			list.add(nullObj);
		});
		
		//	Check to make sure that a negative index does not work
		Exception e2 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			list.add(10, -1);
		});
		
		list.add(1);
		
		//	Ensure that adding to an index farther than the next open spot does not work
		Exception e3 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			list.add(10, 2);
		});
		
		System.out.println(e1.getMessage());
		System.out.println(e2.getMessage());
		System.out.println(e3.getMessage());
	}
	
	@Test
	void addTest() {
		
		System.out.println("\n" + "addTest:");
		
		ArrayList list = new ArrayList();
		
		//	List size should increment and the list should not longer be empty
		list.add(20);
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		
		System.out.println("List after appending a single value of 20: {" + list + "}");
		
		list.add(10);
		assertEquals(2, list.size());
		assertFalse(list.isEmpty());
		
		System.out.println("List after appending a second value of 10: {" + list + "}");
	}
	
	@Test
	void addWithIndexTest() {
		
		System.out.println("\n" + "addWithIndexTest:");
		
		ArrayList list = new ArrayList();
		
		list.add('A');
		list.add('C');
		
		System.out.println("Current list after 'A' and 'C' are added: {" + list + "}");
		
		//	Since the index already exists, the array list should be shifted
		list.add('B', 1);
		
		System.out.println("Current list after 'B' is added at index 1: {" + list + "}");
		
		assertEquals(3, list.size());
		
		//	Order of array list should be the following
		assertEquals('A', list.get(0));
		assertEquals('B', list.get(1));
		assertEquals('C', list.get(2));
		
	}
	
	@Test
	void removeExceptionTest() {
		
		System.out.println("\n" + "removeExceptionTest:");
		
		ArrayList list = new ArrayList();
		
		//	Check to make sure that items cannot be removed if none exist
		Exception e1 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			list.remove(0);
		});
		
		list.add(10);
		
		//	Check to ensure that an item cannot be removed if there is nothing in that slot
		Exception e2 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			list.remove(1);
		});
		
		System.out.println(e1.getMessage());
		System.out.println(e2.getMessage());
	}
	
	@Test
	void removeTest() {
		
		System.out.println("\n" + "removeTest:");
		
		ArrayList list = new ArrayList();
		
		//	Add a few values to be removed
		list.add(5.5);
		list.add(9.5);
		list.add(13.5);
		
		System.out.println("List with a few default values: {" + list + "}");
		
		//	Remove middle value
		list.remove(1);
		
		assertEquals(5.5, list.get(0));
		assertEquals(13.5, list.get(1));
		assertEquals(2, list.size());
		
		System.out.println("List after middle value is removed: {" + list + "}");
	}
	
	@Test
	void extendArraySizeTest() {
		
		System.out.println("\n" + "extendArraySizeTest:");
		
		ArrayList list = new ArrayList();
		
		//	Add first ten list elements (default list size)
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		
		System.out.println("Current list with max default size of 10: {" + list + "}");
		
		assertEquals(10, list.size());
		
		list.add(11);
		
		assertEquals(11, list.size());
		
		System.out.println("Current list after adding 11th element: {" + list + "}");
	}

}
