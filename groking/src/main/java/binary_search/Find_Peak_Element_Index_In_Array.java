package binary_search;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Deque;
import java.util.UUID;

public class Find_Peak_Element_Index_In_Array {

	public static int find_Peak_Element_Index_In_Array(int arr[]) {
		
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		int start = 0,end = arr.length-1,mid = 0;
		while(start <= end) {
			mid = start + ((end-start)>>1);
			
			if((mid > 0 && mid < arr.length -1) && (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])) {
				return mid;
			}
			else if((mid < arr.length -1) && (arr[mid] > arr[mid+1])) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return mid;
		
	}
	
	public static int find_Peak_Element_Index_In_Array_1(int arr[]) {
		
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		int start = 0,end = arr.length-1,mid=0;
		while(start<end) {
			mid = start + ((end-start)>>1);
			if(arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
			
		}
		return start;
		
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		int arr[]= {0,1,0};
		System.out.println(find_Peak_Element_Index_In_Array(arr)); // 1
		
		int arr1[]= {0,2,1,0};
		System.out.println(find_Peak_Element_Index_In_Array(arr1)); //1
		
		int arr2[]= {0,10,5,2};
		System.out.println(find_Peak_Element_Index_In_Array(arr2)); //1
		
		int arr3[]= {2,4,5,10,9,8,7};
		System.out.println(find_Peak_Element_Index_In_Array(arr3)); //3
		
		int arr4[]= {0,10,5,2,1,0};
		System.out.println(find_Peak_Element_Index_In_Array(arr4)); // 1
		
		int arr5[]= {0,1,2,3,4,5,0};
		System.out.println(find_Peak_Element_Index_In_Array(arr5)); //5
		
		int arr6[]= {0,1,2,3,4,15,10,6,5,3,1,0};
		System.out.println(find_Peak_Element_Index_In_Array(arr6)); // 5
		
		int arr7[]= {10,20,15,2,23,90,67};
		System.out.println(find_Peak_Element_Index_In_Array(arr7)); //5
		
		int arr8[]= {1,2,3,5};
		System.out.println(find_Peak_Element_Index_In_Array(arr8)); //3
		
		int arr9[]= {5,4,2,1}; 
		System.out.println(find_Peak_Element_Index_In_Array(arr9)); //0
		
		int arr10[]= {5,4}; 
		System.out.println(find_Peak_Element_Index_In_Array(arr10)); //0
		
		Calendar cal = Calendar.getInstance();
		java.security.SecureRandom ss = java.security.SecureRandom.getInstance("SHA1PRNG", "SUN");
		System.out.println(ss);
		System.out.println("1 "+Integer.valueOf(ss.nextInt()).toString());
		String big = new BigInteger(120,ss).toString(32);
		System.out.println("2 "+big);
		System.out.println(big.length());
		System.out.println("uu "+UUID.randomUUID().toString().replaceAll("-", ""));
		System.out.println("uu "+UUID.randomUUID().toString());
		System.out.println("uu "+UUID.randomUUID().toString().replaceAll("-", ""));
		System.out.println("uu "+UUID.randomUUID().toString().replaceAll("-", ""));
		System.out.println("uu "+UUID.randomUUID().toString().replaceAll("-", ""));
		System.out.println("uu "+UUID.randomUUID().toString().replaceAll("-", ""));
		System.out.println("uu "+UUID.randomUUID().toString().replaceAll("-", ""));
		System.out.println("uu "+UUID.randomUUID().toString().replaceAll("-", "").length());
		System.out.println("uu "+UUID.randomUUID().toString().length());
		
		Deque<Integer> q = new ArrayDeque<Integer>(5);
		q.addFirst(15);
		int v = q.peekFirst();
		System.out.println("1 extracted element is "+v);
		if(v < 17) {
			q.addFirst(17);
		}
		System.out.println(q.peek());
		System.out.println(q);
		
		v = q.peekFirst();
		System.out.println("2 extracted element is "+v);
		
		if(v > 5) {
			q.addLast(5);
		}
		
		System.out.println(q.peek());
		System.out.println(q);
		
		v = q.peekFirst();
		System.out.println("3 extracted element is "+v);
		
		if(v < 51) {
			q.addFirst(51);
		}
		
		System.out.println(q.peek());
		System.out.println(q);
		System.out.println("size "+q.size());
		
		v = q.peekFirst();
		System.out.println("4 extracted element is "+v);
		
		if(v > 4) {
			q.addLast(4);
		}
		System.out.println(q.peek());
		System.out.println(q);
		System.out.println("size "+q.size());
		
		if(q.size() == 5 ) {
			v = q.peekFirst();
			System.out.println("5 extracted element is "+v);
			if(v < 2) {
				q.removeFirst();
				q.addFirst(77);
				System.out.println(q.peek());
				System.out.println(q);
			}else if(v > 2) {
				q.removeLast();
				q.addLast(2);
				System.out.println(q.peek());
				System.out.println(q);
			}
		}
		
		System.out.println("size final "+q.size());
		
		
	}

}
