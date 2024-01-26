package twostack.dynamictwostackimpl;

import twostack.twostackinterface.DeStack;


public interface MyDSDynamicDeStackInterface<T> extends DeStack<T>{
	void addAllAtTop(DeStack<T> stack);
	void addAllAtBottom(DeStack<T> stack);
}
