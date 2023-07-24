package telran.interviews;

import java.util.*;

public class Words_Y {
	//better choice TreeSet : sorted and get O(logN) 
	TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

	public boolean addWord(String word) {

		return set.add(word);
	}

	public List<String> getWordsByPrefix(String prefix) {

		return new ArrayList<>(set.subSet(prefix, getPrefixLimit(prefix)));
	}
	
	private String getPrefixLimit(String prefix) {
		char lastChar = prefix.charAt(prefix.length() - 1);//gets last character
		char limitChar = (char) (lastChar + 1);//adds one point for last character
		return prefix.substring(0, prefix.length() - 1) + limitChar;//prefix without last char plus limitChar

	}
}
