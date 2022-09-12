package code.amazon;

import java.util.Arrays;
//https://leetcode.com/problems/maximum-units-on-a-truck/solution/
//https://www.youtube.com/watch?v=PltNSHdprc8&t=5s
public class MaximumUnitsTruckSize {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int unitCount = 0;
        for (int[] boxType : boxTypes) {
            int boxCount = Math.min(truckSize, boxType[0]);
            unitCount += boxCount * boxType[1];
            truckSize -= boxCount;
            if (truckSize == 0)
                break;
        }
        return unitCount;
    }
}
