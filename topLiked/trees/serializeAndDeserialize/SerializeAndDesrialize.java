package serializeAndDeserialize;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		this.val = x;
		this.left = this.right = null;
	}
}
public class SerializeAndDesrialize {

	public static String NN = "x";
	public static String delimeter = ",";
	
	public TreeNode root;
	public String serialize(TreeNode root){
		
		if(root == null){
			return "";
		}
		
		StringBuilder builder = new StringBuilder();
		
		buildString(builder, root);
		
		return builder.toString();
	}
	
	public void buildString(StringBuilder builder, TreeNode root){
		
		
		if(root==null){
			builder.append(NN).append(delimeter);
			return;
		}else{
			builder.append(root.val).append(delimeter);
			buildString(builder, root.left);
			buildString(builder,root.right);
		}
	}
	
	public TreeNode deserialize(String str){
		
		Deque<String> queue = new LinkedList<String>();
		
		if(str==null || str.isEmpty()){
			return null;
		}
		
		queue.addAll(Arrays.asList(str.split(delimeter)));
		TreeNode root = buildTree(queue);
		
		return root;
	}
	
	public TreeNode buildTree(Deque<String> queue){
		
		String s =(String) queue.remove();
		if(s.equals(NN)){
			return null;
		}else{
			TreeNode root = new TreeNode(Integer.parseInt(s));
			root.left = buildTree(queue);
			root.right = buildTree(queue);
			
			return root;
		}
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

		SerializeAndDesrialize tree = new SerializeAndDesrialize();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.right.left = new TreeNode(4);
		tree.root.right.right = new TreeNode(5);
		
		String s = tree.serialize(tree.root);
		
		TreeNode node = tree.deserialize(s);
		
		tree.printTree(node);
	}

}
