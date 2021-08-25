package code.top100;

import java.util.HashMap;
import java.util.Map;

//TC - O(n)
//SC - O(n)
public class TwoSum {

    public static void main(String args[]){

        int nums[] = {3,3};
        int target = 6;
        int indices[] = twoSum(nums,target);
        System.out.println(indices[0]+" "+indices[1]);
    }
        public static int[] twoSum(int[] nums, int target) {

            Map<Integer,Integer> map = new HashMap<>();

            int arr[] = new int[2];

            for(int i=0;i<nums.length;i++){
                if(map.containsKey(target-nums[i])){
                    arr[0] = map.get(target-nums[i]);
                    arr[1] = i;
                }
                else{
                    map.put(nums[i],i);
                }
            }

            return arr;
        }

}
