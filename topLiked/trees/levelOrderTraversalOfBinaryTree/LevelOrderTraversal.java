package levelOrderTraversalOfBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x){
		this.val = x;
		this.left=this.right=null;
	}
}
public class LevelOrderTraversal {
	
	public TreeNode root;

	 public List<List<Integer>> levelOrder(TreeNode root){
		 
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 
		 if(root==null){
			 return result;
		 }
		 
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 
		 queue.add(root);
		 
		 while(!queue.isEmpty()){
			 
			 int size = queue.size();
			 
			 List<Integer> tempList = new ArrayList<Integer>();
			 while(size>0){
				 TreeNode temp = queue.poll();
				// queue.remove();
				 tempList.add(temp.val);
				 System.out.print(temp.val + " ");
				 if(temp.left!=null){
					 queue.add(temp.left);
				 }
				 if(temp.right!=null){
					 queue.add(temp.right);
				 }
				 size--;
			 }
			 System.out.println("");
			 result.add(tempList);
		 }
		 
		 return result;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LevelOrderTraversal tree = new LevelOrderTraversal();
		
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(20);
		tree.root.right.left = new TreeNode(15);
		tree.root.right.right = new TreeNode(7);
		
		tree.levelOrder(tree.root);

	}

}
