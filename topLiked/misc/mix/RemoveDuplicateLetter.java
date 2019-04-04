package mix;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RemoveDuplicateLetter {

	public String removeDuplicateLetters(String s) {

		if (s == null || s.isEmpty()) {
			return "";
		}

		if (s.length() < 2) {
			return s;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> a - b);

		for (int i = s.length() - 1; i >= 0; i--) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), i);
				queue.add(i);
			}
		}

		int startIndex = 0;
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {

			char currentChar = 'z' + 1;
			int endIndex = queue.peek();
			for (int i = startIndex; i <= endIndex; i++) {
				if (map.containsKey(s.charAt(i)) && currentChar > s.charAt(i)) {
					currentChar = s.charAt(i);
					startIndex = i + 1;
				}
			}

			
			int idx = map.get(currentChar);
			queue.remove(idx);
			map.remove(currentChar);
			sb.append(currentChar);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "cbacdcbc";
		
		//String s = "bcabc";
		
		RemoveDuplicateLetter obj = new RemoveDuplicateLetter();
		
		System.out.println(obj.removeDuplicateLetters(s));
	}

}
