package stack.stackinterface;


public interface Stack<T> {

	void push(T item);
	T pop();
	boolean isEmpty();
	boolean search(T value);
	Iterator<T> iterator();
	Object[] toArray();
	void show();
	void clear();
	int indexOf(T value);
	int size();
	int capacity();
	
}
