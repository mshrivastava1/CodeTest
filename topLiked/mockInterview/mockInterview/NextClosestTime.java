package mockInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class NextClosestTime {

	int minDiff = Integer.MAX_VALUE;
	String result = "";
	public String nextClosestTime(String time) {

		if (time == null || time.isEmpty()) {
			return "";
		}
		
		Set<Character> set = new HashSet<Character>();
		
		set.add(time.charAt(0));
		set.add(time.charAt(1));
		set.add(time.charAt(3));
		set.add(time.charAt(4));
		
		int hours = Integer.parseInt(time.substring(0, 2));
		int minutes = Integer.parseInt(time.substring(3,5));
		
		int totalMinutes = hours*60 + minutes;
		
		List<Character> list = new ArrayList<Character>(set);
		dfs(list,totalMinutes,"");
		return result;
	}

	public void dfs(List<Character> list, int totalMinutes, String temp) {

		if(temp.length()==4){
			
			int currentHour = Integer.parseInt(temp.substring(0, 2));
			int currentMinutes = Integer.parseInt(temp.substring(2,4));
			
			if(currentHour>23 || currentMinutes>59){
				return;
			}
			
			int totalCurrentMinutes = currentHour*60 + currentMinutes;
			
			totalCurrentMinutes = totalCurrentMinutes + (totalCurrentMinutes<=totalMinutes?(24*60):0);
			
			if(minDiff>(totalCurrentMinutes-totalMinutes)){
				minDiff = totalCurrentMinutes-totalMinutes;
				result = temp.substring(0, 2) + ":" + temp.substring(2,4);
				
			}
			
			return;
		}
		
		for(int i = 0;i<list.size();i++){
			temp = temp + list.get(i);
			dfs(list, totalMinutes, temp);
			temp = temp.substring(0,temp.length()-1);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

String time = "23:12";
		
		NextClosestTime obj = new NextClosestTime();
		System.out.println(obj.nextClosestTime(time));
	}

}
