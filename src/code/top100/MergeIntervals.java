package code.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC - O(nlogn)
//SC- O(n)
public class MergeIntervals {

    public static void main(String args[]){

        int intervals[][] = {{1,3},{2,6},{8,10},{15,18}};
        int indices[][] = mergeIntervals(intervals);
        System.out.println(indices);
    }

    public static int[][] mergeIntervals(int intervals[][]){
        if(intervals.length<1){
            return intervals;
        }

        Arrays.sort(intervals,(a, b)->(a[0]-b[0]));

        List<int[]> list = new ArrayList<>();

        for(int interval[]:intervals){
            if(list.isEmpty() || list.get(list.size()-1)[1]<interval[0]){
                list.add(interval);
            }
            else{
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],interval[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
