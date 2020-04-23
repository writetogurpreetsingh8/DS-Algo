package dequeue.interfacee;


public interface DeQueue<E> {

	void pushTop(E element);
	void pushBottom(E element);
	E popTop();
	E popBottom();
	void showTop();
	void showBottom();
	boolean isEmptyTop();
	boolean isEmptyBottom();
	boolean searchTop(E element);
	boolean searchBottom(E element);
	IteratorTop<E> iteratorTop();
	IteratorBottom<E> iteratorBottom();
	void clearTop();
	void clearBottom();
	int indexOfTop(E element);
	int indexOfBottom(E element);
	int sizeTop();
	int sizeBottom();
	Object[] toArrayTop();
	Object[] toArrayBottom();
	int capacity();
	public String toStringTop();
	public String toStringBottom();
	
	
}


