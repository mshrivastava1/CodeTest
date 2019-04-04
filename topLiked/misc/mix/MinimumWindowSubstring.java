package mix;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public String minWindow(String s, String t){
		
		if(s==null || s.isEmpty() || t.length()>s.length()){
			return "";
		}
		
		Map<Character, Integer> pattern = new HashMap<Character, Integer>();
		
		for(char c: t.toCharArray()){
			
			pattern.put(c, pattern.getOrDefault(c, 0)+1);
		}
		
		Map<Character, Integer> string = new HashMap<Character, Integer>();
		int start = 0;
		int end = 0;
		int count = 0;
		int minimumLenght = Integer.MAX_VALUE;
		int startIndex = -1;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			string.put(c, string.getOrDefault(c, 0)+1);
			end++;
			if(pattern.containsKey(c) && pattern.get(c)>=string.get(c)){
				count ++;
			}
			
			if(count==t.length()){
				while(!pattern.containsKey(s.charAt(start)) || (pattern.get(s.charAt(start))<string.get(s.charAt(start)))){
					
					if(pattern.containsKey(s.charAt(start)) && pattern.get(s.charAt(start))<string.get(s.charAt(start))){
						string.put(s.charAt(start), string.getOrDefault(s.charAt(start), 0)-1);
					}
					start++;
				}
				
				int currentLenght = i -start+1;
				if(currentLenght<minimumLenght){
					minimumLenght = currentLenght;
					startIndex = start;
				}
			}
		}
		
		return s.substring(start, startIndex+minimumLenght);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "ADOBECODEBANC";
		String t = "ABC";
		
		MinimumWindowSubstring obj = new MinimumWindowSubstring();
		
		System.out.println(obj.minWindow(s, t));
	}

}
