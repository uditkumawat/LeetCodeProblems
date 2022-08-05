package code.leetcode.studyplan75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/submissions/
//TC - O(Nlogn)
//SC - O(N)
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(int i1[], int i2[])->{
            return i1[0]-i2[0];
        });

        List<int[]> list = new LinkedList<int[]>();

        for(int interval[]:intervals){
            if(list.isEmpty() || list.get(list.size()-1)[1]<interval[0]){
                list.add(interval);
            }
            else{
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],interval[1]);
            }
        }

        int arr[][] = new int[list.size()][2];
        int index = 0;
        while(index<list.size()){
            arr[index] = list.get(index);
            index++;
        }
        return arr;
    }
}
