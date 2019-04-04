package tree;

class TreeNode{
	int val;
	
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		this.val = x;
		this.left=this.right=null;
	}
}
public class MaximumDifferenceBetweenAcestorAndNode {
	
	TreeNode root;
	int maximumDistance = Integer.MIN_VALUE;
	
	
	public int findMaximumDiffernce(TreeNode root){
		
		if(root==null){
			return Integer.MAX_VALUE;
		}
		
		if(root.left==null && root.right==null){
			return root.val;
		}
		
		int val = Math.min(findMaximumDiffernce(root.left), findMaximumDiffernce(root.right));
		
		maximumDistance = Math.max(root.val-val, maximumDistance);
		
		
		return Math.min(val, root.val);
	}
	
	
	
	public static void main(String[] arg){
		
		MaximumDifferenceBetweenAcestorAndNode tree = new MaximumDifferenceBetweenAcestorAndNode();
		
		tree.root = new TreeNode(8);
		 tree.root.left = new TreeNode(3);
	        tree.root.left.left = new TreeNode(1);
	        tree.root.left.right = new TreeNode(6);
	        tree.root.left.right.left = new TreeNode(4);
	        tree.root.left.right.right = new TreeNode(7);
	  
	        tree.root.right = new TreeNode(10);
	        tree.root.right.right = new TreeNode(14);
	        tree.root.right.right.left = new TreeNode(13);
	        
	        tree.findMaximumDiffernce(tree.root);
	        
	        System.out.println(tree.maximumDistance);
	}

}
