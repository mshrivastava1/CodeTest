package validateBinarySearchTree;


class TreeNode{
	
	int val;
	
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		this.val = x;
		this.left = this.right = null;
	}
}
public class ValidateBinarySearchTree {

	TreeNode root;
	
	public boolean isBinary(TreeNode root){
		
		if(root==null){
			return true;
		}
		
		return helpValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public boolean helpValid(TreeNode root, int min, int max){
		if(root==null){
			return true;
		}
		
		if(root.val<=min || root.val>=max){
			return false;
		}
		
		return (helpValid(root.left, min, root.val) && helpValid(root.right,root.val, max));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
		
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(8);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(9);
		
		System.out.println(tree.isBinary(tree.root));
	}

}
