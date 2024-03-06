package queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Interleaving_First_Half_Of_Queue_With_Sec_Half {

	
	private static List<Integer> interleaving_First_Half_Of_Queue_With_Sec_Half(Queue<Integer> queue){
		
		if(queue == null || queue.isEmpty()) {
			return Collections.emptyList();
		}
		Stack<Integer> stack = new Stack<>();
		
		//first step, remove all the elements of queue and put them into stack
		while(!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		// now queue has been empty
		
		//second step, now remove half elements from stack and put them into queue
		for(int i=0;i<stack.size();i++) {
			queue.offer(stack.pop());
		}
		
		//third step, now fetch element of queue and put it into ArraList then fetch first element of stack put it into ArrayList
		// repeat until any of them ( queue, stack) become empty
		List<Integer> list = new ArrayList<Integer>(queue.size()+stack.size());
		
		while(!queue.isEmpty()) {
			list.add(queue.poll());
			list.add(stack.pop());
		}
		Collections.reverse(list);
		return list;
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(11);queue.offer(12);queue.offer(13);
		queue.offer(14);queue.offer(15);queue.offer(16);
		queue.offer(17);queue.offer(18);
		System.out.println(interleaving_First_Half_Of_Queue_With_Sec_Half(queue));
	}

}
