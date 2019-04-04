package dynamicProgramming;

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {

		if(s==null || s.isEmpty()){
			return false;
		}
		if(s.isEmpty() && (p.isEmpty()||(p.length()==1 && p.charAt(0)=='*'))){
			return true;
		}
		
		return matchRegex(s.toCharArray(),p.toCharArray());
	}
	
	
	public boolean matchRegex(char[] text, char[] pattern){
		
		boolean[][] dp = new boolean[text.length+1][pattern.length+1];
		
		dp[0][0] = true;
		
		for(int i=1;i<dp[0].length;i++){
			if(pattern[i-1]=='*'){
				dp[0][i] = dp[0][i-2];
			}
		}
		
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				
				if(pattern[j-1]==text[i-1] || pattern[j-1]=='.'){
					dp[i][j] = dp[i-1][j-1];
				}else if(pattern[j-1]=='*'){
					dp[i][j] = dp[i][j-2];
					if(text[i-1]==pattern[j-2] || pattern[j-2]=='.'){
						dp[i][j] = dp[i-1][j] || dp[i][j];
					}
				}else{
					dp[i][j] = false;
				}
			}
		}
		return dp[text.length][pattern.length];
	}
	
/*	 public boolean matchRegex(char[] text, char[] pattern) {
	        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

	        T[0][0] = true;
	        //Deals with patterns like a* or a*b* or a*b*c*
	        for (int i = 1; i < T[0].length; i++) {
	            if (pattern[i-1] == '*') {
	                T[0][i] = T[0][i - 2];
	            }
	        }

	        for (int i = 1; i < T.length; i++) {
	            for (int j = 1; j < T[0].length; j++) {
	                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
	                    T[i][j] = T[i-1][j-1];
	                } else if (pattern[j - 1] == '*')  {
	                    T[i][j] = T[i][j - 2];
	                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
	                        T[i][j] = T[i][j] | T[i - 1][j];
	                    }
	                } else {
	                    T[i][j] = false;
	                }
	            }
	        }
	        return T[text.length][pattern.length];
	    }
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "xaa";
		String p = "xa*";

		RegularExpressionMatching obj = new RegularExpressionMatching();

		System.out.println(obj.isMatch(s, p));
	}

}
