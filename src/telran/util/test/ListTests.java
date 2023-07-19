package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListTests {
Integer[] numbers = {10, -30, 13, 48, 22, 17, 23};
List<Integer> immutableList = Arrays.asList(numbers);//fixed size but changing may 
List<Integer> mutableList;
	@BeforeEach
	void setUp() throws Exception {
		mutableList = new ArrayList<>(immutableList);
	}

	@Test
	void toArrayTest() {
		assertIterableEquals(mutableList, immutableList);
		assertArrayEquals(numbers, mutableList.toArray(Integer[]::new));
		assertArrayEquals(numbers, immutableList.toArray(Integer[]::new));
		
	}
	@Test
	void updateListsTest() {
		assertThrows(UnsupportedOperationException.class,
				()-> immutableList.remove(0));
		List<Integer> subList = mutableList.subList(2, 5);
		subList.clear();
		Integer[] expected1 = {10, -30, 17, 23};
		assertArrayEquals(expected1, mutableList.toArray(Integer[]::new));
		subList = mutableList.subList(2, 4);//"to" exclusive
		subList.set(1, 500);//our expected last element will be 500;
		Integer[] expected2 = {10, -30, 17, 500};
		assertArrayEquals(expected2, mutableList.toArray(Integer[]::new));
		subList.add(0, -50);
		Integer[] expected3 = {10, -30, -50, 17, 500};
		assertArrayEquals(expected3, mutableList.toArray(Integer[]::new));
		// subList {-50, 17, 500}
		Integer[] expected4 = {-50, 17, 500};
		Integer[] expected5 = {10, -30, -50, 17};
		subList.remove(2);
//		System.out.println(subList);
//		assertArrayEquals(expected5, mutableList.toArray(Integer[]::new));
//		mutableList.add(3,1);		
	}
	@Test
	void stackTest() {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		assertFalse(stack.isEmpty());
		assertEquals(10, stack.pop());		
	}
	@Test
	void queueTest() {
		Queue<Integer> queue = new LinkedList<>();
		assertThrowsExactly(NoSuchElementException.class,
				()-> queue.remove());
	}
	@Test
	void subListTest () {
		
	}

}
