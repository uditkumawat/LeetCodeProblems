package code.blind75;

import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
//https://leetcode.com/problems/non-overlapping-intervals/submissions/
//TC - O(nlogn)
//SC - O(1)
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals==null || intervals.length==0){
            return 0;
        }

        //sort by end time
        Arrays.sort(intervals,(int i1[], int i2[])->{
            return i1[1]-i2[1];
        });

        int end = intervals[0][1];
        int count = 1;

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length-count;
    }
}
