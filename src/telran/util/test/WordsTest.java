package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.Words;

class WordsTest {

	String words[] = { "abcdef", "ab123", "aaa", "ab", "ablmn", "abbbb", "a", "ABd", "bbb", "B12", "*/" };
	String wordsStartB[] = { "B12", "bbb" };
	String wordsStartAB[] = {"ABd", "ab", "ab123", "abbbb", "abcdef",  "ablmn" };
	String wordsStartABC[] = { "abcdef" };
	String wordsStartAsteric[] = { "*/" };
	Words elasticSearch;

	@BeforeEach
	void setUp() throws Exception {
		elasticSearch = new Words();
		for (String word : words) {
			elasticSearch.addWord(word);
		}
	}

	@Test
	void test() {
		String[] string = elasticSearch.getWordsByPrefix("abc").toArray(String[]::new);
		for(String str: string) {
			System.out.println(str);
		};
		assertArrayEquals(wordsStartABC, elasticSearch.getWordsByPrefix("abc").toArray(String[]::new));
		assertArrayEquals(wordsStartB, elasticSearch.getWordsByPrefix("B").toArray(String[]::new));
		assertArrayEquals(wordsStartAB, elasticSearch.getWordsByPrefix("ab").toArray(String[]::new));
		assertArrayEquals(wordsStartAsteric, elasticSearch.getWordsByPrefix("*").toArray(String[]::new));

	}
}
