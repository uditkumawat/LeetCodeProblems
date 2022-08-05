package code.blind75;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms/solution/
//TC - O(nlogn)
//SC - O(1)
public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {

        if(intervals==null || intervals.length==0){
            return true;
        }

        Arrays.sort(intervals,(int i1[], int i2[])->{
            return i1[0]-i2[0];
        });

        int prev = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(prev>intervals[i][0]){
                return false;
            }
            prev = intervals[i][1];
        }

        return true;
    }
}
