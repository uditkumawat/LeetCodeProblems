package code.salesforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/submissions/
//TC - O(nlogn)
//SC - O(n)
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList();

        Arrays.sort(intervals,(int interval1[], int interval2[])->{
            return interval1[0]==interval2[0]?interval1[1]-interval2[1]:interval1[0]-interval2[0];
        });

        for(int i=0;i<intervals.length;i++){
            if(list.isEmpty()){
                list.add(intervals[i]);
            }
            else{
                if(list.get(list.size()-1)[1]<intervals[i][0]){
                    list.add(intervals[i]);
                }
                else{
                    list.get(list.size()-1)[1] = Math.max(intervals[i][1],list.get(list.size()-1)[1]);
                }
            }
        }

        int res[][] = new int[list.size()][2];
        int index = 0;

        for(int data[]:list){
            res[index] = data;
            index++;
        }

        return res;
    }
}
