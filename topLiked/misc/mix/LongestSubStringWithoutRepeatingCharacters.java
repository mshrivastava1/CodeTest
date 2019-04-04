package mix;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {

	public int lengthOfLongestSubString(String s){
		
Set<Character> set = new  HashSet<Character>();
		
		int result = 0;
		int k =0;
		for(int i=0;i<s.toCharArray().length;i++){
			char c = s.charAt(i);
			if(!set.contains(c)){
				set.add(c);
				result = Math.max(result, set.size());
			}else{
				
				while(k<i){
					if(c==s.charAt(k)){
						set.remove(s.charAt(k));
						k++;
						break;
					}else{
						set.remove(s.charAt(k));
						k++;
					}
				}
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abcabcbb";
		//String s = "bbbbbbbb";
		LongestSubStringWithoutRepeatingCharacters obj = new LongestSubStringWithoutRepeatingCharacters();
		
		System.out.println(obj.lengthOfLongestSubString(s));
	}

}
