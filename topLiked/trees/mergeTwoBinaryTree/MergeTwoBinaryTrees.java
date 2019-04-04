package mergeTwoBinaryTree;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		this.val = x;
		this.left = this.right = null;
	}
}
public class MergeTwoBinaryTrees {

	public TreeNode root1;
	public TreeNode root2;
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
		
		if(t1==null && t2==null){
			return null;
		}
		
		if(t1==null){
			return t2;
		}
		if(t2==null){
			return t1;
		}
		
		TreeNode root = new TreeNode(t1.val+t2.val);
		root.left = mergeTrees(t1.left, t2.left);
		root.right = mergeTrees(t1.right, t2.right);
		
		return root;
		
	}
	
	public void printTree(TreeNode root){
		if(root!=null){
			printTree(root.left);
			System.out.print(root.val + " ");
			printTree(root.right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MergeTwoBinaryTrees tree = new MergeTwoBinaryTrees();
		tree.root1 = new TreeNode(1);
		tree.root1.left = new TreeNode(3);
		tree.root1.right = new TreeNode(2);
		tree.root1.left.left = new TreeNode(5);
		
		tree.root2 = new TreeNode(2);
		tree.root2.left = new TreeNode(1);
		tree.root2.right = new TreeNode(3);
		tree.root2.left.right = new TreeNode(4);
		tree.root2.right.right = new TreeNode(7);
		
		TreeNode root = tree.mergeTrees(tree.root1, tree.root2);
		
		tree.printTree(root);
	}

}
