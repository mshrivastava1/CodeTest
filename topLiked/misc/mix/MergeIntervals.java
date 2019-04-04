package mix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		
		intervals.sort((i1,i2)->Integer.compare(i1.start, i2.start));
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (int i = 0; i < intervals.size(); i++) {

			if (end >= intervals.get(i).start) {
				end = Math.max(end, intervals.get(i).end);
			} else {
				Interval interval = new Interval(start, end);
				result.add(interval);
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}

		result.add(new Interval(start, end));
		for (Interval interval : result) {
			System.out.print("{" + interval.start + " ," + interval.end + "}");
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Interval> intervals = new ArrayList<Interval>();

		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));

		MergeIntervals obj = new MergeIntervals();
		List<Interval> result = obj.merge(intervals);
		System.out.println("");

	}

}
