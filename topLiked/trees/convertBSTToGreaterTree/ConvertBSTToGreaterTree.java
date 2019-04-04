package convertBSTToGreaterTree;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		this.val = x;
		this.left = this.right = null;
	}
}

public class ConvertBSTToGreaterTree {

	int sum = 0;

	public TreeNode root;
	public TreeNode convertBST(TreeNode root) {

		if (root == null) {
			return null;
		}
		
		convertBST(root.right);
		
		int temp = root.val;
		root.val +=sum;
		sum +=temp;
		
		convertBST(root.left);
		
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
		
		ConvertBSTToGreaterTree tree = new ConvertBSTToGreaterTree();
		
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(13);
		//tree.root.left.left = new TreeNode(1);
		
		tree.root = tree.convertBST(tree.root);
		
		tree.printTree(tree.root);
	}

}
