package mix;

import java.util.Stack;

public class LongestValidParanthesis {

	public int longestValidParentheses(String s) {

		if (s == null || s.length() == 0 || s.length() == 1) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
					stack.pop();
				} else {
					stack.push(i);
				}
			}
		}

		if (stack.isEmpty()) {
			return s.length();
		}

		int a = s.length();
		int b = 0;
		int maxLength = -1;
		while (!stack.isEmpty()) {
			b = stack.pop();
			maxLength = Math.max(maxLength, a - b - 1);
			a = b;
		}
		maxLength = Math.max(maxLength, a);
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "(()";

		LongestValidParanthesis obj = new LongestValidParanthesis();

		System.out.println(obj.longestValidParentheses(s));
	}

}
