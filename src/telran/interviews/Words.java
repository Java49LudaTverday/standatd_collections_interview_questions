package telran.interviews;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Words {
	private TreeSet<String> words;
	Comparator<String> comp = String.CASE_INSENSITIVE_ORDER;;

	/**
	 * Words -TreeSet<String> with case insensitive comparator; adds word
	 * 
	 * @param word
	 * @return true if added, otherwise false if an word already exists (case
	 *         insensitive)
	 */
	public Words() {
		words = new TreeSet<>();		
	}

	public boolean addWord(String word) {
		return words.add(word);
	}

	/**
	 * 
	 * @param prefix
	 * @return list of words starting from a given prefix (case insensitive)
	 */
	public List<String> getWordsByPrefix(String prefix) {

		return words.stream()
				.filter((w) -> comparingStrings(w, prefix)).toList();
	}

	private boolean comparingStrings(String word, String prefix) {
		boolean res = false;
		if(word.length() >= prefix.length()) {
			res = comp.compare(word.substring(0, prefix.length()), prefix) == 0 ? true : false;
		}		
		return  res;
	}

}
