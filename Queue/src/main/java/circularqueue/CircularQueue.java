package circularqueue;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import queue.interfacee.Iterator;
import queue.staticc.MyDSStaticQueueInterface;

public class CircularQueue<E> implements MyDSStaticQueueInterface<E> {

	Object[] elements;
	int front,rear,size;
	
	public CircularQueue() {
		this(5);
	}
	
	public CircularQueue(int initialCapacity) {
		if(initialCapacity <= 0 )
			throw new IllegalArgumentException(
			"inital capacity of queue can not be negative/zero");	
		elements = new Object[initialCapacity];
		rear = front = 0;
		size = 0;
	}
	
	@Override
	public int capacity() {
		return elements.length;
	}

	@Override
	public void clear() {
		if(rear == front){
			rear = front = 0;
			throw new IllegalStateException("Circular Queue already emtpy,can not clear");
		}
		for(int i=(front + 1); i != rear; i=((i + 1) % elements.length))
			elements[i] = null;
		size = 0;
		rear = front = 0;
	}

	@Override
	public int indexOf(E element) {
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not return index of it");
		if(rear == front)
			throw new IllegalStateException("Circular Queue is emtpy,can not return the index of given element "+element);
		
		for(int i = (front + 1); i!=rear; i = ((i + 1) % elements.length)){
			if(elements[i].equals(element))
				return i;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return (rear == front);
	}

	@Override
	public E pop() {
		if(rear == front)
			throw new IndexOutOfBoundsException("Circular Queue is underflow");
		front = ((front + 1) % elements.length);
		E element = (E)elements[front];
		elements[front] = null;
		size--;
		return element;
	}

	@Override
	public void push(E element) {
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not push it into Circular Queue");
			
		if(front == ((rear + 1) % elements.length))
			throw new IndexOutOfBoundsException("Circular Queue is overflow");
			rear = ((rear + 1) % elements.length);
			elements[rear] = element;
			size++;
	}

	@Override
	public boolean search(E element) {
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not search of it");
		if(rear == front)
			throw new IllegalStateException("Circular Queue is emtpy,can not search the given element "+element);
		
		for(int i = (front + 1); i!=rear; i = ((i + 1) % elements.length)){
			if(element.equals(elements[i]))
				return true;
		}
		
		return false;
	}

	@Override
	public void show() {
		if(rear == front)
			throw new IllegalStateException("Circular Queue already emtpy,can not show");
		for(int i = (front + 1); i!=rear; i = ((i + 1) % elements.length))
			System.out.println("elements are "+elements[i]);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		if(rear == front )
			throw new IllegalStateException("Circular Queue already emtpy,can not convert into arrays ");
		Object temp[] = (Object[])Array.newInstance(elements.getClass().getComponentType(), size());
		for(int j = 0,i = (front + 1); i!=rear; i = ((i + 1) % elements.length),j++)
			temp[j] = elements[i];
		return temp;
	}
	
	@Override
	public boolean isSpaceAvailable() {
		return (elements.length != size());  
	}

	@Override
	public int spaceAvailable() {
		return (elements.length - size()); 
	}
	
	@Override
	public Iterator<E> iterator() {
		return new MyCircularQueueIterator();
	}
	private class MyCircularQueueIterator implements Iterator<E>{
		
		int cursor = ((front + 1) % elements.length);
		@Override
		public boolean hasNext() {
			return (cursor != ((rear + 1) % elements.length));
		}

		@Override
		public E next() {
			if (cursor == ((rear + 1) % elements.length))
				throw new NoSuchElementException("No element found in Circular Queue");
			E element = (E)elements[cursor];
			cursor = ((cursor + 1) % elements.length);
			return element;
		}
		
	}
}
