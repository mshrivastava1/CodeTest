package tree;

import java.util.Stack;

public class ExpressionTree {

	class TreeNode{
		char val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(char x){
			this.val = x;
			this.left = this.right = null;
		}
	}
	
	TreeNode root;
	
	
	public TreeNode constructTree(String s){
		
		if(s==null || s.isEmpty()){
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp;
		for(char c:s.toCharArray()){
			
			if(!isOperator(c)){
				stack.push(new TreeNode(c));
			}else{
				
				temp = new TreeNode(c);
				
				TreeNode leftTemp = null;
				TreeNode rightTemp = null;
				if(!stack.isEmpty()){
					rightTemp = stack.pop();
				}
				if(!stack.isEmpty()){
					leftTemp = stack.pop();
				}
				
				temp.left = leftTemp;
				temp.right = rightTemp;
				
				stack.push(temp);
			}
		}
		
		return stack.peek();
		
	}
	
	public boolean isOperator(char c){
		
		if(c=='+'||c=='-'||c=='*'||c=='/'){
			return true;
		}
		
		return false;
	}
	
	public void inorderTraversal(TreeNode root){
		if(root!=null){
			inorderTraversal(root.left);
			System.out.print(root.val + " ");
			inorderTraversal(root.right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "ab+ef*g*-";
		
		ExpressionTree tree = new ExpressionTree();
		
		tree.root = tree.constructTree(s);
		
		tree.inorderTraversal(tree.root);
	}

}
