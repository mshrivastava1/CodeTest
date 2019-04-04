package meetingRoomsII;

import java.sql.Array;
import java.util.Arrays;

class Interval{
	int start;
	int end;
	
	Interval(){
		this.start = this.end = 0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}
public class MeetingRoomII {

	public int minMeetingRooms(Interval[] intervals) {

		  int[] starts = new int[intervals.length];
	        int[] ends = new int[intervals.length];
	        for(int i=0; i<intervals.length; i++) {
	            starts[i] = intervals[i].start;
	            ends[i] = intervals[i].end;
	        }
	        Arrays.sort(starts);
	        Arrays.sort(ends);
	        int rooms = 0;
	        int endsItr = 0;
	        for(int i=0; i<starts.length; i++) {
	            if(starts[i]<ends[endsItr])
	                rooms++;
	            else
	                endsItr++;
	        }
	        return rooms;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Interval[] intervals = {new Interval(0,30),new Interval(5,10), new Interval(15,20)};
		
		MeetingRoomII obj = new MeetingRoomII();
		
		System.out.println(obj.minMeetingRooms(intervals));
	}

}
