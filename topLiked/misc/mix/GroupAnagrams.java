package mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs){
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		int[] arr = new int[26];
		for(String s: strs){
			
			Arrays.fill(arr, 0);
			
			for(char c: s.toCharArray()){
				arr[c-'a']++;
			}
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<26;i++){
				sb.append(arr[i]);
			}
			
			String key = sb.toString();
			
			if(!map.containsKey(key)){
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(s);
		}
		
		result.addAll(map.values());
		
		return result;
	}
	
	
	public static void main(String[] arg){
		
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		GroupAnagrams obj = new GroupAnagrams();
		
		System.out.println(obj.groupAnagrams(strs));
	}
}
