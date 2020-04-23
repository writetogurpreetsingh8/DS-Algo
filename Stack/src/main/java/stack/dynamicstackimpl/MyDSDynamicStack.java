package stack.dynamicstackimpl;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import stack.stackinterface.Iterator;
import stack.stackinterface.Stack;

public class MyDSDynamicStack<E> implements MyDSDynamicStackInterface<E> {

	Object elements[];
	int top;
	int cursor;

	public MyDSDynamicStack() {
		this(5);
	}

	public MyDSDynamicStack(int initialCapacity) {
		if(initialCapacity <= 0 )
			throw new IllegalArgumentException(
			"inital capacity of stack can not be negative/zero");	
		elements = new Object[initialCapacity];
		top = -1;
	}

	@Override
	public void push(E element) {
		ensureCapacity((top + 1));
		elements[++top] = element;
		cursor = top;
	}

	@Override
	public E pop() {
		if (top == -1)
			throw new IndexOutOfBoundsException("Stack is underflow");
		E value = (E) elements[top];
		elements[top] = null;
		top--;
		cursor = top;
		return value;

	}

	@Override
	public void show() {
		if (top == -1)
			throw new IllegalStateException(
					"Stack already emtpy,can not display elements");

		for (int i = top; i >= 0; i--) {
			System.out.println(elements[top]);
		}
	}
	@Override
	public void clear() {
		if (top == -1)
			throw new IllegalStateException("Stack already emtpy,can not clear");

		for (int i = 0; i < top; i++) {
			elements[i] = null;
		}
		top = -1;
		cursor = top;

	}

	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	@Override
	public boolean search(E element) {

		if (top == -1)
			throw new IllegalStateException(
					"Stack already emtpy,can not search element " + element);
		if (element == null)
			throw new IllegalStateException(
					"passed element is null, can not search");

		for (int i = top; i >= 0; i--) {
			if (elements[top].equals(element))
				return true;
		}
		return false;
	}

	void ensureCapacity(int minimumCapacity) {

		if (minimumCapacity >= elements.length) {
			System.out
					.println("capacity of dynamic stack is reached at up to the mark");
			int newCapacity = (elements.length * 2);
			if (newCapacity < minimumCapacity)
				newCapacity = minimumCapacity;
			/*if (newCapacity > minimumCapacity)
				newCapacity = minimumCapacity;*/
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}
	@Override
	public Object[] toArray() {
		if (top == -1)
			throw new IllegalStateException(
					"Stack already emtpy,can not convert into arrays ");
		return Arrays.copyOf(elements, (top+1));
	}
	@Override
	public int indexOf(E element) {
		if (top == -1)
			throw new IllegalStateException(
					"Stack already emtpy,can not return index of element "
							+ element);

		for (int i = top; i >= 0; i--) {

			if (elements[i].equals(element))
				return i;

		}
		return -1;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (top == -1) {
			sb.append("empty stack");
			return sb.toString();
		}
		sb.append("[");

		for (int i = top; i >= 0; i--) {
			sb.append(elements[i]);
			if (i != 0)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public void addAll(Stack<E> stack) {
		if (stack == null)
			throw new IllegalStateException(
					"Passed stack object is null, can not merge");
		if (stack == this)
			throw new IllegalStateException("Stack can not merge itself");
		if (!(stack instanceof Stack))
			throw new IllegalStateException("Passed object must be Stack type");
		if(stack.isEmpty())
			throw new IllegalStateException("Passed stack object is empty , can not merge");
		
		Object[] data = stack.toArray();
		int newCapacity = (size() + stack.size());
		ensureCapacity(newCapacity);
		System.arraycopy(data, 0, elements, (top + 1), data.length);
		top += data.length;
		
	}
	
	@Override
	public int size() {
		return (top + 1);
	}
	
	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {
			return !(cursor == -1);
		}

		@Override
		public E nextElement() {
			if (cursor == -1)
				throw new NoSuchElementException("No element found in stack");
			return (E) elements[cursor--];
		}

	}

	@Override
	public int capacity() {
		return elements.length;
	}

}
