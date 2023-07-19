package telran.interviews;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;



//All methods have to have the Complexity o[1];
public class StackInt {
//TODO fields
	
	private LinkedList<Integer> stackInt;
	private LinkedList<Integer> stackMax = new LinkedList<>();
	
	
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
		}

	private boolean isMax(int num) {
		boolean res = false;
		if(stackInt.size()== 1) {
			res = true;
		} else {
			res = stackMax.getLast() <= num ? true : false;
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
		int elem = stackInt.removeLast();
		if(elem == stackMax.getLast()) {
			stackMax.removeLast();
		}
		return elem;
	}

	public boolean isEmpty() {
		// TODO returns true if stack is empty

		return stackInt.size() == 0  ;
	}

	public int max() {
		// TODO returns max value existing in the stack
		//throws NoShuchElementException is the stack is empty
		if(isEmpty()) {
			throw new NoSuchElementException();
		}		
		return stackMax.getLast();
	}
	

}
