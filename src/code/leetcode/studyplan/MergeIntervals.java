package code.leetcode.studyplan;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/merge-intervals/submissions/
//TC - O(nlogn)
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(int i1[], int i2[])->{
            return i1[0]-i2[0];
        });

        Stack<Pair<Integer,Integer>> stack = new Stack<>();

        for(int i=0;i<intervals.length;i++){
            int interval[] = intervals[i];
            if(stack.isEmpty()){
                stack.push(new Pair(interval[0],interval[1]));
            }
            else{
                Pair<Integer,Integer> lastPair = stack.pop();
                if(lastPair.getValue()>=interval[0]){
                    stack.push(new Pair(lastPair.getKey(),Math.max(lastPair.getValue(),interval[1])));
                }
                else{
                    stack.push(lastPair);
                    stack.push(new Pair<Integer,Integer>(interval[0],interval[1]));
                }
            }
        }

        int n = stack.size();
        int arr[][] = new int[n][2];
        while(n-->0){
            Pair<Integer,Integer> pair = stack.pop();
            arr[n][0] = pair.getKey();
            arr[n][1] = pair.getValue();
        }

        return arr;
    }
}
