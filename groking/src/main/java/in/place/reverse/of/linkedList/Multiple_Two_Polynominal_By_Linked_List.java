package in.place.reverse.of.linkedList;

public class Multiple_Two_Polynominal_By_Linked_List {

	/**
	 * TC O(N^2)
	 * SC O(1)
	 * stack space O(logN)
	 * here N is the size of new list which is length of h1 * length of h2
	 */
	public static Poly multiple_Two_Polynominal_By_Linked_List(Poly h1,Poly h2){
		
		if(h1 == null) {
			return h2;
		}
		if(h2 == null) {
			return h1;
		}
		
		Poly newHead = new Poly();
		Poly dummy = newHead;
		Poly temp = null;
		
		// multiplication of two polynominal
		while(h1 != null) {
			temp = h2;
			while(temp != null) {
				Poly newNode = new Poly();
				newNode.coff = h1.coff * temp.coff;
				newNode.expo = h1.expo + temp.expo;
				newHead.next = newNode;
				newHead = newHead.next;
				temp = temp.next;
			}
			h1 = h1.next;
		}
		System.out.println("before setting order");
		
		printPolynominal(dummy.next);
		newHead = setTheOrderAsDesc(dummy.next);
		
		System.out.println("\n\n after setting order\n");
		printPolynominal(newHead);
		
		simplifyTheTerms(newHead);
		
		System.out.println("\n\n after simplify the terms");
		printPolynominal(newHead);
		
		return newHead;
	}
	
	/**
	 * TC O(N)
	 * SC O(1)
	 * stack space O(1)
	 */
	private static void simplifyTheTerms(Poly newHead) {
		
		Poly traveller = newHead;
		while(traveller.next != null) {
			if(traveller.expo == traveller.next.expo) {
				traveller.coff = traveller.coff + traveller.next.coff;
				traveller.next= traveller.next.next;
			}else {
				traveller = traveller.next;
			}
		}
	}

	/**
	 * TC O(N log N)
	 * SC O(1)
	 * stack space O(logN) 
	 * here n means length of linked-list
	 */
	private static Poly setTheOrderAsDesc(Poly head) {
		
		if(head == null || head.next == null) {
				return head;
		}
		Poly mid = getMid(head);
		Poly left = head;
		Poly right = mid.next;
		mid.next = null;
		left = setTheOrderAsDesc(left);
		right = setTheOrderAsDesc(right);
		return mergingPoly(left,right);
	}
	
	/**
	 * TC O(N)
	 * SC O(1)
	 * stack space O(1)
	 */
	private static Poly getMid(Poly head) {
		
		if(head == null || head.next == null || head.next.next == null) {
			return head;
		}
		
		Poly slow = head, fast = head;
		do {
			slow = slow.next;
			fast = fast.next.next;
		}while(fast != null && fast.next != null);
		
		return slow;
	}

	/**
	 * TC O(min(left,right))
	 * SC O(1)
	 * stack space O(1)
	 */
	private static Poly mergingPoly(Poly left, Poly right) {
		Poly head = new Poly();
		Poly dummy = head;
		
		while(left != null && right != null) {
			if(left.expo < right.expo) {
				head.next = right;
				right = right.next;
			}else{
					head.next = left;
					left = left.next;
			}
			head = head.next;
		}
		if(left != null) {
			head.next = left;
		}else {
			head.next = right;
		}
		return dummy.next;
	}

	//https://www.codingninjas.com/codestudio/library/multiplication-of-two-polynomials-using-linked-list
	/**
	 * TC O(N)
	 * SC O(1)
	 * stack space O(1)
	 */
		private static void printPolynominal(Poly polyLinkedList) {
			
			while(polyLinkedList != null) {
				
				if(polyLinkedList.coff !=0 && polyLinkedList.coff !=1) {
					
					if(polyLinkedList.expo !=0 && polyLinkedList.expo !=1 ) {
						System.out.print(polyLinkedList.coff+"x^"+polyLinkedList.expo+" ");
					}else if(polyLinkedList.expo == 1) {
						System.out.print(polyLinkedList.coff+"x");
					}else {
						System.out.print(" "+polyLinkedList.coff);
					}
				}else if(polyLinkedList.coff == 1 || polyLinkedList.coff == 0) {
					if(polyLinkedList.expo !=0 && polyLinkedList.expo !=1 ) {
						System.out.print("x^"+polyLinkedList.expo+" ");
					}else if(polyLinkedList.expo == 1) {
						System.out.print("x");
					}else {
						System.out.print(" "+polyLinkedList.coff);
					}
				}
				if(polyLinkedList.next != null && polyLinkedList.next.coff >0 ) {
					System.out.print(" + ");
				}
				polyLinkedList = polyLinkedList.next;
			}
		}
		
	public static void main(String[] args) {
		int coff1[] = {3,-6,1,10,12,4};
		int expo1[] = {3,5,1,0,0,1};
		LinkingList list = new LinkingList();
		Poly firstPolyHead =  list.createPolynominalLinkedList(coff1, expo1);
		
		printPolynominal(firstPolyHead);
		
		System.out.println("\n");
		int coff2[] = {-2,3,1,-5,87,5};
		int expo2[] = {3,5,1,0,0,1};
		Poly secPolyHead =  list.createPolynominalLinkedList(coff2, expo2);
		printPolynominal(secPolyHead);
		
		System.out.println("\n");
		
		multiple_Two_Polynominal_By_Linked_List(firstPolyHead,secPolyHead);
		
	}

}
