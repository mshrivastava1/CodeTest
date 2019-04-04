package others;

/*Input: str1 = "AB",  str2 = "CD"
Output:
    ABCD
    ACBD
    ACDB
    CABD
    CADB
    CDAB

Input: str1 = "AB",  str2 = "C"
Output:
    ABC
    ACB
    CAB*/
public class InterleavingOfTwoStrings {

	public void printInterleaving(String s1, String s2){
		
		if(s1==null || s2==null || s1.isEmpty() || s2.isEmpty()){
			return;
		}
		
		dfsUtil(s1,s2,"");
	}
	public void dfsUtil(String first, String second, String temp) {
		
		if(first.length() == 0 && second.length()==0){
			System.out.println(temp);
			return;
		}
		
		if(first.length()!=0){
			dfsUtil(first.substring(1), second, temp+first.charAt(0));
		}
		
		if(second.length()!=0){
			dfsUtil(first, second.substring(1), temp+second.charAt(0));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "ab";
		String s2 ="cd";
		
		InterleavingOfTwoStrings obj = new InterleavingOfTwoStrings();
		
		obj.printInterleaving(s1, s2);
	}

}
