package twostack.twostackinterface;

public interface DeStack<T> {

	void pushTop(T item);
	void pushBottom(T item);
	T popTop();
	T popBottom();
	boolean isEmptyTop();
	boolean isEmptyBottom();
	boolean searchTop(T value);
	boolean searchBottom(T value);
	IteratorTop<T> iteratorTop();
	IteratorBottom<T> iteratorBottom();
	Object[] toArrayTop();
	Object[] toArrayBottom();
	void showTop();
	void showBottom();
	void clearTop();
	void clearBottom();
	int indexOfTop(T value);
	int indexOfBottom(T value);
	int sizeTop();
	int sizeBottom();
	int capacity();
	public String toStringTop();
	public String toStringBottom();
	
}
