package stacks;

/**
 * Leet-Code# 42
 * @author Tony.Stark
 *
 */
public class Rain_Water_Trapping_I {

	public static int rain_Water_Trapping(int[] buildingHeights) {
		
		if(buildingHeights == null || buildingHeights.length == 0) {
			return -1;
		}
		
		// max height of building from left
		int heightFromLeft[] = new int[buildingHeights.length];
		
		// max height of building from right
		int heightFromRight[] = new int[buildingHeights.length];
		
		int totalTrapWater = 0;
		
		//find max height of each building from left & right in the same loop (single loop)
		heightFromLeft[0] = buildingHeights[0];
		heightFromRight[buildingHeights.length-1] = buildingHeights[buildingHeights.length-1];
		
		for (int i = 1, j=buildingHeights.length-2; i < buildingHeights.length; i++, j--) {
			heightFromLeft[i] = Math.max(heightFromLeft[i-1], buildingHeights[i]);
			heightFromRight[j] = Math.max(heightFromRight[j+1], buildingHeights[j]);
		}
		
		//find minimum from each building height and subtract them into building heights
		// than submission all the values as final answer
		
		for (int i = 0; i < buildingHeights.length; i++) {
			totalTrapWater+= Math.abs(Math.min(heightFromLeft[i], heightFromRight[i]) - buildingHeights[i]);
		}

		
		return totalTrapWater;
	}
	public static void main(String[] args) {
		
		int buildingHeight[] = {3,0,0,2,0,4};
		System.out.println(rain_Water_Trapping(buildingHeight));
		
		int buildingHeight1[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(rain_Water_Trapping(buildingHeight1));
		
		int buildingHeight2[] = {0,1,1,2,1,0,1,3,2,1,2,1};
		System.out.println(rain_Water_Trapping(buildingHeight2));
	}

}
