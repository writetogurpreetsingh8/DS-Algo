package dequeue.staticc;

import dequeue.interfacee.DeQueue;

public interface MyDSStaticDeQueueInterface<E> extends DeQueue<E>{
	boolean isSapaceAvailableTop();
	boolean isSapaceAvailableBottom();
	int spaceAvailableTop();
	int spaceAvailableBottom();
}
