package queue.dynamic;

import queue.interfacee.Iterator;
import queue.staticc.MyDSStaticQueue;
import queue.staticc.MyDSStaticQueueInterface;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDSDynamicQueueInterface<String> queue = new MyDSDynamicQueue<String>();
		queue.push("1");
		queue.push("2");
		queue.push("3");
		queue.push("4");
		queue.push("5");
		queue.push("6");
		queue.push("7");
		System.out.println("size of queue is "+queue.size());
		System.out.println("index is "+queue.indexOf("3"));
		System.out.println("is element found "+queue.search("7"));
		System.out.println("is empty "+queue.isEmpty());
		//queue.clear();
		System.out.println("is empty "+queue.isEmpty());
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
		
		MyDSStaticQueueInterface<String> staticQueue = new MyDSStaticQueue<String>();
		staticQueue.push("1");
		staticQueue.push("2");
		staticQueue.push("3");
		staticQueue.push("4");
		queue.addAll(staticQueue);
		Object[] temp = queue.toArray();
		System.out.println(temp);
		
		
		//queue.push("6");
		//queue.show();
		
	}

}
