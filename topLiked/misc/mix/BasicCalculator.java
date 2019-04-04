package mix;

import java.util.Stack;

public class BasicCalculator {

	public int calculate(String s) {

		if(s==null || s.isEmpty()){
			return 0;
		}
		
		
		int len = s.length(), sign = 1, result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				result += sum * sign;
			} else if (s.charAt(i) == '+')
				sign = 1;
			else if (s.charAt(i) == '-')
				sign = -1;
			else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop() + stack.pop();
			}

		}
		return result;  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "(1+(4+5+2)-3)+(6+8)";
		
		//String s = "1 + 1";
		//String s = "2-1 + 2";
		BasicCalculator calculator = new BasicCalculator();
		
		System.out.println(calculator.calculate(s));
	}

}
