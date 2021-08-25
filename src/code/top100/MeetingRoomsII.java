package code.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Algorithm
 *
 * Sort the given meetings by their start time.
 * Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
 * For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
 * If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
 * If not, then we allocate a new room and add it to the heap.
 * After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
 */
//TC - O(n)
public class MeetingRoomsII {

    public static void main(String args[]){
        int intervals[][] = {{0,30},{5,10},{15,20}};
      //  int intervals[][] = {{7,10},{2,4}};
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(int[][] intervals) {

        if(intervals==null || intervals.length==0){
            return 0;
        }

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        //min heap of ending time in ASC order
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->a-b);

        pq.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=pq.peek()){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }

        return pq.size();
    }
}
