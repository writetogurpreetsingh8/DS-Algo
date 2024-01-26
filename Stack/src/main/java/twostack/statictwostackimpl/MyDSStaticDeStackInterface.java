package twostack.statictwostackimpl;

import twostack.twostackinterface.DeStack;


public interface MyDSStaticDeStackInterface<T> extends DeStack<T>{
	
	boolean isSpaceAvailableTop();
	boolean isSpaceAvailableBottom();
	int spaceAvailableAtTop();
	int spaceAvailableAtBottom();
}
