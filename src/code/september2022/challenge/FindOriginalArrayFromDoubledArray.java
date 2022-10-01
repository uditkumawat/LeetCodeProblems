package code.september2022.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-original-array-from-doubled-array/submissions/
//TC - O(nlogn)
//SC - O(N)
public class FindOriginalArrayFromDoubledArray {

    public int[] findOriginalArray(int[] changed) {

        if(changed.length%2!=0){  //if changed array is not of even length
            return new int[0];
        }

        Arrays.sort(changed); //sort in ascending order

        Map<Integer,Integer> map = new HashMap();

        for(int num:changed){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int original[] = new int[changed.length/2];
        int index = 0;

        for(int num:changed){

            if(map.get(num)>0){

                map.put(num,map.get(num)-1);
                int twiceNum = num*2;

                if(map.containsKey(twiceNum) && map.get(twiceNum)>0){
                    map.put(twiceNum,map.get(twiceNum)-1);
                    original[index++] = num;
                }
                else{
                    return new int[0];
                }
            }
        }

        return original;
    }
}
