package symmetricTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		this.val = x;
		this.left = this.right = null;
	}
}

public class SymmetricTree {

	TreeNode root;

	public boolean isSymmetric(TreeNode root) {

		return helperToFindSymmetricTree(root, root);
	}

	public boolean helperToFindSymmetricTree(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
			}

			return (root1.val == root2.val && helperToFindSymmetricTree(root1.left, root2.right)
					&& helperToFindSymmetricTree(root1.right, root2.left));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
