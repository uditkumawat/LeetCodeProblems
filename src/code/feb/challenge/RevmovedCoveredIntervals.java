package code.feb.challenge;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/remove-covered-intervals/
//TC - O(N+NLOGN)
//SC - O(1)
//https://leetcode.com/problems/remove-covered-intervals/discuss/451250/Java-Simple-Sort
public class RevmovedCoveredIntervals {

    public static void main(String args[]){

        int intervals[][] = {{1,4},{3,6},{2,8}};

        RevmovedCoveredIntervals obj = new RevmovedCoveredIntervals();

        System.out.println(obj.removeCoveredIntervals(intervals));
    }
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals,(int i1[],int i2[]) -> {
            if(i1[0]==i2[0]){
                return i1[1]-i2[1];
            }
            else{
                return i1[0]-i2[0];
            }
        });

        int res = 0, right = 0;

        /**
         * In this solution, we sort on left first.
         * When left are same, we sort right in decending order.
         *
         * For example: [[1,5],[1,4],[1,3],[1,2]]
         */
        for (int[] interval : intervals) {
            if (interval[1] > right) {
                ++res;
                right = interval[1];
            }
        }
        return res;
    }

    /**
     * public int removeCoveredIntervals(int[][] intervals) {
     *         int n = intervals.length;
     *         Arrays.sort(intervals, new Comparator<int[]>(){
     *             public int compare(int[] e1, int[] e2){
     *                 if(e1[0] < e2[0]) return -1;
     *                 if(e2[0] < e1[0]) return 1;
     *                 if(e1[1] > e2[1]) return -1;
     *                 return 1;
     *             }
     *         });
     *
     *         int count = 1;
     *         int[] prev = intervals[0];
     *         for(int i = 1; i < n; i++){
     *             if(intervals[i][0] >= prev[0] && intervals[i][1] <= prev[1]) continue;
     *             prev = intervals[i];
     *             count++;
     *         }
     *         return count;
     *     }
     */
}
