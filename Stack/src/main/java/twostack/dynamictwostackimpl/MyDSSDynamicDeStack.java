package twostack.dynamictwostackimpl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

import twostack.twostackinterface.DeStack;
import twostack.twostackinterface.IteratorBottom;
import twostack.twostackinterface.IteratorTop;

public class MyDSSDynamicDeStack<T> implements MyDSDynamicDeStackInterface<T>{

	private Object elements[];
	private int top;
	private int bottom;
	private int cursorTop;
	private int cursorBottom;
	
	public MyDSSDynamicDeStack() {
		this(5);
	}
	
	public MyDSSDynamicDeStack(int capacity) {
		if(capacity <= 0 )
			throw new IllegalArgumentException(
			"inital capacity of de-stack can not be negative/zero");	
		elements = new Object[capacity];
		top = elements.length;
		bottom = -1;
	}
	
	@Override
	public void clearBottom() {
		if(bottom == -1)
			throw new IllegalStateException("DeStack already emtpy from bottom,can not clear");
		for(int i=bottom;i>=0;i--){
			elements[bottom]=null;
		}
		bottom = -1;
		cursorBottom = bottom;
	}

	@Override
	public void clearTop() {
		if(top == elements.length)
			throw new IllegalStateException("DeStack already emtpy from top,can not clear");
		for(int i=top;i < elements.length;i++){
			elements[top]=null;
		}
		top = elements.length;
		cursorTop = top;
		
	}

	@Override
	public int indexOfBottom(T value) {
		if(bottom == -1)
			throw new IllegalStateException(
					"DeStack already emtpy from bottom,can not return index of element "
							+ value);
		for(int i=bottom; i>=0; i--){
			if (elements[i].equals(value))
				return i;
		}
		return -1;
	}

	@Override
	public int indexOfTop(T value) {
		if(top == elements.length)
		throw new IllegalStateException(
				"DeStack already emtpy from top,can not return index of element "
						+ value);
	for(int i=top; i<elements.length; i++){
		if (elements[i].equals(value))
			return i;
	}
	return -1;
	}

	@Override
	public boolean isEmptyBottom() {
		return (bottom == -1);
	}

	@Override
	public boolean isEmptyTop() {
		return (top == elements.length);
	}

	@Override
	public T popBottom() {
		if(bottom == -1)
			throw new IndexOutOfBoundsException("DeStack is underflow at bottom");
		T element =  (T)elements[bottom];
		elements[bottom] = null;
		bottom--;
		cursorBottom = bottom;
		return element;
		
	}

	@Override
	public T popTop() {
		if(top == elements.length)
			throw new IndexOutOfBoundsException("DeStack is underflow at top");
		T element =  (T)elements[top];
		elements[top] = null;
		top++;
		cursorTop = top;
		return element;
	}

	@Override
	public void pushBottom(T item) {
		ensureCapacityAtBottom(bottom);
		elements[++bottom] = item;
		cursorBottom = bottom;
	}

	@Override
	public void pushTop(T item) {
		ensureCapacityAtTop(top);
		elements[--top] = item;
		cursorTop = top;
	}

	private void ensureCapacityAtBottom(int minimumCapacity){
		if(minimumCapacity >= (top - 1)){
			System.out.println("capacity of dynamic stack from bottom is reached at up to the mark");
			int newCapacity = (sizeBottom() * 2) + (elements.length - top);
			if(newCapacity < minimumCapacity)
				newCapacity = minimumCapacity;
			
				Object[] temp = (Object[])Array.newInstance(elements.getClass().getComponentType(), newCapacity);
				System.arraycopy(elements, 0, temp, 0, sizeBottom());
				System.arraycopy(elements, top, temp, (newCapacity - (elements.length - top)), (elements.length - top));
				top = (newCapacity - (elements.length - top));
				elements = temp;
		}
	}
	private void ensureCapacityAtTop(int minimumCapacity){
		if(minimumCapacity <= sizeBottom()){
			System.out.println("capacity of dynamic stack from bottom is reached at up to the mark");
			int newCapacity = (sizeTop() * 2) + (elements.length - sizeTop());
			if(newCapacity < minimumCapacity)
				newCapacity = minimumCapacity;
			
			Object[] temp = (Object[])Array.newInstance(elements.getClass().getComponentType(), newCapacity);
			System.arraycopy(elements, 0, temp, ((top != 0 ) ? 0 : sizeTop()),(top == 0 ? elements.length - top : elements.length - sizeTop())); 
			System.arraycopy(elements, (top == 0 ? 0 : elements.length - sizeTop()), temp, (newCapacity - (elements.length - top)), (top == 0 ? (elements.length - sizeTop()) : (elements.length - top)));
			top = (newCapacity - (elements.length - top));
			elements = temp;
		}
	}
	
	
	@Override
	public boolean searchBottom(T value) {
		if(bottom == -1)
		throw new IllegalStateException(
				"DeStack already emtpy from bottom,can not search element " + value);
		
		if (value == null) {
			throw new IllegalStateException(
					"passed element is null, can not search");
		}
		
		for(int i=bottom; i>=0; i--){
			return (elements[i].equals(value));
		}
		return false;
	}

	@Override
	public boolean searchTop(T value) {
		if(top == elements.length)
			throw new IllegalStateException(
					"DeStack already emtpy from top,can not search element " + value);
			
			if (value == null) {
				throw new IllegalStateException(
						"passed element is null, can not search");
			}
			
			for(int i=top; i<elements.length; i++){
				return (elements[i].equals(value));
			}
			return false;
	}

	@Override
	public void showBottom() {
		if(bottom == -1)
			throw new IllegalStateException(
			"DeStack already emtpy from bottom,can not show elements");
		for(int i=bottom; i>=0; i--){
			System.out.println(elements[i]);
		}
	}

	@Override
	public void showTop() {
		if(top == elements.length)
			throw new IllegalStateException(
			"DeStack already emtpy from top,can not show elements");
		for(int i=top; i<elements.length; i++){
			System.out.println(elements[i]);
		}
	}

	@Override
	public int sizeBottom() {
		return (bottom + 1);
	}

	@Override
	public int sizeTop() {
		return (elements.length - top);
	}

	@Override
	public Object[] toArrayBottom() {
		if (bottom == -1)
			throw new IllegalStateException(
					"DeStack already emtpy from bottom ,can not convert into arrays ");
		return Arrays.copyOf(elements, (bottom + 1));
	}

	@Override
	public Object[] toArrayTop() {
		if (top == elements.length)
			throw new IllegalStateException(
					"DeStack already emtpy from top ,can not convert into arrays ");
		Object[] deStackTopArray = (Object[])Array.newInstance(elements.getClass().getComponentType(), (elements.length - top));
		System.arraycopy(elements, top, deStackTopArray, 0, (elements.length - top));
		return deStackTopArray;
	}

	@Override
	public int capacity(){
		return elements.length;
	}

	@Override
	public String toStringTop(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=top; i<elements.length; i++){
			sb.append(elements[i]);
			if(elements.length > (i + 1))
			sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public String toStringBottom() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=bottom; i>=0; i--){
			sb.append(elements[i]);
			if(i != 0)
			sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	@Override
	public IteratorBottom<T> iteratorBottom() {
		return new DeStackIteratorBottom();
	}
	
	@Override
	public IteratorTop<T> iteratorTop() {
		return new DeStackIteratorTop();
	}
	
	private class DeStackIteratorBottom implements IteratorBottom<T>{

		@Override
		public boolean hasBottomElement() {
			return !(cursorBottom == -1);
		}

		@Override
		public T nextBottomElement() {
			if(cursorBottom == -1)
			throw new NoSuchElementException("No element found in DeStack at bottom");
			return (T)elements[cursorBottom--];
		}
		
	}
	private class DeStackIteratorTop implements IteratorTop<T>{

		@Override
		public boolean hasTopElement() {
			return !(cursorTop == elements.length);
		}
		@Override
		public T nextTopElement() {
			if(cursorTop == elements.length)
				throw new NoSuchElementException("No element found in DeStack at top");
				return (T)elements[cursorTop++];
		}
		
	}
	@Override
	public void addAllAtBottom(DeStack<T> deStack) {
		if(deStack == null)
			throw new IllegalStateException("Passed DeStack object is null, can not merge");
		if (deStack == this)
			throw new IllegalStateException("DeStack can not merge itself");
		
		if (!(deStack instanceof DeStack))
			throw new IllegalStateException("Passed object must be type of DeStack");
		
		if (deStack.isEmptyBottom())
			throw new IllegalStateException("DeStack empty at bottom can not merge");
		
		int newCapacity = (deStack.sizeBottom() + sizeBottom() + sizeTop());
		ensureCapacityAddAllAtBottom(newCapacity,deStack);
		
	}

	private void ensureCapacityAddAllAtBottom(int minimumCapacity,DeStack<T> deStack){
		if(minimumCapacity > capacity()){
			int newCapacity = (minimumCapacity * 2);
			Object[] temp = (Object[])Array.newInstance(Object.class, newCapacity);
			System.arraycopy(elements, 0, temp, 0, sizeBottom());
			System.arraycopy(deStack.toArrayBottom(), 0, temp, sizeBottom(), deStack.sizeBottom());
			System.arraycopy(elements, top, temp, newCapacity - sizeTop(), sizeTop());
			elements = temp;
			top = newCapacity - sizeTop();
		}
		else{
			System.arraycopy(deStack.toArrayBottom(), 0, elements, sizeBottom(), deStack.sizeBottom());
		}
	}
	@Override
	public void addAllAtTop(DeStack<T> deStack) {
		if(deStack == null)
			throw new IllegalStateException("Passed DeStack object is null, can not merge");
		if (deStack == this)
			throw new IllegalStateException("DeStack can not merge itself");
		
		if (!(deStack instanceof DeStack))
			throw new IllegalStateException("Passed object must be type of DeStack");
		
		if (deStack.isEmptyBottom())
			throw new IllegalStateException("DeStack empty at top can not merge");
		
		int newCapacity = (deStack.sizeTop() + sizeBottom() + sizeTop());
		ensureCapacityAddAllAtTop(newCapacity,deStack);
		
	}
	private void ensureCapacityAddAllAtTop(int minimumCapacity,DeStack<T> deStack){
		if(minimumCapacity > capacity()){
			int newCapacity = (minimumCapacity * 2);
			Object[] temp = (Object[])Array.newInstance(Object.class, newCapacity);
			System.arraycopy(elements, 0, temp, ((top != 0 ) ? 0 : (newCapacity - sizeTop()) ), (top == 0 ? elements.length - top : elements.length - sizeTop()));
			System.arraycopy(deStack.toArrayBottom(), 0, temp, (newCapacity -  (sizeTop() + deStack.sizeTop())), deStack.sizeTop());
			System.arraycopy(elements, top, temp, newCapacity - sizeTop(), ((top == 0) ? 0 : sizeTop()));
			top = (newCapacity -  (sizeTop() + deStack.sizeTop()));
			elements = temp;
		}
		else{
			System.arraycopy(deStack.toArrayBottom(), 0, elements, sizeBottom(), deStack.sizeBottom());
		}
	}
	
}

