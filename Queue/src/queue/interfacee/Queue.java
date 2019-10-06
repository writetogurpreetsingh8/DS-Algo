package queue.interfacee;

public interface Queue<E> {

	void push(E element);
	E pop();
	void show();
	boolean isEmpty();
	boolean search(E element);
	Iterator<E> iterator();
	void clear();
	int indexOf(E element);
	int size();
	Object[] toArray();
	int capacity();
	
}
