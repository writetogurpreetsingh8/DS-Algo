package queue.staticc;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import queue.interfacee.Iterator;

public class MyDSStaticQueue<E> implements MyDSStaticQueueInterface<E> {

	
	private int rear;
	private int front;
	private Object[] elements;
	private int size;
	
	public MyDSStaticQueue() {
		this(5);
	}
	
	public MyDSStaticQueue(int initialCapacity) {
		if(initialCapacity <= 0 )
			throw new IllegalArgumentException(
			"inital capacity of queue can not be negative/zero");	
		elements = new Object[initialCapacity];
		rear = front = -1;
		size = 0;
	}
	
	@Override
	public void clear() {
		if(rear == front){
			rear = front = -1;
			throw new IllegalStateException("Queue already emtpy,can not clear");
		}	
		for(int i=(front + 1); i <= rear; i++){
			elements[i] = null;
		}
		size = 0;
		rear = front = -1;
		
	}

	@Override
	public void show() {
		if(rear == front)
			throw new IllegalStateException("Queue is emtpy,can not show elements");
		
		for(int i=(front + 1); i <= rear; i++)
			System.out.println("elements are "+elements[i]);
	}

	@Override
	public int indexOf(E element) {
		
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not return index of it");
		
		if(rear == front)
			throw new IllegalStateException("Queue is emtpy,can not return the index of given element "+element);
		
		for(int i=(front + 1); i <= rear; i++){
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
	public boolean isSpaceAvailable() {
		return elements.length != size();
	}
	@Override
	public E pop() {
		if(rear == front){
			rear = front = -1;
			throw new IndexOutOfBoundsException("Queue is underflow");
		}	
		E element = (E)elements[++front];
		elements[front] = null;
		size--;
		return element;
	}

	@Override
	public void push(E element) {
		if(element == null)
		throw new IllegalStateException("Passed element is null , can not push it into Queue");
		
		if(rear == (elements.length - 1))
			throw new IndexOutOfBoundsException("Queue is overflow");
		elements[++rear] = element;
		size = (rear + 1);
	}

	@Override
	public boolean search(E element) {
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not search of it");
		if(rear == front){
			throw new IllegalStateException("Queue is emtpy,can not search the given element "+element);
		}
		for(int i=(front + 1); i <= rear; i++){
			if(elements[i].equals(element)){
					return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		if(rear == front )
			throw new IllegalStateException("Queue already emtpy,can not convert into arrays ");
		Object[] temp = (Object[])Array.newInstance(elements.getClass().getComponentType(), size());
		System.arraycopy(elements, (front + 1), temp, 0, size());
		return temp;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<E>{
		
		int cursor = 0;
		@Override
		public boolean hasNext() {
			return (cursor != size());
		}

		@Override
		public E next() {
			if(cursor == size())
				throw new NoSuchElementException("No element found in Queue");
			return (E)elements[cursor++];
		}
		
	}

	@Override
	public int spaceAvailable() {
		return (elements.length - size());
	}

	@Override
	public int capacity() {
		return elements.length;
	}
	

}
