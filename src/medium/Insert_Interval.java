package medium;

import java.util.*;

public class Insert_Interval {

    public static void main(String[] args) {
        Interval intervalInsertion = new Interval(1, 4);
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
//        input.add(new Interval(8, 12));
        System.out.print("Merged intervals: ");
        for (Interval interval : insertion(input, intervalInsertion))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    public static List<Interval> insertion(List<Interval> intervals, Interval intervalInsertion) {

        List<Interval> mergedIntervals = new ArrayList<>();

        if(intervals == null || intervals.isEmpty()){
            return Arrays.asList(intervalInsertion);
        }

        int i=0;
        /*
        * This is adding those intervals who are not at all intersecting with the new added interval and
        * thus we store the output.
        *
        * */
        while(i < intervals.size() && intervals.get(i).end < intervalInsertion.start)
            mergedIntervals.add(intervals.get(i++));


        while (i < intervals.size() && intervals.get(i).start <= intervalInsertion.end){
            intervalInsertion.start = Math.min(intervalInsertion.start, intervals.get(i).start);
            intervalInsertion.end = Math.max(intervalInsertion.end, intervals.get(i).end);
            i++;
        }

//        insert the new interval formed
        mergedIntervals.add(intervalInsertion);

        while(i < intervals.size()){
            mergedIntervals.add(intervals.get(i++));
        }

        return mergedIntervals;

    }
}
