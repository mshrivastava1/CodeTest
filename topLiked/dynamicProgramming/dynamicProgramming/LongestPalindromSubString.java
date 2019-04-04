package dynamicProgramming;

public class LongestPalindromSubString {

	 public String longestPalindrome(String s){
		 
		 if(s==null || s.isEmpty()){
			 return "";
		 }
		 
		 boolean[][] dp = new boolean[s.length()][s.length()];
		 
		 for(int i =0;i<dp.length;i++){
			 dp[i][i] = true;
		 }
		 
		 
		 int result = 0;
		 int start = 0;
		 int end = 0;
		 for(int length=2;length<=s.length();length++){
			 for(int startIndex=0;startIndex<=(s.length()-length);startIndex++){
				 int endIndex = startIndex + length -1;
				 
				 if(length==2 && s.charAt(startIndex)==s.charAt(endIndex)){
					 dp[startIndex][endIndex] = true;
					 	start = startIndex;
						end = endIndex;
				 }else if(s.charAt(startIndex)==s.charAt(endIndex) && dp[startIndex+1][endIndex-1]){
					 dp[startIndex][endIndex] = true;
					 if(result<length){
						start = startIndex;
						end = endIndex;
					 }
				 }else {
					 dp[startIndex][endIndex] = false;
				 }
			 }
		 }
		
		 return s.substring(start, end+1);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "bb";
		
		LongestPalindromSubString obj = new LongestPalindromSubString();
		System.out.println(obj.longestPalindrome(s));
	}

}
