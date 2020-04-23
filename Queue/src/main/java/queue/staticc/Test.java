package queue.staticc;

import queue.interfacee.Iterator;
import queue.interfacee.Queue;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDSStaticQueueInterface<String> queue = new MyDSStaticQueue<String>();
		queue.push("1");
		queue.push("2");
		queue.push("3");
		queue.push("4");
		queue.push("5");
		System.out.println("size of queue is "+queue.size());
		System.out.println("index is "+queue.indexOf("3"));
		System.out.println("is element found "+queue.search("7"));
		System.out.println("is empty "+queue.isEmpty());
		System.out.println("is spaceAvailable "+queue.isSpaceAvailable());
		//queue.clear();
		System.out.println("is empty "+queue.isEmpty());
		System.out.println("is spaceAvailable "+queue.isSpaceAvailable());
		Iterator<String> itr = queue.iterator();
		System.out.println(itr.hasNext());
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		/*System.out.println("poped up element is "+queue.pop());
		System.out.println("poped up element is "+queue.pop());
		System.out.println("poped up element is "+queue.pop());
		System.out.println("poped up element is "+queue.pop());
		System.out.println("poped up element is "+queue.pop());*/
		Object[] temp = queue.toArray();
		System.out.println(temp);
		try {
			System.out.println("poped up element is "+queue.pop());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		temp = queue.toArray();
		System.out.println(temp);
		//queue.push("6");
		//queue.show();
		
	}

}
