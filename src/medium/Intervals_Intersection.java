package medium;

import java.util.ArrayList;
import java.util.List;

public class Intervals_Intersection {

    public static void main(String[] args) {

//        Interval[] arr1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
//        Interval[] arr2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
//
//        List<Interval> result = merge(arr1, arr2);
//
//        for (Interval interval : result) {
//            System.out.print("[ " + interval.start + " , " + interval.end + " ] ");
//            System.out.println();
//        }
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7),
                new Interval(9, 12) };
        Interval[] input2 = new Interval[] { new Interval(5, 10) };

        List<Interval> result  = merge(input1, input2);
        for (Interval interval : result) {
            System.out.print("[ " + interval.start + " , " + interval.end + " ] ");
        }
            System.out.println();


    }

    public static List<Interval> merge(Interval[] arr1, Interval[] arr2) {

        List<Interval> mergedList = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {


            if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end
                    || arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {

//                We have an overlapping interval

                mergedList.add(new Interval(Math.max(arr2[j].start, arr1[i].start),
                                            Math.min(arr2[j].end, arr1[i].end)));
            }

            if (arr1[i].end < arr2[j].end) {
                i++;
            } else {
                j++;
            }
        }

        return mergedList;
    }
}
