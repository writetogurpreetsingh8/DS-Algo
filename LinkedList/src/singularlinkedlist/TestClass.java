package singularlinkedlist;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SingularLinkedList<Integer> list = new  SingularLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		System.out.println(list);
		
		//list.addAtBeginning(0);
		//System.out.println(list);
		
		list.addAtMiddle(3, 20);
		System.out.println(list);
		
	}

}
