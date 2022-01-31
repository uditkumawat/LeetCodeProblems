package code.google;

public class MaximumSumSubArrayOfSizeK {

    public static void main(String args[]){

        int arr[] = {2, 3, 4, 1, 5};
        int k = 2;

        MaximumSumSubArrayOfSizeK obj = new MaximumSumSubArrayOfSizeK();

        System.out.println(obj.findMaxSumSubArray(k,arr));

    }
    public int findMaxSumSubArray(int k, int[] arr) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        while(right<arr.length){
            sum+=arr[right];
            if(right>=k-1){
                maxSum = Math.max(maxSum,sum);
                sum = sum - arr[left];
                left++;
            }

            right++;
        }

        return maxSum;
    }
}
