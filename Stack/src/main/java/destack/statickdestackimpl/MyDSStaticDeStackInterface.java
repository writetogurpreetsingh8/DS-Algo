package destack.statickdestackimpl;

import destack.destackinterface.DeStack;


public interface MyDSStaticDeStackInterface<T> extends DeStack<T>{
	
	boolean isSpaceAvailableTop();
	boolean isSpaceAvailableBottom();
	int spaceAvailableAtTop();
	int spaceAvailableAtBottom();
}
