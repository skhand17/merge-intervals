package Practice;

import java.util.*;

class Interval {

    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MergedInterval {

    public static void main(String[] args) {
        Interval intervalOne = new Interval(1, 4);
        Interval intervalTwo = new Interval(2, 5);
        Interval intervalThree = new Interval(7, 9);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(intervalOne);
        intervals.add(intervalTwo);
        intervals.add(intervalThree);

        List<Interval> mergedInterval = mergeInterval(intervals);
        for(Interval itr : mergedInterval){
            System.out.println(itr.start + " " + itr.end);
        }
    }

    private static List<Interval> mergeInterval(List<Interval> intervals) {

        List<Interval> mergedInterval = new LinkedList<>();
        Collections.sort(intervals, (a, b)-> Integer.compare(a.start, b.start));

        Iterator<Interval> itr = intervals.iterator();

        Interval interval = itr.next();

        int start = interval.start;
        int end = interval.end;

        while(itr.hasNext()) {
            Interval current = itr.next();

            if(current.start <= end) {

                end = Math.max(end, current.end);
            } else {
                mergedInterval.add(new Interval(start, end));
                start = current.start;;
                end = current.end;
            }
        }

        mergedInterval.add(new Interval(start, end));
        return mergedInterval;
    }
}
