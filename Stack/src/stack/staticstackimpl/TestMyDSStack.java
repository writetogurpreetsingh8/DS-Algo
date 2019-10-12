package stack.staticstackimpl;

import stack.stackinterface.Iterator;


public class TestMyDSStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyDSStaticStackInterface<String> stack = new MyDSStaticStack<String>();
		
		stack.push("one");
		stack.push("two");
		stack.push("three");
		
		System.out.println("is stack empty "+stack.isEmpty());
		System.out.println("is space available "+stack.isSpaceAvailable());
		Iterator<String> iterator = stack.iterator();
		//System.out.println("poped element is "+stack.pop());
		//System.out.println("poped element is "+stack.pop());
		//System.out.println("poped element is "+stack.pop());
		//stack.clear();
		
		while(iterator.hasNext()){
			System.out.println(iterator.nextElement());
		}
		//System.out.println(stack.isEmpty());
		//System.out.println(stack.indexOf(null));
		
		iterator = stack.iterator();
		System.out.println(iterator.hasNext());
		while(iterator.hasNext()){
			System.out.println(iterator.nextElement());
		}
		System.out.println("poped up element from stack is "+stack.pop());
		Object[] temp = stack.toArray();
		System.out.println(temp);
		


	}

}
