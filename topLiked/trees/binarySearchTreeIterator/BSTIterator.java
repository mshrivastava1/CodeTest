package binarySearchTreeIterator;

import java.util.Stack;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		this.val = x;
		this.left = this.right = null;
	}
}

public class BSTIterator {

	TreeNode root;
	Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {

		this.stack = new Stack<TreeNode>();
		
		TreeNode temp = root;
		
		while(temp!=null){
			stack.push(temp);
			if(temp.left!=null){
				temp = temp.left;
			}else{
				break;
			}
		}
		
	}

	public int next() {

		TreeNode result = stack.pop();
		TreeNode temp = result;
		
		if(temp.right!=null){
			temp = temp.right;
			
			while(temp!=null){
				stack.push(temp);
				
				if(temp.left!=null){
					temp = temp.left;
				}else{
					break;
				}
			}
			
		}
		
		return result.val;
	}

	public boolean hasNext() {

		return !stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(7);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		
		BSTIterator tree = new BSTIterator(root);
		
		while(tree.hasNext()){
			System.out.println(tree.next());
		}

	}

}
