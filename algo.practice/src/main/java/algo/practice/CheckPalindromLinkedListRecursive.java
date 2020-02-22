package algo.practice;

import java.util.LinkedList;
import java.util.Queue;

// recursive approach with queue...........
public class CheckPalindromLinkedListRecursive {

	Queue<Integer> queue = new LinkedList<Integer>();
	boolean isPalindorm = false;
	int size = 0;
	
	boolean checkPalindrom(Node node,int size){
	
		if(node == null){
			return false;
		}
		if(size == 0){
			return true;
		}
		
		if(this.size > 0){
			queue.offer(node.getData());
			this.size--;
		}
		checkPalindrom(node.getNext(),size);
		
		if(queue != null && !queue.isEmpty()){
			
			Integer data = queue.poll();
			if(null != data && data != node.getData()){
				isPalindorm  = false;
				queue = null;
			}
			else{
				isPalindorm = true;
			}
		}
		return isPalindorm;
	}
	
	boolean checkPalindromList(LinkingList linkingList){
		this.size = linkingList.getSize()/2;
		return checkPalindrom(linkingList.getHead(),this.size);
	}
	
	public static void main(String[] args) {
		LinkingList linkingList = new LinkingList();
		linkingList.createLinkedList(new int[]{5,1,1,5,3});
		System.out.println(new CheckPalindromLinkedListRecursive().checkPalindromList(linkingList));
		
	}

}
