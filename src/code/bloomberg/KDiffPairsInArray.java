package code.bloomberg;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {

    public int findPairs(int[] nums, int k) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int res = 0;

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(k>0 && map.containsKey(key+k)){
                res++;
            }
            else if(k==0 && value>1){
                res++;
            }
        }

        return res;
    }
}
