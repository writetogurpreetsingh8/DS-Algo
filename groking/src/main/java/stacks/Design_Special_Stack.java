package stacks;

import java.util.Stack;

//Design special stack having push , pop, getMin and getMax operation with O(1) TC always

/**
 * TC O(1) = push operation
 * TC O(1) = pop operation
 * TC O(1) = getMin operation
 * TC O(1) = getMax operation
 * system stack O(1)
 * aux-space (1) ( we won't consider Stack being used in this program since anyhow we need to use Stack as it is already
 * mentioned in the problem statement to use stack
 */
public class Design_Special_Stack {

	private class Pair{
		
		public Pair(int x, int max, int min) {
			this.value = x;
			this.max = max;
			this.min = min;
		}
		
		int value;
		int min;
		int max;
	}
	
	private Stack<Pair> stack;
	
	Design_Special_Stack(){
		this.stack = new Stack<>();
	}
	
	 public void push(int x) {
         Pair p;
        if(!this.stack.isEmpty()){
            int min = Math.min(x, this.stack.peek().min);
            int max = Math.max(x, this.stack.peek().max);
		    p = new Pair(x,max,min);    
        }
        else{
            p = new Pair(x,x,x);
        }
        this.stack.push(p);
    }
	
	void pop() {
		
		if(!this.stack.isEmpty()) {
			Pair element = stack.pop();
			System.out.println("pop element is "+element.value);
		}
		else {
			System.out.println("stack is empty can't pop...");
		}
	}
	
	int top() {
		
		Pair element;
		
		if(!this.stack.isEmpty()) {
			element = this.stack.peek();
			return element.value;
		}
		else {
			System.out.println("stack is empty can't peek...");
		}
		return -1;
	}
	
	int getMin() {
		
		if(!this.stack.isEmpty()) {
			return this.stack.peek().min;
		}
		return -1;
	}
	
	int getMax() {
		
		if(!this.stack.isEmpty()) {
			return this.stack.peek().max;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		Design_Special_Stack obj = new Design_Special_Stack();
		obj.push(10);obj.push(1);obj.push(0);
		obj.push(20);obj.push(-10);obj.push(-1);
		obj.push(5);obj.push(2);
		
		System.out.println(obj.getMax());
		System.out.println(obj.getMin());
		
	}

}
