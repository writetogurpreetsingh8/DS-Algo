package stack.staticstackimpl;

import stack.stackinterface.Stack;


public interface MyDSStaticStackInterface<T> extends Stack<T>{
	boolean isSpaceAvailable();
	int spaceAvailable();
}
