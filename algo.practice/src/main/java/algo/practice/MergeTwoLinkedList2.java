package algo.practice;

public class MergeTwoLinkedList2 {

	/**
	 * 
	 * @param head1
	 * @param head2 
	 * by sachin
	 */
	static Node mergeTwoSortedLinkedList(Node h1, Node h2) {
		
		if (h1.getNext() == null) { 
            h1.setNext(h2); 
            return h1; 
        } 
		
		Node curr1 = h1, next1 = h1.getNext(); 
        Node curr2 = h2, next2 = h2.getNext(); 
		
        while (next1 != null && curr2 != null) { 
            // if curr2 lies in between curr1 and next1 
            // then do curr1->curr2->next1 
            if ((curr2.getData()) >= (curr1.getData()) && (curr2.getData()) <= (next1.getData())) { 
                next2 = curr2.getNext(); 
                curr1.setNext(curr2); 
                curr2.setNext(next1); 
  
                // now let curr1 and curr2 to point 
                // to their immediate next pointers 
                curr1 = curr2; 
                curr2 = next2; 
            } 
            else { 
                // if more nodes in first list 
                if (next1.getNext() != null) { 
                    next1 = next1.getNext(); 
                    curr1 = curr1.getNext(); 
                } 
  
                // else point the last node of first list 
                // to the remaining nodes of second list 
                else { 
                    next1.setNext(curr2); 
                    return h1; 
                } 
            } 
        } 
        return h1; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array1[] = {1,4,6,7,8,9};
		Node list1 = new LinkingList().createLinkedList(array1);
		System.out.println(list1);
		
		int array2[] = {0,2,3,8,10,11};
		Node list2 = new LinkingList().createLinkedList(array2);
		System.out.println(list2);
		
		
		System.out.println("after merging... "+MergeTwoLinkedList2.mergeTwoSortedLinkedList(list1, list2));
		
		System.out.println(list1);
		System.out.println(list2);
		


	}

}
