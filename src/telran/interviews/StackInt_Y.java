package telran.interviews;

import java.util.*;

public class StackInt_Y {
	private LinkedList<Integer> numbers = new LinkedList<>();
	private LinkedList<Integer> maxNumbers = new LinkedList<>();

	public void push(int num) {
		numbers.add(num);
		if (maxNumbers.isEmpty() || num >= maxNumbers.getLast()) {
			maxNumbers.add(num);
		}
	}

	public int pop() {

		int res = numbers.removeLast();
		if (res == maxNumbers.getLast()) {
			maxNumbers.removeLast();
		}
		return res;
	}

	public boolean isEmpty() {
		return numbers.isEmpty();
	}

	public int max() {

		return maxNumbers.getLast();
	}
}
