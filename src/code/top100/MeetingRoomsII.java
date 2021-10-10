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

/**
 * Time Complexity: O(N\log N)O(NlogN).
 *
 * There are two major portions that take up time here. One is sorting of the array that takes O(N\log N)O(NlogN) considering that the array consists of NN elements.
 * Then we have the min-heap. In the worst case, all NN meetings will collide with each other. In any case we have NN add operations on the heap. In the worst case we will have NN extract-min operations as well. Overall complexity being (NlogN)(NlogN) since extract-min operation on a heap takes O(\log N)O(logN).
 * Space Complexity: O(N)O(N) because we construct the min-heap and that can contain NN elements in the worst case as described above in the time complexity section. Hence, the space complexity is O(N)O(N).
 */
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
