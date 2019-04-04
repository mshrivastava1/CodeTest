package binaryTreemaximumPath;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		this.val = x;
		this.left = this.right = null;
	}
}
public class BinaryTreeMaximumPath {

	TreeNode root;
	int maxSum = Integer.MIN_VALUE;
	 public int maxPathSum(TreeNode root){
		 
		 helper(root);
		 
		 return maxSum;
	 }
	 
	 public int helper(TreeNode root){
		 
		 if(root==null){
			 return 0;
		 }
		 
		 if(root.left==null && root.right==null){
			 return root.val;
		 }
		 
		 int leftVal = Math.max(0,helper(root.left));
		 int rightVal = Math.max(0,helper(root.right));
		 
		 int sum = Math.max(Math.max(leftVal, rightVal) + root.val,root.val);
		 
		 maxSum = Math.max(maxSum, Math.max(sum, (leftVal+rightVal+root.val)));
		 
		 return sum;
		 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeMaximumPath tree = new BinaryTreeMaximumPath();
		
		tree.root = new TreeNode(-10);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(20);
		tree.root.right.left = new TreeNode(15);
		tree.root.right.right = new TreeNode(7);
		
		
		System.out.println(tree.maxPathSum(tree.root));
		

	}

}
