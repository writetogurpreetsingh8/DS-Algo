package stack.dynamicstackimpl;

import stack.stackinterface.Iterator;


public class TestMyDSStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDSDynamicStackInterface<String> stack = new MyDSDynamicStack<String>(5);
		System.out.println(stack.size());
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		stack.push("five");
		stack.push("six");
		System.out.println(stack.size());
		System.out.println("is stack empty "+stack.isEmpty());
		Iterator<String> iterator = stack.iterator();
		//System.out.println("poped element is "+stack.pop());
		//System.out.println("poped element is "+stack.pop());
		System.out.println(stack.size());
		System.out.println(stack);
		Object[] temp = stack.toArray();
		System.out.println(temp);
		//stack.clear();
		while(iterator.hasNext()){
			String value = iterator.nextElement();
			System.out.println("iterator value is "+value);
		}
		System.out.println(stack.isEmpty());
		System.out.println(stack);
		stack.addAll(stack);
		System.out.println(stack);

	}

}
