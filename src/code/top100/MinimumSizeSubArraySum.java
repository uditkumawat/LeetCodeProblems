package code.top100;

public class MinimumSizeSubArraySum {


    public static void main(String args[]){

        int arr[] = {2,3,1,2,4,3};
        int s = 7;

        System.out.println(minSubArrayLen(arr,s));
    }
    public static int minSubArrayLen(int nums[],int s){

        int res = Integer.MAX_VALUE;

        int left = 0;
        int valSum = 0;

        for(int i=0;i<nums.length;i++){

            valSum += nums[i];

            while(valSum>=s){
                res = Math.min(res,i-left+1);
                valSum = valSum-nums[left];
                left++;
            }
        }

        return res!=Integer.MAX_VALUE?res:0;
    }
}
