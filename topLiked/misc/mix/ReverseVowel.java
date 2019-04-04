package mix;

public class ReverseVowel {

	public String reverseVowels(String s) {

		if(s==null || s.isEmpty()){
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(char c:s.toCharArray()){
			
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
				sb.append(c);
			}
		}
		
		String temp = sb.reverse().toString();
		
		int i = 0;
		char[] array = s.toCharArray();
		
		for(int j=0;j<array.length;j++){
			if(array[j]=='a'||array[j]=='i'||array[j]=='o'||array[j]=='e'||array[j]=='u'||array[j]=='A'||array[j]=='E'||array[j]=='I'||array[j]=='O'||array[j]=='U'){
				array[j] = temp.charAt(i);
				i++;
			}
		}
		
		return String.valueOf(array);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//String s = "hello";
		String s = "leetcode";
		ReverseVowel obj = new ReverseVowel();
		
		System.out.println(obj.reverseVowels(s));
	}

}
