package tree;

import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class TreeNode{
	
	public int value;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
}



/**
 * Leet-Code # 105
 */
public class Construct_BT_with_Inorder_Preoder {
	
	
	/**
	 * TC O(N^2)
	 * System space O(max height of tree)
	 * aux-space O(1)
	 * @param inorder
	 * @param preorder
	 * @return
	 */
	private static TreeNode construct_BT_with_Inorder_Preoder1(int inorder[], int preorder[]) {
		if((preorder == null || inorder == null) || 
	            (preorder.length == 0 || inorder.length == 0)){
	                    return null;
	        }
	        int root = preorder[0];
	        TreeNode node = new TreeNode(root,null,null);
	        int index=0;
	        for(int i=0;i<inorder.length;i++){ // O(N)
	                if(inorder[i] == root){
	                    index = i;
	                }
	        }
	        node.left = construct_BT_with_Inorder_Preoder1(Arrays.copyOfRange(preorder,1,index+1),
	                            Arrays.copyOfRange(inorder,0,index));

	        node.right = construct_BT_with_Inorder_Preoder1(Arrays.copyOfRange(preorder,index+1,preorder.length),
	                            Arrays.copyOfRange(inorder,index+1,inorder.length));
	        return node;
	}
	
	
	// https://www.youtube.com/watch?v=ffE1xj51EBQ
	// https://www.youtube.com/watch?v=8pYQrddSP34
	
	/**
	 * TC O(N)
	 * aux-space O(N)
	 * system-stack O(max height of tree)
	 */
	static int startIndexPreOrder=0;
	private static TreeNode construct_BT_with_Inorder_Preoder(int inOrder[], int preOrder[]) {

		if ((inOrder == null || preOrder == null) || (inOrder.length == 0 || preOrder.length == 0)) {
			return null;
		}

		Map<Integer, Integer> map = IntStream.range(0, inOrder.length).boxed()
				.collect(Collectors.toMap(index -> inOrder[index], Function.identity()));

		TreeNode root= construct(inOrder, preOrder, map, 0, inOrder.length - 1, preOrder.length);
		return root;

	}

	private static TreeNode construct(int[] inOrder, int[] preOrder, Map<Integer, Integer> map,
			int startIndexInOrder, int endIndexInOrder, int length) {

			if(startIndexPreOrder >= length || startIndexInOrder > endIndexInOrder) {
				return null;
			}
			
			int value = preOrder[startIndexPreOrder++];
			TreeNode root = new TreeNode(value,null,null);
			int nodePos = map.get(root.value);
			root.left = construct(inOrder,preOrder,map,startIndexInOrder,(nodePos-1),length);
			root.right = construct(inOrder,preOrder,map,(nodePos+1),endIndexInOrder,length);
			
		return root;
	}

	public static void main(String[] args) {
		int[] preOrder = {3,9,20,15,7};
		int[] inOrder = {9,3,15,20,7};
		
		TreeNode root = construct_BT_with_Inorder_Preoder(inOrder,preOrder);
		System.out.println(root);
		
		//TreeNode root1 = construct_BT_with_Inorder_Preoder1(inOrder,preOrder);
		//System.out.println(root1);
		
		StringJoiner sj = new StringJoiner(",");
		System.out.println(sj.toString());
		
	}

}
