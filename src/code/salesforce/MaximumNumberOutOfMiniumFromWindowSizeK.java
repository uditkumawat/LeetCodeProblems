package code.salesforce;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumNumberOutOfMiniumFromWindowSizeK {

    public static void main(String[] args) {
        int[] arr = {1,3,4,6,2,9,8, 1, 0};
        int k = 5;

        System.out.println(func(arr, k));
    }

    public static int func(int nums[],int k){

        if(nums==null || nums.length==0){
            return 0;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int maxNumber = 0;
        int mins[] = new int[n-k+1];
        int index = 0;

        for(int i=0;i<nums.length;i++){

            while(!dq.isEmpty() && dq.getFirst()<=i-k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.getLast()]>nums[i]){
                dq.removeLast();
            }

            dq.add(i);
            if(i-k+1>=0){
                mins[index++] = nums[dq.getFirst()];
            }
        }

        for(int num:mins){
            maxNumber = Math.max(maxNumber,num);
        }

        return maxNumber;

    }
}
