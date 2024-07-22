package Practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        Interval intervalInsertion = new Interval(1, 4);
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));


        List<Interval> insertInterval  = insertIntervals(input, intervalInsertion);
        for(Interval itr : insertInterval) {
            System.out.println(itr.start + " " + itr.end);
        }

    }

    public static List<Interval> insertIntervals(List<Interval> intervalList, Interval insertion) {

        List<Interval> insertInterval = new ArrayList<>();

        if(intervalList == null || intervalList.isEmpty()){
            return Arrays.asList(insertion);
        }


        int i=0;

        while (i < intervalList.size() && intervalList.get(i).end < insertion.start){
            insertInterval.add(intervalList.get(i++));
        }
        while (i < intervalList.size() && intervalList.get(i).start < insertion.end) {
            insertion.start = Math.min(intervalList.get(i).start, insertion.start);
            insertion.end = Math.max(intervalList.get(i).end, insertion.end);
            i++;
        }
        insertInterval.add(new Interval(insertion.start, insertion.end));

        while (i < intervalList.size()){
            insertInterval.add(intervalList.get(i++));
        }

        return insertInterval;

    }
}
