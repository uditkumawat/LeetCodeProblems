package code.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC - O(nlogn)
//SC- O(n)
public class MergeIntervals {

    public static void main(String args[]){

        int intervals[][] = {{1,3},{3,6},{8,10},{15,18}};
        int indices[][] = mergeIntervals2(intervals);
        for(int interval[]:indices){
            System.out.println(interval[0]+" "+interval[1]);
        }
    }

    public static int[][] mergeIntervals(int intervals[][]){
        if(intervals.length<1){
            return intervals;
        }

        Arrays.sort(intervals,(a, b)->(a[0]-b[0]));

        List<int[]> list = new ArrayList<>();

        for(int interval[]:intervals){
            //if endTime of last interval is less than start time of new interval,so new entry
            if(list.isEmpty() || list.get(list.size()-1)[1]<interval[0]){
                list.add(interval);
            }
            else{
                //if endTime of last interval is more than start time of new interval,so we will merge
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],interval[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static int[][] mergeIntervals2(int[][] intervals) {

        if(intervals==null || intervals.length==0){
            return new int[0][0];
        }

        List<int[]> finalList = new ArrayList<>();

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        for(int i=0;i<intervals.length;i++){
            if(finalList.isEmpty() || finalList.get(finalList.size()-1)[1]<intervals[i][0]){
                finalList.add(intervals[i]);
            }
            else{

                int lastInterval[] = finalList.get(finalList.size()-1);

                finalList.get(finalList.size()-1)[1] = Math.max(lastInterval[1],intervals[i][1]);

            }
        }

        return finalList.toArray(new int[finalList.size()][]);
    }
}
