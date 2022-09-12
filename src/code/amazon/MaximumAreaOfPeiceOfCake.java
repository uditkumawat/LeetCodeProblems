package code.amazon;

import java.util.Arrays;

public class MaximumAreaOfPeiceOfCake {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxHeight = Math.max(horizontalCuts[0]-0,h-horizontalCuts[horizontalCuts.length-1]);

        for(int i=1;i<horizontalCuts.length;i++){
            int currDiff = horizontalCuts[i]-horizontalCuts[i-1];
            maxHeight = Math.max(maxHeight,currDiff);
        }

        int maxWidth = Math.max(verticalCuts[0]-0,w-verticalCuts[verticalCuts.length-1]);

        for(int i=1;i<verticalCuts.length;i++){
            int currDiff = verticalCuts[i]-verticalCuts[i-1];
            maxWidth = Math.max(maxWidth,currDiff);
        }

        long ans = ((long)(maxWidth) % 1000000007 * (long)(maxHeight) % 1000000007) % 1000000007;

        return (int) ans;
    }
}
