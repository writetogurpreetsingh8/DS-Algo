package test;

import stack.dynamicstackimpl.MyDSDynamicStack;
import stack.dynamicstackimpl.MyDSDynamicStackInterface;
import stack.stackinterface.Iterator;
import stack.staticstackimpl.MyDSStaticStack;


public class TestMyDSStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*MyDSDynamicStackInterface<String> dynamicStack = new MyDSDynamicStack<String>(5);
		dynamicStack.push("D-one");
		dynamicStack.push("D-two");
		dynamicStack.push("D-three");
		dynamicStack.push("D-four");
		dynamicStack.push("D-five");
		
		System.out.println("is stack empty "+dynamicStack.isEmpty());
		Iterator<String> iterator = dynamicStack.iterator();
		//System.out.println("poped element is "+stack.pop());
		//System.out.println("poped element is "+stack.pop());
		System.out.println("dynamic static "+dynamicStack);
		
		MyDSStaticStack<String> staticStack = new MyDSStaticStack<String>();
		staticStack.push("S-one");
		staticStack.push("S-two");
		staticStack.push("S-three");
		staticStack.push("S-four");
		staticStack.push("S-five");*/
		
		
		
		//stack.clear();
		/*while(iterator.hasNext()){
			String value = iterator.nextElement();
			System.out.println("iterator value is "+value);
		}*/
		/*System.out.println(dynamicStack.isEmpty());
		System.out.println(dynamicStack);
		System.out.println("dynamic stack after adding another stack elements ");
		dynamicStack.addAll(staticStack);
		System.out.println(dynamicStack);*/
		
		String [] abc = new String[10];
		System.out.println(abc.length);

	}

}
