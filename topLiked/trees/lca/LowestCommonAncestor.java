package lca;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		this.val = x;
		this.left = this.right = null;
	}
}
public class LowestCommonAncestor {

	TreeNode root;
	TreeNode root1;
	TreeNode root2;
	
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		 
		 if(root==null){
			 return null;
		 }
		 
		 if(root.val == p.val){
			 return root;
		 }
		 
		 if(root.val == q.val){
			 return root;
		 }
		 
		 TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		 TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
		 
		 if(leftNode!=null && rightNode!=null){
			 return root;
		 }
		 
		 if(leftNode==null){
			 return rightNode;
		 }else{
			 return leftNode;
		 }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LowestCommonAncestor tree = new LowestCommonAncestor();
		
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(5);
		tree.root.right = new TreeNode(1);
		tree.root.right.left = new TreeNode(0);
		tree.root.right.right = new TreeNode(8);
		tree.root.left.left = new TreeNode(6);
		tree.root.left.right = new TreeNode(2);
		tree.root.left.right.left = new TreeNode(7);
		tree.root.left.right.right = new TreeNode(4);
		
		tree.root1 = new TreeNode(5);
		tree.root2 = new TreeNode(6);
		
		System.out.println((tree.lowestCommonAncestor(tree.root, tree.root1, tree.root2).val));
	}

}
