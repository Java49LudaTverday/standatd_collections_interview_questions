package telran.interviews.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.interviews.StreamTasks.*;

class StreamTasksTest {
	int nNumbers = 1_000_000;

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
	@Disabled
	void displayOddEvenGroupingTest() {
		
		displayOddEvenGrouping(10);
	}
	@Test
	void printDigitStatisticsTest(){
		printDigitStatistics(nNumbers);
	}
}
