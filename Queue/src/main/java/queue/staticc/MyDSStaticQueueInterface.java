package queue.staticc;

import queue.interfacee.Queue;

public interface MyDSStaticQueueInterface<E> extends Queue<E> {
	boolean isSpaceAvailable();
	int spaceAvailable();
}
