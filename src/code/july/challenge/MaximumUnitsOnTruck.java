package code.july.challenge;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-units-on-a-truck/submissions/
//TC - O(nlogn)
//SC - O(1)
//https://www.youtube.com/watch?v=PltNSHdprc8
public class MaximumUnitsOnTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        //sort in descending order to maximize units
        Arrays.sort(boxTypes,(int a[], int b[])->b[1]-a[1]);

        int units = 0;

        for(int i=0;i<boxTypes.length;i++){

            if(truckSize<0){
                break;
            }

            int boxType[] = boxTypes[i];

            int box = Math.min(truckSize,boxType[0]);

            units = units + box * boxType[1];

            truckSize = truckSize - boxType[0];
        }

        return units;
    }
}
