package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapTests {
	final static int MAX_SIZE = 4;
Integer[] values = {10, 5, 8, 7, 100};
String [] keys = {"t","a", "b", "c", "d" };
LinkedHashMap<String, Integer> map;
//HashMap<String, Integer> map;
@BeforeEach
void setUp() {
	map = new LinkedHashMap<>(16, 0.75f, true ) {
		protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest){
			return size() > MAX_SIZE;
		}
	};
	//map = new HashMap<>();
	for(int i = 0; i < keys.length; i++) {
		map.put(keys[i], values[i]);
	}
}
@Test
void linkedHashMapTest() {
	String[] expected = {"a", "b", "c", "d"};
	assertArrayEquals(expected, map.keySet().toArray(String[]::new));
	map.get("a");	
	map.put("t", 100);
	assertEquals(5, map.get("a"));	
	System.out.println(map.keySet());
}
	@Test
	void displayOccurrencesTest() {
		displayOccurrences(new String[] {
				"lmn","cd", "ab", "lmn", "a", "cd", "lmn", "cd"
		});
		// cd -> 3
		// lmn -> 3 		
		// a -> 1 (sort by ABC)
		// ab -> 1
	}

	private void displayOccurrences(String[] strings) {
		// O(n)
		HashMap<String, Integer> mapOccurrences = getMap(strings);
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(mapOccurrences.entrySet());
		list.sort((e1, e2) -> {
			int res = Integer.compare(e2.getValue(), e1.getValue());
			
			return res == 0 ? e1.getKey().compareTo(e2.getKey()): res;
		});
		list.stream().forEach(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));
	}

	private HashMap<String, Integer> getMap(String[] strings) {
		HashMap<String, Integer> res = new HashMap<>();
		for(String str: strings) {
			res.merge(str, 1, (a,b)-> a + b);
			//System.out.println(res);
		}
		return res;
	}

}
