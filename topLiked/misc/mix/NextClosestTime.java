package mix;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextClosestTime {
	
	String result = "";
	
	int minDiff = Integer.MAX_VALUE;
	public String nextClosestTime(String time) {
		
		Set<Character> set = new HashSet<Character>();
		
		set.add(time.charAt(0));
		set.add(time.charAt(1));
		set.add(time.charAt(3));
		set.add(time.charAt(4));
		
		List<Character> list = new ArrayList<Character>(set);
		int originalMins = (Integer.parseInt(time.substring(0,2)) * 60) + Integer.parseInt(time.substring(3,5));
		
		String temp = "";
		helperDefthFirstSearch(temp, originalMins, list);
		
		System.out.println(originalMins);
		
		return result;
	}

	public void helperDefthFirstSearch(String temp,int originalMins, List<Character> list){
		
		if(temp.length()==4){
			
			int hours = Integer.parseInt(temp.substring(0, 2));
			System.out.println(hours);
			int mins  = Integer.parseInt(temp.substring(2,4));
			System.out.println(mins);
			if(hours>23 || mins>59){
				return;
			}
			
			int currentMins = hours*60 + mins;
			
			currentMins = currentMins + (currentMins<=originalMins ? 24*60 : 0);
			
			if(minDiff > currentMins-originalMins){
				minDiff = (currentMins-originalMins);
				
				result = temp.substring(0,2) + ":" + temp.substring(2,4);
				System.out.println(result);
			}
			
			return;
		}
		
		for(int i=0;i<list.size();i++){
			temp = temp + list.get(i);
			helperDefthFirstSearch(temp, originalMins, list);
			temp = temp.substring(0, temp.length()-1);
		}
		
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stn
		String time = "23:12";
		
		NextClosestTime obj = new NextClosestTime();
		System.out.println(obj.nextClosestTime(time));
	}

}
