package code.august2022.challenge;

import java.util.*;

//https://leetcode.com/problems/reduce-array-size-to-the-half/submissions/
//TC - O(nlogn)
//SC - O(n)
//https://www.youtube.com/watch?v=EeiOR8VRRpw
public class ReducedArraySizeToHalf {

    public int minSetSize(int[] arr) {

        if(arr==null || arr.length==0){
            return 0;
        }

        int n = arr.length;
        int count = 0;
        Map<Integer,Integer> map = new HashMap();

        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer> freq = new ArrayList<Integer>(map.values());
        Collections.sort(freq, Collections.reverseOrder());

        int i=0;
        int totalElem=n;
        while(totalElem>n/2){
            totalElem = totalElem - freq.get(i);
            i++;
            count++;
        }

        return count;
    }
}
