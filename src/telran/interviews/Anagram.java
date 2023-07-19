package telran.interviews;

import java.util.HashMap;

public class Anagram {
	/**
	 * 
	 * @param word
	 * @param anagram
	 * @return true if anagram is one of the possible anagrams of a given word
	 *         anagram is a string containing all symbols from a given word with
	 *         different order Example: yellow (wolely, lowlye, yellow) , wrong
	 *         anagrams (yello, yelllw)
	 */
	public static boolean isAnagram(String word, String anagram) {

		if (word.length() != anagram.length()) {
			return false;
		}
		HashMap<Character, Integer> mapWord = getMapWord(getLowCharArray(word));
		HashMap<Character, Integer> mapAnagr = getMapWord(getLowCharArray(anagram));

		return mapAnagr.keySet().stream()
				.allMatch((key) -> mapWord.containsKey(key) ? mapWord.get(key).equals(mapAnagr.get(key)) : false);

	}

	private static char[] getLowCharArray(String word) {
		return word.toLowerCase().toCharArray();
	}

	private static HashMap<Character, Integer> getMapWord(char[] word) {
		HashMap<Character, Integer> res = new HashMap<>();
		for (char str : word) {
			res.merge(str, 1, (a, b) -> a + b);
		}
		return res;

	}

}
