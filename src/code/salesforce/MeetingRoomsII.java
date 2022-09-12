package code.salesforce;

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

        Arrays.sort(intervals,(int interval1[], int interval2[])->{
            return interval1[0]==interval2[0]?interval1[1]-interval2[1]:
                    interval1[0]-interval2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){
            if(pq.peek()<=intervals[i][0]){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }

        return pq.size();
    }
}
