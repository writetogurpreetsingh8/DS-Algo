package recursion;

public class TowerOfHanoi {

	private static int call;
	
	public static void TOH(int plates,char sourcePiller,char distinationPiller,char helperPiller) {
		
		call++;
		if(plates == 1) {
			System.out.println("move plate "+plates+" from sourece "+sourcePiller+" to "+distinationPiller);
			return;
		}
		TOH(plates-1,sourcePiller,helperPiller,distinationPiller);
		System.out.println("move plate "+plates+" from sourece "+sourcePiller+" to "+distinationPiller);
		TOH(plates-1,helperPiller,distinationPiller,sourcePiller);
	}
		
	public static void main(String[] args) {
		
		TowerOfHanoi.TOH(3,'S','D','H');
		System.out.println("total moves... "+call);
	}

}
