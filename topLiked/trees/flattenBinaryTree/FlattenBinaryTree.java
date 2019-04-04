package flattenBinaryTree;


class TreeNode{
	
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x){
		this.val = x;
		this.left=this.right=null;
	}
}
public class FlattenBinaryTree {

	TreeNode root;
	TreeNode prev;
	
	public void flatten(TreeNode root){
		
		if(root==null){
			return;
		}
		
		if(prev!=null){
			prev.right = root;
		}
		
		prev = root;
		TreeNode leftNode = root.left;
		TreeNode rightNode = root.right;
		
		root.left = null;
		flatten(leftNode);
		flatten(rightNode);
	}
	
	public void flattenWithourRecusrsion(TreeNode root){
		if(root==null){
			return;
		}
		
		while(root!=null){
			if(root.left!=null){
				TreeNode temp = root.left;
				while(temp.right!=null){
					temp = temp.right;
				}
				temp.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
	
	
	public void inorderPrint(TreeNode root){
		if(root!=null){
			inorderPrint(root.left);
			System.out.print(root.val+" ");
			inorderPrint(root.right);
		}
	}
	public static void main(String[] args) {
		
		FlattenBinaryTree tree = new FlattenBinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(5);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(4);
		tree.root.right.right = new TreeNode(6);
		
		tree.flatten(tree.root);
		
		tree.inorderPrint(tree.root);

	}

}
