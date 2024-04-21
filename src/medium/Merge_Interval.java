package medium;

import java.util.*;

public class Merge_Interval {

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(2, 6));
        input.add(new Interval(6, 10));
        input.add(new Interval(8, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    public static List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() < 2)
            return intervals;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<>();

        Iterator<Interval> itr = intervals.iterator();
        Interval interval = itr.next();

        int start = interval.start;
        int end = interval.end;

        while (itr.hasNext()) {
            interval = itr.next();

            if (interval.start <= end) {
                /*
                 * We have an overlapping intervals, need to find the maximum of two ends and make end as that
                 *
                 * */
                end = Math.max(interval.end, end);
            } else {
                /*
                 * We don't have a overlapping interval
                 * */
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
}
