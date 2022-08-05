package code.blind75;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/insert-interval/submissions/
//TC - O(N)
//SC - O(N)
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new LinkedList();

        int len = intervals.length;
        int i=0;

        //non overlapping
        while(i<len && intervals[i][1]<newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        ///overlapping
        while(i<len && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        ans.add(newInterval);
        while(i<len){
            ans.add(intervals[i]);
            i++;
        }

        int res[][] = new int[ans.size()][2];

        int index = 0;
        for(int a[]:ans){
            res[index++] = a;
        }

        return res;
    }
}
