package telran.interviews;
import java.util.Set;

public interface MultiCounters {
	/**
	 * MultiCounters (most difficult task) - two maps: HashMap<Object, Integer> items; 
	 * where key is an item, value is numbers of adds (counter) ; 
	 * second map is TreeMap<Integer, HashSet<Object>> key is numbers of adds (counter), 
	 * value is the set of items with the appropriate counter 
	 * (items that have been added the same  number of times);
	 * 
	 * @param item
	 * @return How many times the item has been added
	 * if item is the new one then 1 will be returned
	 */
		Integer addItem(Object item); //O[LogN]
		
		/**
		 * 
		 * @param item
		 * @return how many times a given item has been added
		 * if no one then null will be returned
		 */
		Integer getValue(Object item); //O[1]
		
		/**
		 * removes item with all counters
		 * @param item
		 * @return true if item has been removed otherwise false (if a given item doesn't exists)
		 */
		boolean remove(Object item) ; //O[LOgN]
		
		/**
		 * 
		 * @return set of items with maximal counters
		 */
		Set<Object> getMaxItems(); //O[LogN]
}
