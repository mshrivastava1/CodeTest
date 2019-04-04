package mix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindStartIndexOfAllAnagrams {

	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> result = new ArrayList<Integer>();

		if (s == null || p == null || p.isEmpty() || s.isEmpty() || p.length()>s.length()) {
			return result;
		}

		
		int[] arrayS = new int[26];
		int[] arrayP = new int[26];
		
		for(int i =0;i<p.length();i++){
			arrayP[p.charAt(i)-'a'] = arrayP[p.charAt(i)-'a']+1;
			arrayS[s.charAt(i)-'a'] = arrayS[s.charAt(i)-'a']+1;
		}
		
		int m = p.length();
		int n = s.length();
		
		for(int i=m;i<n;i++){
			
			if(compareArray(arrayP, arrayS)){
				result.add(i-m);
			}
			
			arrayS[s.charAt(i)-'a']++;
			arrayS[s.charAt(i-m)-'a']--;
		}
		
		if(compareArray(arrayS, arrayP)){
			result.add(n-m);
		}
		return result;
	}

	public boolean compareArray(int[] a, int[] b){
		
		for(int i=0;i<a.length;i++){
			if(a[i]!=b[i]){
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] arg) {

		String s = "abcebabacd";
		String p = "abc";
		
		FindStartIndexOfAllAnagrams obj = new FindStartIndexOfAllAnagrams();
		
		System.out.println(obj.findAnagrams(s, p));
	}
}
