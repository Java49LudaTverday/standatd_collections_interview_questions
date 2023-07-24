package telran.interviews.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.interviews.StreamTasks.*;

class StreamTasksTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void displayOccurrencesTest() {
		String[] strings = {"lmn", "ab", "lmn", "c", "ab",
				"a", "lmn", "zzz"};
		displayOccurrences(strings);
	}
	@Test
	void displayOddEvenGroupingTest() {
		
		displayOddEvenGrouping(10);
	}

}
