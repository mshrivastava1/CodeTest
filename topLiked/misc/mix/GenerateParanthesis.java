package mix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParanthesis {

	public List<String> generateParenthesis(int n) {
		
		List<String> result = new ArrayList<String>();
		
		if(n<=0){
			return result;
		}
		
		char[] chars = new char[n+n];
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for(int i=0;i<n;i++){
			sb1.append('(');
			sb2.append(')');
		}
		
		
		dfsUtil(chars,result,"",sb1.toString(),sb2.toString());
		return result;
	}

	public void dfsUtil(char[] chars, List<String> result, String prefix, String str1, String str2) {
	
		if(str1.isEmpty() && str2.isEmpty()){
			if(isValid(prefix)){
				result.add(prefix);
			}
			return;
		}
		
		if(!str1.isEmpty()){
			dfsUtil(chars, result, prefix+str1.charAt(0), str1.substring(1), str2);
		}
		
		if(!str2.isEmpty()){
			dfsUtil(chars, result, prefix+str2.charAt(0), str1, str2.substring(1));
		}
	}

	private boolean isValid(String prefix) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<prefix.length();i++){
			if(prefix.charAt(i)=='('){
				stack.push(prefix.charAt(i));
			}else {
				if(!stack.isEmpty()){
					char temp = stack.pop();
				}else{
					return false;
				}
			}
		}
		
		if(stack.isEmpty()){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		
		GenerateParanthesis obj = new GenerateParanthesis();
		
		System.out.println(obj.generateParenthesis(n));
	}

}
