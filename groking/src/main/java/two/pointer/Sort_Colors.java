package two.pointer;

import java.io.File;
import java.util.Arrays;

public class Sort_Colors {

	
	static void files(final String path){

		File f = new File(path);
		File contents[] = f.listFiles();
		
		if(contents != null && contents.length > 0){
			for(int i=0;i<contents.length;i++){
				if(contents[i].isDirectory()){
					files((contents[i].getPath()));
				}else{
					System.out.println("file is "+contents[i]);
				}
			}
		}
	}
	
	private static int[] sortColors(int arr[]) {
		
		int tempArray[] = new int [4];
		
		for (int i = 0; i < arr.length; i++) {
			tempArray[arr[i]]++;
		}
		
		int counter=0;
		int index=0,n=-1;
		while (index < arr.length) {
		
			if(counter == 0) {
				n++;
				counter = tempArray[n];
			}
			if(counter > 0) {
				arr[index] = n;
				counter--;
				index++;
			}
		}
		return arr;
		
	}
	
	public static void main(String[] args) {
		
		int arr[] = {0,1,1,2,2,3,0,1,1,2,3};
		System.out.println("unsorted arrays => "+Arrays.toString(arr)+" sorted array=> "+Arrays.toString(sortColors(arr)));
		
		int arr1[] = {1, 0, 2, 1, 0};
		System.out.println("unsorted arrays => "+Arrays.toString(arr1)+" sorted array=> "+Arrays.toString(sortColors(arr1)));
		
		int arr2[] = {2, 2,3, 0, 1, 2, 0,3};
		System.out.println("unsorted arrays => "+Arrays.toString(arr2)+" sorted array=> "+Arrays.toString(sortColors(arr2)));
		
		int arr3[]= {2,3,0};
		System.out.println("unsorted arrays => "+Arrays.toString(arr3)+" sorted array=> "+Arrays.toString(sortColors(arr3)));
		
		//files("D:\\DS\\Educative.io - Grokking the Coding Interview - Patterns for Coding Questions");
	}

}
