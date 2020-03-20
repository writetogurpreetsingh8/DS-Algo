package stack.staticstackimpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

import stack.stackinterface.Iterator;

public class MyDSStaticStack<T> implements MyDSStaticStackInterface<T> {

	private Object element[];
	private int top = -1;
	private int cursor;

	public MyDSStaticStack() {
		this(5);
	}

	public MyDSStaticStack(int initialCapacity) {
		if (initialCapacity <= 0)
			throw new IllegalArgumentException(
					"inital capacity of stack can not be negative/zero");
		element = new Object[initialCapacity];
	}

	@Override
	public void push(T item) {
		if(item == null)
			throw new IllegalStateException("Passed element is null , can not push it into Stack");
		
		if (top == (element.length - 1)) {
			throw new IndexOutOfBoundsException("Stack is overflow");
		}
		element[++top] = item;
		cursor = top;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		T value;
		if (top == -1) {
			throw new IndexOutOfBoundsException("Stack is underflow");
		}
		value = (T) element[top];
		element[top] = null;
		top--;
		cursor = top;
		return value;
	}
	@Override
	public void show() {
		if (top == -1) {
			throw new IllegalStateException(
					"Stack already emtpy,can not show elements");
		}
		for (int i = top; i >= 0; i--) {
			System.out.println(element[i]);
		}
	}

	@Override
	public void clear() {
		if (top == -1) {
			throw new IllegalStateException("Stack already emtpy,can not clear");
		}
		for (int i = 0; i < top; i++) {
			element[i] = null;
		}
		top = -1;
		cursor = top;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}
	@Override
	public boolean isSpaceAvailable() {
		return !(top == (element.length - 1));
	}
	@Override
	public Object[] toArray() {
		if (top == -1)
			throw new IllegalStateException(
					"Stack already emtpy,can not convert into arrays ");
		return Arrays.copyOf(element, (top + 1));
	}
	@Override
	public boolean search(T value) {
		if (top == -1) {
			throw new IllegalStateException(
					"Stack already emtpy,can not search element " + value);
		}
		if (value == null) {
			throw new IllegalStateException(
					"passed element is null, can not search");
		}
		for (int i = top; i >= 0; i--) {
			if (element[i].equals(value))
				return true;
		}
		return false;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (top == -1) {
			sb.append("empty stack");
			return sb.toString();
		}
		sb.append("[");

		for (int i = top; i >= 0; i--) {
			sb.append(element[i]);
			if (i != 0)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	@Override
	public int indexOf(T value) {
		if(value == null)
			throw new IllegalStateException("Passed element is null , can not return index of it");
		if (top == -1)
			throw new IllegalStateException(
					"Stack already emtpy,can not return index of element "
							+ value);

		for (int i = top; i >= 0; i--) {

			if (element[i].equals(value))
				return i;

		}
		return -1;
	}
	
	@Override
	public int size() {
		return (top + 1);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}
	private class StackIterator implements Iterator<T> {
		
		public boolean hasNext() {
			return !(cursor == -1);
		}

		@SuppressWarnings("unchecked")
		public T nextElement() {
			if (cursor == -1) {
				throw new NoSuchElementException("No element found in stack");
			}
			return (T) element[cursor--];
		}
	}
	@Override
	public int spaceAvailable() {
		return (element.length - size());
	}

	@Override
	public int capacity() {
		return element.length;
	}
	
}
