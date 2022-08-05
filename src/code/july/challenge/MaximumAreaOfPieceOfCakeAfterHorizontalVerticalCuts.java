package code.july.challenge;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/submissions/
//TC - O(hlogh + wlogw + h + w)
//SC - O(1)
public class MaximumAreaOfPieceOfCakeAfterHorizontalVerticalCuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        return (int)((long)getMax(h,horizontalCuts)*getMax(w,verticalCuts) % 1000000007);
    }

    public int getMax(int d,int dist[]){

        Arrays.sort(dist);

        int len = dist.length;

        int max = Math.max(dist[0]-0,d-dist[len-1]);

        for(int i=1;i<len;i++){
            max = Math.max(max,dist[i]-dist[i-1]);
        }

        return max;
    }
}
