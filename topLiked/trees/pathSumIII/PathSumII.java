package pathSumIII;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

class TreeNode{
	int val;
	
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		this.val = x;
		this.left = this.right = null;
	}
}
public class PathSumII {
	
	public TreeNode root;
	int count = 0;
	public int pathSum(TreeNode root, int sum) {
     
		if(root==null){
			return count;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		dfsHelper(map, 0, sum,root);
		return count;
    }
	
	public void dfsHelper(Map<Integer, Integer> map, int currentSum, int target, TreeNode root){
		
		if(root==null){
			return;
		}
		
		currentSum+=root.val;
		
		if(map.containsKey(currentSum-target)){
			count+=map.get(currentSum - target);
		}
		
		if(!map.containsKey(currentSum)){
			map.put(currentSum, 1);
		}else{
			map.put(currentSum, map.get(currentSum)+1);
		}
		
		dfsHelper(map, currentSum, target, root.left);
		dfsHelper(map, currentSum, target, root.right);
		map.put(currentSum, map.get(currentSum)-1);
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PathSumII tree = new PathSumII();
		
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(5);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(2);
		tree.root.left.right.right = new TreeNode(1);
		tree.root.right = new TreeNode(-3);
		tree.root.right.right = new TreeNode(11);
		
		System.out.println(tree.pathSum(tree.root, 8));

	}

}
