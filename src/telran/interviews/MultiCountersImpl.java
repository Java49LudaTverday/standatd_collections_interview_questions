package telran.interviews;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MultiCountersImpl implements MultiCounters {
	private HashMap<Object, Integer> items;// where key is an item, value is numbers of adds (counter)
	private TreeMap<Integer, HashSet<Object>> counterItems;// key is numbers of adds (counter), value is the set of
															// items

	public MultiCountersImpl () {
		items = new HashMap<>();
		counterItems = new TreeMap<>();
		counterItems.put(0, new HashSet<>());
	}

	@Override //// O[LogN]
	public Integer addItem(Object item) {
		Integer prevValue = items.get(item);
		items.merge(item, 1, (a, b) -> a + b);
		Integer value = items.get(item);
		if(prevValue != null) {
			counterItemsRemove(prevValue, item);
		} 
			counterItemsAdd(value , item);
		
		return value;
	}	

	private void counterItemsAdd(Integer value, Object item) {
		HashSet<Object> itemsSet = counterItems.get(value);		
		if(itemsSet == null) {
			itemsSet = new HashSet<>();
			itemsSet.add(item);
			counterItems.put(value, itemsSet);
		} else {
			itemsSet.add(item);
		}
		
	}

	private void counterItemsRemove(Integer value, Object item) {
		HashSet<Object> itemsSet = counterItems.get(value);
		if(itemsSet.remove(item)&& itemsSet.isEmpty()) {
			counterItems.remove(value);
		}		
	}

	@Override // O[1]
	public Integer getValue(Object item) {
		return items.get(item);
	}

	@Override//O[LOgN]
	public boolean remove(Object item) {
		Integer value = items.get(item);
		if(value != null) {
			counterItemsRemove(value, item);
		}		 	
		return items.remove(item) != null;
	}

	@Override//O[LogN]
	public Set<Object> getMaxItems() {
		
		return counterItems.lastEntry().getValue();
	}

}
