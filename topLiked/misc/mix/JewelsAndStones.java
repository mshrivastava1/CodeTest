package mix;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

	public int numJewelsInStones(String J, String S) {

		if (S.isEmpty() || J.isEmpty()) {
			return 0;
		}
		
		int count = 0;
		
		Set<Character> set = new HashSet<Character>();
		
		for(char c:J.toCharArray()){
			set.add(c);
		}
		
		for(char c: S.toCharArray()){
			
			if(set.contains(c)){
				count++;
			}
		}

		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
