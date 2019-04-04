package mix;

public class AddStrings {

	public String addStrings(String num1, String num2) {

		if(num1==null && num2==null){
			return "";
		}
		
		if(num1==null || num1.isEmpty()){
			return num2;
		}
		
		if(num2==null || num2.isEmpty()){
			return num1;
		}
		
		
		int i = num1.length()-1;
		int j = num2.length()-1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		
		while(i>=0||j>=0||carry!=0){
			if(i>=0){
				carry+=num1.charAt(i) - '0';
				i--;
			}
			if(j>=0){
				carry+=num2.charAt(j) - '0';
				j--;
			}
			
			sb.append(carry%10);
			carry = carry/10;
		}
		
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String num1 = "999";
		String num2 = "1";
		
		AddStrings obj = new AddStrings();
		
		System.out.println(obj.addStrings(num1, num2));
	}

}
