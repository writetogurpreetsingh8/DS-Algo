package interview.bit;

public class MiniStepInInfinityGrid {

    public static int coverPoints(int[] a, int[] b) {
        int cr = a[0];
        int cc = b[0];
        int steps = 0;
        for(int i=1;i<a.length; i++){
            
            int dr = a[i];
            int dc = b[i];
            
            steps += Math.max(Math.abs(cr-dr),Math.abs(cc-dc));
            cr = dr;
            cc = dc;
        }
        return steps;

    }
    
    public static void main(String...strings){
    	int[] a={0,1,3,4,5,6,7};
    	int[] b={0,1,3,4,5,6,7};
    	System.out.println(coverPoints(a,b));
    }
	
	
}
