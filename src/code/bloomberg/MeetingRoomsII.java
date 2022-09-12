package code.bloomberg;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/meeting-rooms-ii/solution/
//TC - O(nlogn)
//SC - O(N)

/**
 * Time Complexity: O(NlogN).
 *
 * There are two major portions that take up time here. One is sorting of the array that takes O(N\log N)O(NlogN) considering that the array consists of NN elements.
 * Then we have the min-heap. In the worst case, all NN meetings will collide with each other. In any case we have NN add operations on the heap. In the worst case we will have NN extract-min operations as well. Overall complexity being (NlogN)(NlogN) since extract-min operation on a heap takes O(\log N)O(logN).
 * Space Complexity: O(N)O(N) because we construct the min-heap and that can contain NN elements in the worst case as described above in the time complexity section. Hence, the space complexity is O(N)O(N).
 */
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length==0){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{
            return a-b;
        });

        Arrays.sort(intervals,(int i1[], int i2[])->{
            return i1[0]-i2[0];
        });

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
