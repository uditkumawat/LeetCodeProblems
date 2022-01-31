package code.google;

public class MaximumSumSubarray {

    public static void main(String args[]){

        int arr[] = {1, 7, -2, -5, 10, -1};

        MaximumSumSubarray obj = new MaximumSumSubarray();

        System.out.println(obj.findMaxSumSubArray(arr));

    }
    public int findMaxSumSubArray(int[] arr) {
        // Write - Your - Code
        int currentSumSoFar = 0;
        int maxSumSoFar = Integer.MIN_VALUE;

        for(int num:arr){
            currentSumSoFar+=num;
            maxSumSoFar = Math.max(maxSumSoFar,currentSumSoFar);
            if(currentSumSoFar<0){
                currentSumSoFar = 0;
            }
        }

        return maxSumSoFar;
    }
}
