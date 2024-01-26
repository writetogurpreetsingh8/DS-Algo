package in.place.reverse.of.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Merge_Kth_SortedLinkedList {

	
	/**
	 * TC O(N log N) / precisely TC O(NK log N)
	 * SC O(K) , here k means length of given arr, and stack space O(1)
	 * this is the Painter_Allocation by PriorityQueue 
	 */
	
	public static Node merge_Kth_SortedLinkedListByPriorityQueue(Node[] arr){
		
		if(arr == null || arr.length == 0) {
			return null;
		}
		
		if(arr.length == 1) {
			return arr[0];
		}
		
		Queue<Node> pq = new PriorityQueue<Node>(Comparator.comparing(Node::getData));
		
		int i=0;
		while(i<arr.length) {
			pq.offer(arr[i]);
			i++;
		}
		
		Node  temp= null,dummy = new Node();
		Node travel = dummy;
		
		while(!pq.isEmpty()) {
			
			temp = pq.poll();
			travel.next = temp;
			
			if(temp.next != null) {
				pq.offer(temp.next);
			}
			travel = travel.next;
		}
		return dummy.next;
	}
	
	/**
	 * TC O(N log N) / precisely TC O(NK log N)
	 * SC O(1) and stack space O(log K)
	 * this is the Painter_Allocation by divide and conquer technique 
	 */
	public static Node merge_Kth_SortedLinkedList(Node[] arr){
		
		if(arr == null || arr.length == 0) {
			return null;
		}
		
		if(arr.length == 1) {
			return arr[0];
		}
		
		return divideKthSortedListUpToSingleList(arr,0,arr.length-1);
		
	}
	
	private static Node divideKthSortedListUpToSingleList(Node[] arr, int start, int end) {
		if(start == end) {
			return arr[start];
		}
		int mid = (start + (end-start)/2); // calculate mid and avoid overflow
		Node left = divideKthSortedListUpToSingleList(arr,start,mid);
		Node right = divideKthSortedListUpToSingleList(arr,mid+1,end);
		return mergingSortedLinkedList(left,right);
	}
	
	private static Node mergingSortedLinkedList(Node first, Node sec) {
		
		Node dummy = new Node();
		Node temp = dummy;
		while(first != null && sec != null) {
			if(first.data > sec.data) {
				temp.next = sec;
				sec = sec.next;
			}else {
				temp.next = first;
				first = first.next;
			}
			temp = temp.next;
		}
		if(first != null) {
			temp.next = first;
		}else {
			temp.next = sec;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		int arr1[] = {0,1,2,3,4,5,100};
		LinkingList list1 = new LinkingList();
		list1.createLinkedList(arr1,-1);
		Node head1 = list1.getHead();
		
		int arr2[] = {1,2,6,8,9};
		LinkingList list2 = new LinkingList();
		list2.createLinkedList(arr2,-1);
		Node head2 = list2.getHead();
		
		int arr3[] = {-1,11,12,31,41,51};
		LinkingList list3 = new LinkingList();
		list3.createLinkedList(arr3,-1);
		Node head3 = list3.getHead();
		
		Node arr[]= {head3,head2,head1};
		Node result = merge_Kth_SortedLinkedListByPriorityQueue(arr);
		System.out.println("result is "+result);
		//-------------------------------------------------------------------------------------------
		
		int arr11[] = {0,1,2,3,4,5,100};
		LinkingList list11 = new LinkingList();
		list11.createLinkedList(arr11,-1);
		Node head11 = list11.getHead();
		
		int arr12[] = {1,2,6,8,9};
		LinkingList list12 = new LinkingList();
		list12.createLinkedList(arr12,-1);
		Node head12 = list12.getHead();
		
		int arr13[] = {-1,11,12,31,41,51};
		LinkingList list13 = new LinkingList();
		list13.createLinkedList(arr13,-1);
		Node head13 = list13.getHead();
		
		Node arr111[]= {head11,head13,head12};
		result = merge_Kth_SortedLinkedList(arr111);
		System.out.println("result is "+result);
	}

}
