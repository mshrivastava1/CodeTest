package subTreeOfAnotherTree;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		this.val = x;
		this.left = this.right = null;
	}
}
public class SubTreeOfAnotherTree {

	public TreeNode root1;
	public TreeNode root2;
	public boolean isSubTree(TreeNode s, TreeNode t){
		
		if(s==null){
			return false;
		}
		if(t==null){
			return true;
		}
		if(isIdentical(s, t)){
			return true;
		}
		
		if(isSubTree(s.left, t)){
			return true;
		}
		
		if(isSubTree(s.right, t)){
			return true;
		}
		
		return false;
		
	}
	
	public boolean isIdentical(TreeNode s, TreeNode t){
		
		if(s==null && t==null){
			return true;
		}
		
		if(s==null || t==null){
			return false;
		}
		
		return (s.val==t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right));
	}
	public static void main(String[] args) {
		
		SubTreeOfAnotherTree tree = new SubTreeOfAnotherTree();
		
		tree.root1 = new TreeNode(3);
		tree.root1.left = new TreeNode(4);
		tree.root1.right = new TreeNode(5);
		tree.root1.left.left = new TreeNode(1);
		tree.root1.left.right = new TreeNode(2);
		
		tree.root2 = new TreeNode(4);
		tree.root2.left = new TreeNode(1);
		tree.root2.right = new TreeNode(2);
		
		System.out.println(tree.isSubTree(tree.root1, tree.root2));
	}

}
