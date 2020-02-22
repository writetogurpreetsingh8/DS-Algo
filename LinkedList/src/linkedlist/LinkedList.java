package linkedlist;

import iterator.Iterator;

public interface LinkedList<E> {
	
	void add(E element);
	void addAtBeginning(E element);
	void addAtMiddle(int position,E element);
	int length();
	void deleteAtMiddle(int position);
	void deleteAtEnd();
	void deleteAtBeginning();
	void delete(E element);
	void show();
	E getElement(int position);
	E getLastElement();
	E getFirstElement();
	boolean contains(E element);
	int indexOf(E element);
	Object[] toArray();
	Iterator<E> iterator();
	void addAll(LinkedList<E> list);
}
