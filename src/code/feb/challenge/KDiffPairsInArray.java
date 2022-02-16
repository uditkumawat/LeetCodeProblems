package code.feb.challenge;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {

    public static void main(String args[]){

        int arr[] = {3,1,4,1,5};
        int k = 2;

        KDiffPairsInArray obj = new KDiffPairsInArray();

        System.out.println(obj.findPairs(arr,k));

    }
    public int findPairs(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int res = 0;

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(k==0){
                if(entry.getValue()>=2){
                    res++;
                }
            }
            else if(map.containsKey(entry.getKey()+k)){
                res++;
            }
        }

        return res;
    }

}
