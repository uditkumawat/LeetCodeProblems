package code.feb.challenge;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contiguous-array/
//TC - O(n)
//SC - O(n)
//https://www.youtube.com/watch?v=xpuhcOKTWXg
public class ContiguousArray {

    public static void main(String args[]){

        int arr[] = {0,1,0};

        ContiguousArray obj = new ContiguousArray();

        System.out.println(obj.findMaxLength(arr));
    }
    public int findMaxLength(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();

        int prefixSum = 0;
        map.put(0,-1);

        for(int i=0;i<nums.length;i++){
            prefixSum = prefixSum + ((nums[i]==0?-1:1));

            if(map.containsKey(prefixSum)){
                maxLen = Math.max(maxLen,i-map.get(prefixSum));
            }
            else{
                map.put(prefixSum,i);
            }
        }

        return maxLen;
    }
}
