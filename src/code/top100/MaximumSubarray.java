package code.top100;

public class MaximumSubarray {

    public static void main(String args[]){

        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.print(maxSum(arr));
    }
    public static int maxSum(int arr[]){

        if(arr==null || arr.length==0){
            return 0;
        }

        int n = arr.length;

        int maxsum = arr[0];
        int sum = arr[0];

        for(int i=1;i<arr.length;i++){
            int num = arr[i];

            sum=Math.max(num,sum+num);
            maxsum = Math.max(maxsum,sum);
        }

        return maxsum;
    }
}
