package twostack.dynamictwostackimpl;

import twostack.statictwostackimpl.MyDSSStaticDeStack;



public class TestDeStackStatic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDSSDynamicDeStack<String> deStackDynamic = new MyDSSDynamicDeStack<String>();
		System.out.println("is empty from bottom "+deStackDynamic.isEmptyBottom());
		System.out.println("is empty from top "+deStackDynamic.isEmptyTop());
		System.out.println("size from top is "+deStackDynamic.sizeTop());
		System.out.println("size from bottom is "+deStackDynamic.sizeBottom());
		
		System.out.println("\n\n");
		
		deStackDynamic.pushTop("top 1");
		deStackDynamic.pushTop("top 2");
		deStackDynamic.pushTop("top 3");
		//deStackDynamic.pushTop("top 4");
		//deStackDynamic.pushTop("top 5");
		//deStackDynamic.pushTop("top 6");
		//deStackDynamic.pushTop("top 7");
		
		deStackDynamic.pushBottom("bottom 1");
		deStackDynamic.pushBottom("bottom 2");
		//deStackDynamic.pushBottom("bottom 3");
		//deStackDynamic.pushTop("top 1");
		//deStackDynamic.pushTop("top 2");
		
		//deStackDynamic.pushBottom("bottom 3");
		
		//deStackDynamic.pushBottom("bottom 4");
		
		//deStackDynamic.pushTop("top 3");
		//deStackDynamic.pushTop("top 4");
		
		//deStackDynamic.pushBottom("bottom 5");
		//deStackDynamic.pushBottom("bottom 6");
		
		/*deStackDynamic.pushTop("top 5");
		deStackDynamic.pushTop("top 6");*/
		//deStackDynamic.pushBottom("bottom 4");
		//deStackDynamic.pushBottom("bottom 5");
		//deStackDynamic.pushBottom("bottom 6");
		/*deStackDynamic.pushTop("top 8");
		deStackDynamic.pushTop("top 9");
		deStackDynamic.pushTop("top 10");
		deStackDynamic.pushTop("top 11");
		deStackDynamic.pushTop("top 12");
		*/
		
		MyDSSStaticDeStack<String> staticDeStack  = new MyDSSStaticDeStack<String>();
		
		staticDeStack.pushBottom("SD - 1");
		staticDeStack.pushBottom("SD - 2");
		
		staticDeStack.pushTop("SD Top - 1");
		staticDeStack.pushTop("SD Top- 2");
		//staticDeStack.pushBottom("SD - 3");
		
		deStackDynamic.addAllAtTop(staticDeStack);
		
		System.out.println("after pushing elements into de-stack.........."+"\n\n");
		
		System.out.println("is empty from bottom "+deStackDynamic.isEmptyBottom());
		System.out.println("is empty from top "+deStackDynamic.isEmptyTop());
		System.out.println("size from top is "+deStackDynamic.sizeTop());
		System.out.println("size from bottom is "+deStackDynamic.sizeBottom());
		
		
		
		
	}

}
