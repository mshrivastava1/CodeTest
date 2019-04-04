package onsiteGoogle1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;



public class StrechWord {

	public int expressiveWords(String S, String[] words) {

		if (S == null || S.isEmpty() || words == null || words.length == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : S.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int count = 0;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			Map<Character, Integer> wordMap = new HashMap<Character, Integer>();

			for (int j = 0; j < word.length(); j++) {

				char c = word.charAt(j);

				if (!map.containsKey(c)) {
					break;
				} else {

					wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
				}
			}
			int size = 0;
			for(Entry<Character, Integer> entry : map.entrySet()){
				
				if(!wordMap.containsKey(entry.getKey())){
					break;
				}
				if(wordMap.containsKey(entry.getKey()) && entry.getValue()<3 && wordMap.get(entry.getKey())!=entry.getValue()){
					break;
				}
				if(wordMap.containsKey(entry.getKey())  && wordMap.get(entry.getKey())>entry.getValue() ){
					break;
				}
				size++;
			}
			if(size==map.size()){
				count++;
			}
			

		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = "heeellooo";
		
		String[] words = {"hello", "hi", "helo"};
		
		StrechWord obj = new StrechWord();
		
		System.out.println(obj.expressiveWords(S, words));
	}

}
