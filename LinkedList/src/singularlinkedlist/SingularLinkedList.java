package singularlinkedlist;

import iterator.Iterator;
import linkedlist.LinkedList;

public class SingularLinkedList<E> implements LinkedList<E>{

	
	private int size;
	private Node header;
	
	@Override
	public void add(E element) {
		if(header == null)
		header = new Node(element,null);
		else{
			Node temp = new Node(element,null);
			Node base = header;
			while(base.next != null)
				base = base.next;
			base.next = temp;
		}
		size++;
	}

	@Override
	public void addAll(LinkedList<E> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAtBeginning(E element) {
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can't add node at beginning");	
		Node temp = new Node(element,header);
		header = temp;
		size++;
	}

	@Override
	public void addAtMiddle(int position, E element) {
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can't add node in the middle");
		
		if(position <=0 || position > (length() + 1))
			throw new IllegalStateException("Wrong position given "+position);
		if(position == 1){
			addAtBeginning(element);
		}
		else if(position == (length() + 1)){
			add(element);
		}
		else{
			Node base = header;
			int i=1;
			while(i <= (position - 1)){
				base = base.next;
				i++;
			}
			Node newNode = new Node(element,base.next);
			base.next = newNode;
			size++;
		}
		
	}

	@Override
	public boolean contains(E element) {
		
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can not perform search operation on linked list");	
		
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not perform search operation on linked list");
		
		Node temp = header;
		while(!(temp.element.equals(element))){
			temp = temp.next;
		}
		return (temp.element.equals(element));
	}

	@Override
	public void delete(E element) {
		
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can not perform delete operation on linked list");
		
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not perform delete operation on linked list");
		
		Node temp = header;
		int counter =0 , position = 0;
		
		while(temp.next != null){
			counter++;
			
			if(temp.element.equals(element)){
				position = counter;
				break;
			}
			temp = temp.next;
		}
		if(position != 0){
			
			if(position == 1){
				deleteAtBeginning();
			}
			else if(position == length()){
				deleteAtEnd();
			}
			else{
				deleteAtMiddle(position);
			}
		}
		
	}

	@Override
	public void deleteAtBeginning() {
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can not delete the node at beginning in linked list");
		Node temp = header;
		header = header.next;
		temp.next = null;
		temp.element = null;
		temp = null;
		size--;
	}

	@Override
	public void deleteAtEnd() {
		
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can not delete the node at the end in linked list");
		
		Node temp = header;
		Node deletedNode = null;
		while(temp.next.next != null)
			temp = temp.next;	
		
		deletedNode = temp.next;
		temp.next = null;
		deletedNode.element = null;
		deletedNode = null;
		size--;
	}

	@Override
	public void deleteAtMiddle(int position) {
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can not delete the node at middle in linked list");
		
		if(position <= 0 || position > (length()) )
			throw new IllegalStateException("Wrong position given "+position);
		
		if(position == 1)
			deleteAtBeginning();
		else if(position == length())
			deleteAtEnd();
		
		else{
			Node temp = header;
			Node deletedNode = null;
			int location = 1;
			while(location < (position - 1)){
				temp = temp.next;
				location++;
			}
			deletedNode = temp.next;
			temp.next = temp.next.next;
			deletedNode.next = null;
			deletedNode.element = null;
			deletedNode = null;
		}
		
	}

	@Override
	public E getElement(int position) {
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can not return the node");
		
		if(position <= 0 || position > (length()) )
			throw new IllegalStateException("Wrong position given "+position);
		
		Node temp = header;
		
		if(position == 1)
			return getFirstElement();
		
		else if(position == (length()) )
		return getLastElement();
		
		else{
			int location = 1;
			while(location < position){
				temp = temp.next;
				location++;
			}
		}
		return temp.element;
	}

	@Override
	public E getFirstElement() {
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can not return the first node");
		return header.element;
	}

	@Override
	public E getLastElement() {
		
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can not return the last node");
		
		Node temp = header;
		while(temp.next != null)
			temp = temp.next;
		
		return temp.element;
	}

	@Override
	public int indexOf(E element) {
		if(header == null)
			throw new IllegalStateException("First node is not created yet,can not return the index of given element in the linked list ");
		
		if(element == null)
			throw new IllegalStateException("Passed element is null , can not return the index of given element in the linked list ");
		
		int index = 1;
		Node temp = header;
		while(!(temp.element.equals(element))){
			temp = temp.next;
			index++;
		}
		return index;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	private class Node{
		E element;
		Node next;
		
		public Node(E element, Node next) {
			super();
			this.element = element;
			this.next = next;
		}
		
	}

}
