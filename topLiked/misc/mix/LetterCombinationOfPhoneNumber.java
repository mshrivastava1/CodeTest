package mix;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

	public List<String> letterCombinations(String digits) {

		List<String> result = new ArrayList<String>();
		if(digits==null || digits.isEmpty()){
			return result;
		}
		
		String[] numbers = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		
		dfs(digits, numbers, "", result);
		
		return result;
	}
	
	public void dfs(String digits, String[] nums, String prefix, List<String> result){
		
		if(prefix.length()==digits.length()){
			result.add(prefix);
			return;
		}
		
		int index = digits.charAt(prefix.length()) - '0';
		
		for(char c:nums[index].toCharArray()){
			String newPrefix = prefix + c;
			dfs(digits, nums, newPrefix, result);
			newPrefix = prefix;
		}
	}

	public static void main(String[] arg) {

		String digits = "234";
		
		LetterCombinationOfPhoneNumber obj = new LetterCombinationOfPhoneNumber();
		
		System.out.println(obj.letterCombinations(digits));
	}
}
