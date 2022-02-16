package code.feb.challenge;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=20v8zSo2v18
//TC - O(n)
public class SubarraySumEqualsK {

    public static void main(String args[]){

        int nums[] = {1,2,3};
        int k = 3;

        SubarraySumEqualsK obj = new SubarraySumEqualsK();

        System.out.println(obj.subarraySum(nums,k));
    }

    public int subarraySumBrute(int[] nums, int k) {

        int sum = 0;
        int count = 0;

        for(int i=0;i<nums.length;i++){
            sum = 0;
            for(int j=i;j<nums.length;j++){
                sum = sum + nums[j];
                if(sum==k){
                    count++;
                }
            }
        }

        return count;
    }

    public int subarraySum(int nums[],int k){

        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);

        int count = 0;
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
    }
}
