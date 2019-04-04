package mix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParanthesis {
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();

		remove(result, s, 0, 0, new char[] { '(', ')' });

		return result;
	}

	private void remove(List<String> result, String s, int index, int lastRemoveIndex, char[] pair) {

		int stack = 0;

		for (int i = index; i < s.length(); i++) {
			if (s.charAt(i) == pair[0]) {
				stack++;
			}
			if (s.charAt(i) == pair[1]) {
				stack--;
			}
			if (stack >= 0) {
				continue;
			}

			for (int j = lastRemoveIndex; j <= i; j++) {
				if (s.charAt(j) == pair[1] && (j == lastRemoveIndex || s.charAt(j - 1) != pair[1])) {
					remove(result, s.substring(0, j) + s.substring(j + 1, s.length()), i, j, pair);
				}

			}
			return;
		}

		String reversed = new StringBuilder(s).reverse().toString();

		if (pair[0] == '(') {
			remove(result, reversed, 0, 0, new char[] { ')', '(' });
		} else {
			result.add(reversed);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String s ="(a)())()";
		//String s = "()())()";
		String s = "((((()";
		RemoveInvalidParanthesis obj = new RemoveInvalidParanthesis();

		System.out.println(obj.removeInvalidParentheses(s));
	}

}
