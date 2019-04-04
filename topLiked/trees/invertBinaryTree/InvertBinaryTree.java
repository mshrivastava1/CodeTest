package invertBinaryTree;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		this.val = x;
		this.left = this.right = null;
		
	}
}
public class InvertBinaryTree {

	TreeNode root;
	
	public TreeNode invertTree(TreeNode root){
		if(root==null){
			return root;
		}
		
		if(root.left ==null && root.right==null){
			return root;
		}
		
		invertTree(root.left);
		invertTree(root.right);
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		return root;
		
	}
	
	public void printTree(TreeNode root){
		if(root!=null){
			printTree(root.left);
			System.out.print(root.val+" ");
			printTree(root.right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InvertBinaryTree tree = new InvertBinaryTree();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(20);
		tree.root.right.left = new TreeNode(15);
		tree.root.right.right = new TreeNode(7);
		
		
		tree.invertTree(tree.root);
		
	}

}
