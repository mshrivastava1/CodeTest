package mix;

import java.util.Stack;

public class DecodeString {

	
	public String decodeString(String s){
		
		if(s==null){
			return "";
		}
		
		String result = "";
		
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<String> stringStack = new Stack<String>();
		
		int index = 0;
		
		//String temp = "";
		while(index<s.length()){
			
			if(Character.isDigit(s.charAt(index))){
				
				int count = 0;
				
				while(Character.isDigit(s.charAt(index))){
					count = count*10 + s.charAt(index) - '0';
					index++;
				}
				
				countStack.push(count);
			}
			
			else if(s.charAt(index)=='['){
				stringStack.push(result);
				result = "";
				index++;
			}else if(s.charAt(index)==']'){
				int repeats = countStack.pop();
				
				StringBuilder builder = new StringBuilder(stringStack.pop());
				
				for(int i = 0;i<repeats;i++){
					builder.append(result);
				}
				result = builder.toString();
				index++;
			}else{
				
				result = result + s.charAt(index);
				index++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "3[a]2[bc]";
		
		DecodeString str = new DecodeString();
		
		System.out.println(str.decodeString(s));

	}

}
