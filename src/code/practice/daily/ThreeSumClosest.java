package code.practice.daily;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int searchTriplet(int[] arr, int targetSum) {
        // TODO: Write your code here
        Arrays.sort(arr);
        int closestSum = arr[0]+arr[1]+arr[arr.length-1];
        for(int i=0;i<arr.length-2;i++){
            if(i==0 || arr[i]!=arr[i-1]){
                int j = i+1;
                int k = arr.length-1;
                while(j<k){
                    int currSum = arr[i]+arr[j]+arr[k];
                    if(currSum>targetSum){
                        k--;
                    }
                    else{
                        j++;
                    }

                    if(Math.abs(currSum-targetSum)<Math.abs(closestSum-targetSum)){
                        closestSum = currSum;
                    }
                }
            }
        }
        return closestSum;
    }
}
