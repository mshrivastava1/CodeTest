package mix;

public class CountPalindromicStrings {

	public int countSubstrings(String s){
		
		int count = 0;
		if(s==null){
			return count;
		}
		
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		for(int i=0;i<s.length();i++){
			count++;
			dp[i][i] = true;
		}
		
		if(s.length()>1){
			for(int length=2; length<=s.length();length++){
				for(int startIndex=0;startIndex<s.length()-length+1;startIndex++){
					int endIndex = startIndex + length -1;
					if(length==2 && s.charAt(startIndex)==s.charAt(endIndex)){
						dp[startIndex][endIndex] = true;
						count++;
					}else if(s.charAt(startIndex)==s.charAt(endIndex) && dp[startIndex+1][endIndex-1]){
						dp[startIndex][endIndex] = true;
						count++;
					}else{
						dp[startIndex][endIndex] = false;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "fdsklf";
		
		CountPalindromicStrings obj = new CountPalindromicStrings();
		
		System.out.println(obj.countSubstrings(s));
	}

}
