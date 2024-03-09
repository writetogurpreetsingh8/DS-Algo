package queue;

public class CircularTour {
	
	
	/**
	 * TC O(N)
	 * aux-space O(1)
	 * system stack O(1)
	 * in worst case also we just need to traverse entire array once
	 */
	private static int circularTour1(int[] gas, int[] cost) {

		if((gas == null || cost == null) || 
				(gas.length == 0 || cost.length == 0)) {
			return -1;
		}
		
		int balance=0,i=0,start=0,underFlowBalance=0;
		
		while(i<gas.length) {
			balance+= (gas[i]) - cost[i];
			if(balance < 0){
				underFlowBalance+=balance;
				balance = 0;
				start = i+1;
			}
			i++;
		}
		return (balance-underFlowBalance) >=0 ? start : -1;
	}

	/**
	 * TC O(N)
	 * aux-space O(1)
	 * system stack O(1)
	 * in worst case(if circular tour is not possible) we need to traverse each element of array twice
	 */
	private static int circularTour0(int[] gas, int[] cost) {
		
		if((gas == null || cost == null) || 
				(gas.length == 0 || cost.length == 0)) {
			return -1;
		}
		
		int rear=0, front=-1,balance=0,circle=0,diff=0;
		
		while((rear != front && circle != 2)) {
			balance+= (gas[rear] - cost[rear]);
			if(balance < 0) {
				balance = 0;
				front = rear;
			}
			rear = (rear+1)%gas.length;
			if(rear == 0) {
				front++;
				circle++;
			}
		}
		if(circle == 2) {
			return -1;
		}
		return front;
	}
	public static void main(String[] args) {
		
		int[] gas= {2,3,4};
		int[] cost= {3,4,3};
		System.out.println(circularTour0(gas,cost)); //-1
		System.out.println(circularTour1(gas,cost));
		
		int[] gas1= {6,7,4,10,6,5};
		int[] cost1= {5,6,7,8,6,4};
		System.out.println(circularTour0(gas1,cost1)); //3 
		System.out.println(circularTour1(gas1,cost1));
		
		int[] gas2= {1,2,3,4,5};
		int[] cost2= {3,4,5,1,2};
		System.out.println(circularTour0(gas2,cost2)); //3
		System.out.println(circularTour1(gas2,cost2));
		

	}

}
