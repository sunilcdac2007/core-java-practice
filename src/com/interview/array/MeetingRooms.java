package com.interview.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    public static class Interval {

        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(Interval[] intervals){

        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, (inter1, inter2) -> inter1.start - inter2.start);

        PriorityQueue<Interval> pq = new PriorityQueue<>( (inter1, inter2) -> inter1.end - inter2.end);

        pq.offer(intervals[0]);

        int rooms=1;
        for( int i=1; i < intervals.length; i++){
            Interval it = pq.poll();
            if( it.end <= intervals[i].start){
                it = new Interval(it.start, intervals[i].end);
            }else {
                rooms ++;
                pq.offer(intervals[i]);
            }
            pq.offer(it);
        }
        return rooms;


    }

    static void main() {

        Interval[] arr = {
                new Interval(7,9),
                new Interval(9,11),
                new Interval(8,10),
                new Interval(11,13),
                new Interval(10,14),
                new Interval(1,3)
        };

        MeetingRooms meet = new MeetingRooms();
        int rooms =meet.minMeetingRooms(arr);
        System.out.println(rooms);
    }
}
