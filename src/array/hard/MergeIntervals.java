package array.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0)
			return result;

		Comparator<Interval> comparator = new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		};

		Collections.sort(intervals, comparator);

		Interval begin = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curInterval = intervals.get(i);
			if (begin.end < curInterval.start) {
				result.add(begin);
				begin = curInterval;
			} else {
				begin.end = Math.max(begin.end, curInterval.end);
			}
		}
		result.add(begin);

		return result;
	}

}

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
