package algo.practice;

import java.util.HashMap;
import java.util.Map;

public class ReportArmyOfficer {

	int findReportie(int battalion[]){
		
		Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		int count = 0;
		
		int totalReportiOfficers = 0;
		
		// o(n)
		for(int i=0;i<battalion.length;i++){
			
			if(hashMap.containsKey(battalion[i])){
				count = hashMap.get(battalion[i]);
				hashMap.put(battalion[i], ++count);
			}else{
				hashMap.put(battalion[i], 1);
			}
		}
		// find repotiee army officers
		
		for(int i=0;i<battalion.length;i++){
			
			count = battalion[i];
			if(hashMap.containsKey((count-1))){
				totalReportiOfficers+= hashMap.get((count-1));
				hashMap.remove((count-1));
			}
		}
		return totalReportiOfficers;
	}
	
	public static void main(String[] args) {

		int battalion[] = {3,4,3,3,0,2,2,2,0,0,1};
		
		System.out.println(new ReportArmyOfficer().findReportie(battalion));
	}
	

}

