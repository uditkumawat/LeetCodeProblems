package code.top100;

public class MaximumSumIncreasingSubSequence {

    public static void main(String args[]){

        int arr[] = {4,1,3,6,5,7,8};

        System.out.println(maxIncreasingSumSubSequence(arr));
    }

    public static int maxIncreasingSumSubSequence(int arr[]){

        int n = arr.length;
        int mis[] = new int[n];

        for(int i=0;i<arr.length;i++){
            mis[i] = arr[i];
        }

        int maxSum = 0;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && mis[i]<arr[i]+mis[j]){
                    mis[i] = arr[i]+mis[j];
                }
                maxSum = Math.max(maxSum,mis[i]);
            }
        }

        return maxSum;
    }
}
