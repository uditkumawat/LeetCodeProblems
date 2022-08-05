package code.blind75;

import java.util.Arrays;
import java.util.LinkedList;

//https://leetcode.com/problems/merge-intervals/
//TC - O(nlogn)
//SC - O(!)
public class MergeIntervals {


    public int[][] merge(int[][] intervals) {

        if(intervals==null || intervals.length==0){
            return intervals;
        }

        Arrays.sort(intervals,(int i1[], int i2[])->{
            if(i1[0]==i2[0]){
                return i1[1]-i2[1];
            }
            return i1[0]-i2[0] ;
        });

        LinkedList<int[]> list = new LinkedList();

        for(int interval[]:intervals){
            if(list.isEmpty() || list.getLast()[1]<interval[0]){
                list.add(interval);
            }
            else{
                list.getLast()[1] = Math.max(list.getLast()[1],interval[1]);
            }
        }

        int ans[][] = new int[list.size()][2];
        int index = 0;
        for(int a[]:list){
            ans[index++] = a;
        }

        return ans;
    }
}
