package in.place.reverse.of.linkedList;

public class Add_Two_Polynominal_By_Linked_List {

	/**
	 * TC O(min(L1,L2))
	 * SC O(min(L1,L2))
	 * stack space O(1)
	 * @param first
	 * @param sec
	 */
	public static void add_Two_Polynominal_By_Linked_List(Poly first,Poly sec) {
		
		
		if(first == null) {
			printPolynominal(sec);
		}
		else if(sec == null) {
			printPolynominal(first);
		}
		
		Poly dummy = new Poly();
		Poly travel = dummy;
		
		while( first != null && sec != null) {
			if(first.expo == sec.expo) {
				Poly newNode = new Poly();
				newNode.expo = first.expo;
				newNode.coff = (sec.coff + first.coff);
				travel.next = newNode;
				first = first.next;
				sec = sec.next;
			}
			else if(first.expo > sec.expo) {
				travel.next = first;
				first = first.next;
			}else {
				travel.next = sec;
				sec = sec.next;
			}
			travel = travel.next;
		}
		
		if(sec != null) {
			travel.next = sec;
		}else {
			travel.next = first;
		}
		
		printPolynominal(dummy.next);
	}
	
	//https://www.codingninjas.com/codestudio/library/multiplication-of-two-polynomials-using-linked-list
	private static void printPolynominal(Poly polyLinkedList) {
		
		while(polyLinkedList != null) {
			
			if(polyLinkedList.coff !=0 && polyLinkedList.coff !=1) {
				
				if(polyLinkedList.expo !=0 && polyLinkedList.expo !=1 ) {
					System.out.print(polyLinkedList.coff+"x^"+polyLinkedList.expo);
				}else if(polyLinkedList.expo == 1) {
					System.out.print(polyLinkedList.coff+"x");
				}else {
					System.out.print(polyLinkedList.coff);
				}
			}else if(polyLinkedList.coff == 1 || polyLinkedList.coff == 0) {
				if(polyLinkedList.expo !=0 && polyLinkedList.expo !=1 ) {
					System.out.print("x^"+polyLinkedList.expo);
				}else if(polyLinkedList.expo == 1) {
					System.out.print("x");
				}else {
					System.out.print(polyLinkedList.coff);
				}
			}
			if(polyLinkedList.next != null && polyLinkedList.next.coff >0 ) {
				System.out.print("+");
			}
			polyLinkedList = polyLinkedList.next;
		}
	}

	public static void main(String[] args) {
		
		int coff1[] = {0,3,-6,1,10};
		int expo1[] = {5,3,2,1,0};
		LinkingList list = new LinkingList();
		Poly firstPolyHead =  list.createPolynominalLinkedList(coff1, expo1);
		System.out.println(firstPolyHead);
		
		int coff2[] = {0,-2,3,1,-5};
		int expo2[] = {5,3,2,1,0};
		Poly secPolyHead =  list.createPolynominalLinkedList(coff2, expo2);
		System.out.println(secPolyHead);
		
		add_Two_Polynominal_By_Linked_List(firstPolyHead,secPolyHead);
		
		//-> multiplication of poly
		//https://www.youtube.com/watch?v=_XjzQzZY2gg 
		//https://www.youtube.com/watch?v=bNWPciD7ogg 
		
		// add two number represented by linked-list
		//https://www.youtube.com/watch?v=j36ETLmbr_w
		
		
	}

}
