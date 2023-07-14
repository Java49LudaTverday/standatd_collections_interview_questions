package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.*;

class StackIntTests {
	Integer[] numbers = { 10, 0, 11, 9, 5, 2, 12 };
	StackInt stack = new StackInt();

	@BeforeEach
	void setUp() throws Exception {
		for (Integer num : numbers) {
			stack.push(num);
		}
	}

	@Test
	void isEmptyTest() {
		assertFalse(stack.isEmpty());
		cleanStack();
		assertTrue(stack.isEmpty());
		assertThrowsExactly(NoSuchElementException.class, ()-> stack.pop());
	}

	private void cleanStack() {
		for (int i = 0; i < numbers.length; i++) {
			stack.pop();
		}
	}

	@Test
	void maxNumberTest() {
		assertEquals(12, stack.max());
		stack.pop();
		stack.pop();
		assertEquals(11, stack.max());
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(10, stack.max());
		stack.pop();
		stack.pop();
		assertThrowsExactly(NoSuchElementException.class, ()-> stack.max());
	}

}
