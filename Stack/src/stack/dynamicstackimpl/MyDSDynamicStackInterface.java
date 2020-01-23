package stack.dynamicstackimpl;

import stack.stackinterface.Stack;


public interface MyDSDynamicStackInterface<E> extends Stack<E>{
	void addAll(Stack<E> stack);
}
