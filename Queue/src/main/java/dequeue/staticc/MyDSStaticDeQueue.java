package dequeue.staticc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

import dequeue.interfacee.IteratorBottom;
import dequeue.interfacee.IteratorTop;

public class MyDSStaticDeQueue<E> implements MyDSStaticDeQueueInterface<E> {

	
	private int rearBottom,rearTop;
	private int frontBottom,frontTop;
	private Object[] elements;
	
	public MyDSStaticDeQueue() {
		this(5);
	}
	
	public MyDSStaticDeQueue(int initialCapacity) {
		if(initialCapacity <= 0 )
			throw new IllegalArgumentException(
			"inital capacity of stack can not be negative/zero");	
		elements = new Object[initialCapacity];
		rearBottom =  frontBottom = -1;
		rearTop = frontTop = elements.length;
	}

	@Override
	public int capacity() {
		return elements.length;
	}

	@Override
	public boolean isSapaceAvailableBottom() {
		return (rearBottom != (rearTop - 1));
	}

	@Override
	public boolean isSapaceAvailableTop() {
		return (rearTop != (rearBottom + 1));
	}

	@Override
	public int spaceAvailableBottom() {
		return (rearTop - sizeBottom());
	}

	@Override
	public int spaceAvailableTop() {
		return spaceAvailableBottom();
	}

	@Override
	public void clearBottom() {
		if(rearBottom == frontBottom){
			rearBottom = frontBottom = -1;
			throw new IllegalStateException("DeQueue already emtpy at bottom ,can not clear");
		}	
		for(int i=(frontBottom + 1); i <= rearBottom; i++){
			elements[i] = null;
		}
		rearBottom = frontBottom = -1;
	}

	@Override
	public void clearTop() {
		if(rearTop == frontTop){
			rearTop = frontTop = elements.length;
			throw new IllegalStateException("DeQueue already emtpy at top ,can not clear");
		}	
		for(int i=(frontTop + 1); i <= rearTop; i++){
			elements[i] = null;
		}
		rearTop = frontTop = elements.length;
	}

	@Override
	public int indexOfBottom(E element) {
		
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not return index of it");
		
		if(rearBottom == frontBottom){
			throw new IllegalStateException("DeQueue is emtpy at bottom,can not return the index of given element "+element);
		}
		
		for(int i=(frontBottom + 1); i <= rearBottom; i++){
			if (elements[i].equals(element))
				return i;
		}
		return -1;
	}

	@Override
	public int indexOfTop(E element) {
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not return index of it");
		
		if(rearTop == frontTop){
			throw new IllegalStateException("DeQueue is emtpy at top ,can not return the index of given element "+element);
		}
		
		for(int i=(frontTop + 1); i <= rearTop; i++){
			if (elements[i].equals(element))
				return i;
		}
		return -1;
	}

	@Override
	public boolean isEmptyBottom() {
		return (rearBottom == frontBottom);
	}

	@Override
	public boolean isEmptyTop() {
		return (rearTop == frontTop);
	}

	@Override
	public E popBottom() {
		if( (rearBottom == frontBottom) || (rearBottom == (rearTop - 1)) ){
			rearBottom = frontBottom = -1;
			throw new IndexOutOfBoundsException("Queue is underflow");
		}	
		E element = (E)elements[++frontBottom];
		elements[frontBottom] = null;
		return element;
	}

	@Override
	public E popTop() {
		if( (rearTop == frontTop) || (rearTop == rearBottom + 1) ){
			rearBottom = frontBottom = elements.length;
			throw new IndexOutOfBoundsException("Queue is underflow");
		}	
		E element = (E)elements[--frontTop];
		elements[frontTop] = null;
		return element;
	}

	@Override
	public void pushBottom(E element) {
		if(element == null)
			throw new IllegalStateException("Passed element is null at bottom , null not allowed to store in de-queue ");
		
		if(rearBottom == (elements.length - 1) || (rearBottom == (rearTop - 1)))
			throw new IndexOutOfBoundsException("Dequeue is overflow at bottom");
		elements[++rearBottom] = element;
		
	}

	@Override
	public void pushTop(E element) {
		if(element == null)
			throw new IllegalStateException("Passed element is null at top , null not allowed to store in de-queue ");
		
		if(rearTop == 0 || (rearTop == (rearBottom + 1)))
			throw new IndexOutOfBoundsException("Dequeue is overflow at top");
		elements[--rearTop] = element;
	}

	@Override
	public boolean searchBottom(E element) {
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not search it");
		
		if(rearBottom == frontBottom){
			throw new IllegalStateException("DeQueue is emtpy at bottom ,can not search the given element "+element);
		}
		for(int i=(frontBottom + 1); i <= rearBottom; i++){
			if (elements[i].equals(element))
				return true;
		}
		return false;
	}

	@Override
	public boolean searchTop(E element) {
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not search it");
		
		if(rearTop == frontTop){
			throw new IllegalStateException("DeQueue is emtpy at top ,can not search the given element "+element);
		}
		for(int i=(frontTop + 1); i <= rearTop; i++){
			if (elements[i].equals(element))
				return true;
		}
		return false;
	}
	@Override
	public int sizeBottom() {
		return (rearBottom + 1);
	}
	@Override
	public int sizeTop() {
		return (elements.length - rearTop);
	}
	@Override
	public void showTop() {
		if(rearTop == frontTop)
			throw new IllegalStateException("DeQueue is emtpy at top,can not show elements");
		for(int i=(frontTop + 1); i <= rearTop; i++)
			System.out.println("DeQueue elements are at top "+elements[i]);
	}
	@Override
	public void showBottom() {
		if(rearBottom == frontBottom)
			throw new IllegalStateException("DeQueue is emtpy at bottom,can not show elements");
		for(int i=(frontBottom + 1); i <= rearBottom; i++)
			System.out.println("DeQueue elements are at top "+elements[i]);
		
	}
	@Override
	public Object[] toArrayBottom() {
		if(rearBottom == frontBottom)
			throw new IllegalStateException("DeQueue is emtpy at bottom,can not convert it into array");
		return Arrays.copyOf(elements, sizeBottom());
	}

	@Override
	public Object[] toArrayTop() {
		if(rearTop == frontTop)
			throw new IllegalStateException("DeQueue is emtpy at top,can not convert it into array");
		Object[] array = (Object[])Array.newInstance(elements.getClass().getComponentType(), sizeTop());
		System.arraycopy(elements, rearTop, array, 0, sizeTop());
		return array;
	}

	@Override
	public String toStringBottom() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=(frontBottom + 1); i <= rearBottom; i++){
			sb.append(elements[i]);
			if(i!=rearBottom)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public String toStringTop() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=(frontTop - 1); i <= rearTop; i--){
			sb.append(elements[i]);
			if(i!=rearTop)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public IteratorBottom<E> iteratorBottom() {
		return new DeQueueIteratorBottom();
	}
	
	@Override
	public IteratorTop<E> iteratorTop() {
		return new DeQueueIteratorTop();
	}
	private class DeQueueIteratorBottom implements IteratorBottom<E>{

		private int cursor = 0;
		@Override
		public boolean hasBottom() {
			return (cursor != sizeBottom());
		}

		@Override
		public E nextBottom() {
			if(cursor == sizeBottom())
				throw new NoSuchElementException("No element found in DeQueue");
			return (E)elements[cursor++];
		}
		
	}
	
	private class DeQueueIteratorTop implements IteratorTop<E>{

		private int cursor = 0;
		@Override
		public boolean hasTopElement() {
			return (cursor != sizeTop());
		}

		@Override
		public E nextTopElement() {
			if(cursor == sizeTop())
				throw new NoSuchElementException("No element found in DeQueue");
			return (E)elements[cursor++];
		}
		
	}
}
