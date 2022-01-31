package code.facebook;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if(intervals==null || intervals.length<=1){
            return intervals;
        }

        Arrays.sort(intervals,(int a[],int b[])->{
            return a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
        });

        LinkedList<int[]> merged = new LinkedList<>();

        for(int interval[]:intervals){

            if(merged.isEmpty() || merged.getLast()[1]<interval[0]){
                merged.add(interval);
            }
            else{
                merged.getLast()[1] = Math.max(interval[1],merged.getLast()[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
