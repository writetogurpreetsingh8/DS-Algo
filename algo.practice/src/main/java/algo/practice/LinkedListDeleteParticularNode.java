package algo.practice;

public class LinkedListDeleteParticularNode {
	
	
	/**
	 * delete given node into linked-list...
	 * @param list
	 * @param val
	 * @return
	 */
	static Node delete(Node list,int val) {
			
		if(list == null) {
			return list;
		}
		if(list.getNext() == null && list.getData() == val) {
			list = null;
			return list;
		}
		
		Node temp = list;
		Node temp1 = null;
		
		while(temp != null) {
			
			if(temp.getData() == val && temp == list) {
				list = temp.getNext();
			}else if(temp.getData() == val){
					temp1.setNext(temp.getNext());
			}else {
				temp1 = temp;
			}
			temp = temp.getNext();
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {1,3,3,3,3,4,5,6,7,8,3,3,3,1,2};
		Node list = new LinkingList().createLinkedList(array);
		System.out.println(list);
		//System.out.println(ReverseLinkedList.reverList(list));
		System.out.println("out put "+LinkedListDeleteParticularNode.delete(list, 3));
	}

}
