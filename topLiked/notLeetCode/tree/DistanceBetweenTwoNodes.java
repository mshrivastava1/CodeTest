package tree;

public class DistanceBetweenTwoNodes {

	public class TreeNode {
		int val;

		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
			this.left = this.right = null;
		}
	}

	public TreeNode root;
	public TreeNode root1;
	public TreeNode root2;
	int distance = Integer.MIN_VALUE;
	int d1 = -1;
	int d2 = -1;

	public int findDistanceBetweenTwoNodes(TreeNode root, TreeNode n1, TreeNode n2) {

		if (root == null) {
			return Integer.MIN_VALUE;
		}

		TreeNode lca = findLca(root, n1, n2, 0);

		if (d1 != -1 && d2 != -1) {
			return distance;
		}

		// case when n1 is the parent of n2;
		if (d1 == -1) {
			return findHeight(lca);
		}
		if (d2 == -1) {
			return findHeight(lca);
		}

		return -1;
	}

	public int findHeight(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
	}

	public TreeNode findLca(TreeNode root, TreeNode n1, TreeNode n2, int level) {
		if (root == null) {
			return root;
		}

		if (root.val == n1.val) {
			d1 = level;
			return root;
		}

		if (root.val == n2.val) {
			d2 = level;
			return root;
		}

		TreeNode leftLca = findLca(root.left, n1, n2, level + 1);
		TreeNode rightLca = findLca(root.right, n1, n2, level + 1);

		if (leftLca != null && rightLca != null) {
			distance = d1 + d2 - 2 * level;
			return root;
		}

		if (leftLca == null) {
			return rightLca;
		} else {
			return leftLca;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DistanceBetweenTwoNodes tree = new DistanceBetweenTwoNodes();

		tree.root = tree.new TreeNode(1);
		tree.root.left = tree.new TreeNode(2);
		tree.root.left.left = tree.new TreeNode(4);
		tree.root.left.right = tree.new TreeNode(5);
		tree.root.right = tree.new TreeNode(3);
		tree.root.right.left = tree.new TreeNode(6);
		tree.root.right.right = tree.new TreeNode(7);
		tree.root.right.left.right = tree.new TreeNode(8);
		
		tree.root1 = tree.new TreeNode(4);
		tree.root2 = tree.new TreeNode(6);
		
		System.out.println(tree.findDistanceBetweenTwoNodes(tree.root, tree.root1, tree.root2));

	}

}
