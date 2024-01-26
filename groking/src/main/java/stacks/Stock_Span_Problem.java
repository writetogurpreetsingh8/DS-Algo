package stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* Leet-Code# 901 
*/

class Stock{
	
	int value;
	int span;
	
	public Stock(int value, int span) {
		super();
		this.value = value;
		this.span = span;
	}

	@Override
	public String toString() {
		return "Stock [value=" + value + ", span=" + span + "]";
	}
}

public class Stock_Span_Problem {

	List<Integer> result;
	Stack<Stock> stack;
	
	public Stock_Span_Problem() {
		
		this.stack = new Stack<>();
		this.result = new ArrayList<>();
	}
	
	public int next(int price) {
	
		int span=1;
		
		while(!stack.isEmpty() && stack.peek().value <= price) {
			span = span + stack.pop().span;
		}
		
		result.add(span);
		stack.push(new Stock(price,span));
		return span;
	}
	
	public static void main(String[] args) {
		
		Stock_Span_Problem instance = new Stock_Span_Problem();
		
		
		  System.out.println(instance.next(100));
		  System.out.println(instance.next(80)); System.out.println(instance.next(60));
		  System.out.println(instance.next(70)); System.out.println(instance.next(60));
		  System.out.println(instance.next(75)); System.out.println(instance.next(35));
		  System.out.println(instance.result);
		  
			 instance = new Stock_Span_Problem();
			
		System.out.println(instance.next(31));
		System.out.println(instance.next(41));
		System.out.println(instance.next(48));
		System.out.println(instance.next(59));
		System.out.println(instance.next(79));
		
		System.out.println(instance.result);
	}

}
