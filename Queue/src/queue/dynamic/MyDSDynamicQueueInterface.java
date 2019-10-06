package queue.dynamic;

import queue.interfacee.Queue;

public interface MyDSDynamicQueueInterface<E> extends Queue<E> {
	void addAll(Queue<E> queue);
}
