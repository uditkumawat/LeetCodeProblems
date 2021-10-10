package code.top100;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=HbbYPQc-Oo4
//TC - O(N)
//SC - O(N)
public class SubArraySumEqualsK {

    public static void main(String args[]){

        int arr[] = {3,4,7,2,-3,1,4,2};
        int k=7;
        System.out.println(subarraySum(arr,k));
    }

    public static int subarraySum(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap<>();
        int currSum = 0;
        int count=0;

        for(int i=0;i<nums.length;i++){

            currSum+=nums[i];

            if(currSum==k){
                count++;
            }
            else if(map.containsKey(currSum-k)){
                count+=map.get(currSum-k);
            }

            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }

        return count;
    }
}
