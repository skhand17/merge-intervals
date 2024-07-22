package hard;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Meeting {

    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Minimum_Meeting_Rooms {

    public static void main(String[] args) {

        List<Meeting> meetingList = new ArrayList<>();
        meetingList.add(new Meeting(2, 3));
        meetingList.add(new Meeting(2, 4));
        meetingList.add(new Meeting(3, 5));
        meetingList.add(new Meeting(4, 5));

        int rooms = minimumMeetingRooms(meetingList);
        System.out.println(rooms);
    }

    private static int minimumMeetingRooms(List<Meeting> meetingList) {

        if(meetingList == null || meetingList.isEmpty())
            return 0;

//        Sort the meeting list by start time
        Collections.sort(meetingList, (a, b)-> Integer.compare(a.start, b.start));
        int rooms = 0;

        PriorityQueue<Meeting> pq = new PriorityQueue<>(meetingList.size(), (a,b)->Integer.compare(a.end, b.end));

        for(Meeting meeting : meetingList) {
            while (!pq.isEmpty() && meeting.start >= pq.peek().end){
                pq.poll();
            }
            pq.offer(meeting);
            rooms = Math.max(rooms, pq.size());
        }
        return rooms;
    }
}
