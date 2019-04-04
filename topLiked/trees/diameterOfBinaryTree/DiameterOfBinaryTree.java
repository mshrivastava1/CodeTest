package diameterOfBinaryTree;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		this.val = x;
		this.left = this.right = null;
	}
}
public class DiameterOfBinaryTree {

	public int diameterOfBinaryTree(TreeNode root){
		
		if(root==null){
			return 0;
		}
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		int leftDiameter = diameterOfBinaryTree(root.left);
		int rightDiameter = diameterOfBinaryTree(root.right);
		
		return Math.max((leftHeight+rightHeight), Math.max(leftDiameter, rightDiameter));
	}
	
	public int getHeight(TreeNode root){
		if(root==null){
			return 0;
		}
		
		return Math.max(getHeight(root.left),getHeight(root.right))+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
