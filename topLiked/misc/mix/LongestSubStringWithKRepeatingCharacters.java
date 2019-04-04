package mix;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKRepeatingCharacters {

public int longestSubString(String s, int k){
		
		if(s==null || s.isEmpty()){
			return 0;
		}
		if(k>s.length()){
			return 0;
		}
		
		int result = 0;
		char[] chars = s.toCharArray();
		result = dfsUtil(chars, 0, s.length(),k);
		
		return result;
	}
	
	/*
	 We are eliminating the character whose frequency is less than K as this character can not be part of the string with
	 atleast k repeating character and then check for the left part of the char and right part of the eliminated char.
	 * 
	 * */
	public int dfsUtil(char[] chars, int start, int end, int k) {
		
		if(end-start<k){
			return 0;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c:chars){
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		for(int i=start;i<end;i++){
			if(map.get(chars[i])<k){
				int left = dfsUtil(chars, start, i, k);
				int right = dfsUtil(chars, i+1, end, k);
				return Math.max(left, right);
			}
		}
		
		return end-start;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "aaabbccc";
		int k = 3;
		
		LongestSubStringWithKRepeatingCharacters obj = new LongestSubStringWithKRepeatingCharacters();
		
		System.out.println(obj.longestSubString(s, k));
	}

}
