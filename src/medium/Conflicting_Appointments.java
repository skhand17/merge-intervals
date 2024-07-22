package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Conflicting_Appointments {

    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(1, 4));
        intervalList.add(new Interval(2, 5));
        intervalList.add(new Interval(7, 9));

        boolean isConflicting = conflictingAppointments(intervalList);
        System.out.println(isConflicting);
    }

    private static boolean conflictingAppointments(List<Interval> intervalList) {

        Collections.sort(intervalList, (a,b) -> Integer.compare(a.start, b.start));

        Iterator<Interval> itr = intervalList.iterator();

        Interval interval = itr.next();

        int start = interval.start;
        int end = interval.end;

        while (itr.hasNext()) {
            Interval current = itr.next();

            if(current.start < end){
                return true;
            } else {
                start = interval.start;
                end = interval.end;
            }
        }
        return false;
     }
}
