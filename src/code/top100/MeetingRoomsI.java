package code.top100;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms/
//TC - O(nlogn)
//SC - O(1)
public class MeetingRoomsI {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
