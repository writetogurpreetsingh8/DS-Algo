package destack.statickdestackimpl;



public class TestDeStackStatic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDSStaticDeStackInterface<String> deStackStatic = new MyDSSStaticDeStack<String>();
		System.out.println("is empty from bottom "+deStackStatic.isEmptyBottom());
		System.out.println("is empty from top "+deStackStatic.isEmptyTop());
		System.out.println("size from top is "+deStackStatic.sizeTop());
		System.out.println("size from bottom is "+deStackStatic.sizeBottom());
		System.out.println("is space available from bottom "+deStackStatic.isSpaceAvailableBottom());
		System.out.println("is space available from top "+deStackStatic.isSpaceAvailableTop());
		
		System.out.println("\n\n");
		
		deStackStatic.pushTop("top 1");
		deStackStatic.pushTop("top 2");
		deStackStatic.pushTop("top 3");
		//deStackStatic.pushTop("top 4");
		
		deStackStatic.pushBottom("bottom 1");
		deStackStatic.pushBottom("bottom 2");
		/*deStackStatic.pushBottom("bottom 3");
		deStackStatic.pushBottom("bottom 4");
		deStackStatic.pushBottom("bottom 5");*/
		
		//deStackStatic.pushTop("top 5");
		/*System.out.println("after pushing elements into de-stack.........."+"\n\n");
		
		System.out.println("capacity from bottom is "+deStackStatic.capacityBottom());
		System.out.println("capacity from top is "+deStackStatic.capacityTop());
		System.out.println("is empty from bottom "+deStackStatic.isEmptyBottom());
		System.out.println("is empty from top "+deStackStatic.isEmptyTop());
		System.out.println("size from top is "+deStackStatic.sizeTop());
		System.out.println("size from bottom is "+deStackStatic.sizeBottom());
		System.out.println("is space available from bottom "+deStackStatic.isSpaceAvailableBottom());
		System.out.println("is space available from top "+deStackStatic.isSpaceAvailableTop());
		
		System.out.println("\n\n");
		
		System.out.println("after pop some elements "+"\n\n");
		System.out.println(deStackStatic.popBottom());
		deStackStatic.pushTop("top 1");
		
		//deStackStatic.clearBottom();
		System.out.println("bottom search is "+deStackStatic.searchBottom("bottom 4"));
		deStackStatic.showBottom();deStackStatic.showTop();
		Object[] bottom = deStackStatic.toArrayBottom();
		bottom = deStackStatic.toArrayTop();
		
		IteratorBottom<String> itr = deStackStatic.iteratorBottom();
		
		while(itr.hasBottomElement()){
			System.out.println("elements from iterator at bottom "+itr.nextBottomElement());
		}
		
		IteratorTop<String> itrTop = deStackStatic.iteratorTop();
		
		while(itrTop.hasTopElement()){
			System.out.println("elements from iterator at top "+itrTop.nextTopElement());
		}
		System.out.println("is empty from bottom "+deStackStatic.isEmptyBottom());
		System.out.println("is empty from top "+deStackStatic.isEmptyTop());
		System.out.println("size from top is "+deStackStatic.sizeTop());
		System.out.println("size from bottom is "+deStackStatic.sizeBottom());
		System.out.println("is space available from bottom "+deStackStatic.isSpaceAvailableBottom());
		System.out.println("is space available from top "+deStackStatic.isSpaceAvailableTop());
		
		System.out.println(deStackStatic.toStringTop());*/
		System.out.println(deStackStatic.toStringBottom());
		
	}

}
