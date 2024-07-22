package hard;

import java.util.*;

/*
*
* Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

Example 1:

Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
* */

class Job {

    int start;
    int end;
    int load;

    public Job(int start, int end, int load) {
        this.start = start;
        this.end = end;
        this.load = load;
    }
}

public class Maximum_CPU_Load {

    public static void main(String[] args) {

        List<Job> jobList = new ArrayList<>();
//        jobList.add(new Job(2, 4, 11));
//        jobList.add(new Job(6, 7, 10));
//        jobList.add(new Job(8, 12, 15));

        jobList.add(new Job(1, 4, 3));
        jobList.add(new Job(2, 5, 4));
        jobList.add(new Job(7, 9, 6));

        int maxCpuLoad = maxCpuLoad(jobList);
        System.out.println(maxCpuLoad);
    }

    public static int maxCpuLoad(List<Job> jobList) {

        int maxCpuLoad = 0;
        int currentCPULoad = 0;

        Collections.sort(jobList, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Job> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.end, b.end));

        for(Job job : jobList) {

            while (!pq.isEmpty() && job.start > pq.peek().end) {
                currentCPULoad -= pq.poll().load;
            }

            pq.offer(job);
            currentCPULoad += job.load;
            maxCpuLoad = Math.max(currentCPULoad, maxCpuLoad);
        }
        return maxCpuLoad;
    }


}
