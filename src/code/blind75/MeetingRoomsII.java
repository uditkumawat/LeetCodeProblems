package code.blind75;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/meeting-rooms-ii/solution/
//TC - O(nlogn)
//SC - O(N)
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {

        if(intervals==null || intervals.length==0){
            return 0;
        }

        Arrays.sort(intervals,(int i1[], int i2[])->{
            return i1[0]-i2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{
            return a-b;
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
