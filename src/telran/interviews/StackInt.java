package telran.interviews;

import java.util.*;
import java.util.NoSuchElementException;



//All methods have to have the Complexity o[1];
public class StackInt {
//TODO fields
	
	private List<Integer> stackInt;
	private int size = 0;
	private List<Integer> stackMax = new LinkedList<>();
	
	
	public StackInt () {
		this.stackInt = new LinkedList<>();
	}
	
	
	public void push(int num) {
		// TODO
	// adds a number in the stack				
		stackInt.add(num);		
		if(isMax(num)){
			stackMax.add(num);
		}
		size++;
		}

	private boolean isMax(int num) {
		boolean res = false;
		if(stackInt.size()== 1) {
			res = true;
		} else {
			res = stackMax.get(stackMax.size() - 1) < num ? true : false;
		}
		return res;
	}

	public int pop() {
		// TODO takes out and returns the top stack number;
		// in the case the stack is empty the exception of the class
		// NoSuchElementException should be throws
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		int elem = stackInt.remove(--size);
		if(elem == stackMax.get(stackMax.size() - 1)) {
			stackMax.remove(stackMax.size() - 1);
		}
		return elem;
	}

	public boolean isEmpty() {
		// TODO returns true if stack is empty

		return size == 0  ;
	}

	public int max() {
		// TODO returns max value existing in the stack
		//throws NoShuchElementException is the stack is empty
		if(isEmpty()&& stackMax.isEmpty()) {
			throw new NoSuchElementException();
		}		
		return stackMax.get(stackMax.size() - 1);
	}
	

}
