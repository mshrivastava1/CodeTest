package mix;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

	public int numUniqueEmails(String[] emails) {

		if(emails==null || emails.length==0){
			return 0;
		}
		
		Set<String> list = new HashSet<String>();
		
		for(String email: emails){
			String[] token = email.split("@");
			String temp = token[0];
			if(temp.contains(".")){
				temp = temp.replace(".", "");
			}
			if(temp.contains("+")){
				temp = temp.substring(0, temp.indexOf("+"));
			}
			
			list.add((temp+token[1]));
		}
		
		
		
		return list.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		
		UniqueEmailAddress obj = new UniqueEmailAddress();
		
		System.out.println(obj.numUniqueEmails(emails));
	}

}
