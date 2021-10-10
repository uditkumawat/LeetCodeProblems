package code.top100;

import java.util.HashMap;

//https://www.youtube.com/watch?v=nSEO5zOwP7g
public class ContiguousArray {

    public int findMaxLength(int nums[]){

        HashMap<Integer,Integer> counts = new HashMap<>();
        counts.put(0,-1);
        int maxLength=0;
        int count = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count--;
            }
            else{
                count++;
            }

            if(counts.containsKey(count)){
                maxLength = Math.max(maxLength,i-counts.get(count));
            }
            else{
                counts.put(count,i);
            }
        }

        return maxLength;
    }
}
