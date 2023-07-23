package telran.interviews;

import java.util.HashMap;

/**
 * using HashMap All methods of the class should have complexity O[1]
 * 
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
	private HashMap<Integer, T> myArray;
	private int size;

	public MyArray(int size) {

		myArray = new HashMap<>();
		this.size = size;
	}

	/**
	 * sets all array's elements with a given value
	 * 
	 * @param value
	 */
	public void setAll(T value) {
		for (int i = 0; i < size; i++) {
			myArray.put(i, value);
		}
	}

	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {

		return myArray.get(index);
	}

	/**
	 * sets a given value at a given index 
	 * throws IndexOutOfBoundsException in the case of wrong index
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if (index < 0 && index >= size) {
			throw new IndexOutOfBoundsException("wrong index");
		}
		// myArray.merge(index, value, (a,b)-> b);// another way to replace
		myArray.replace(index, value);
	}
}
