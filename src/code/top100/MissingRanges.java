package code.top100;

import java.util.ArrayList;
import java.util.List;

//TC - O(N)
//SC - O(1)
public class MissingRanges {

    public static void main(String args[]){
        int nums[]={0,1,3,50,75};
        int lower = 0;
        int higher = 99;

        List<String> list  = findMissingRanges(nums,lower,higher);

        for(String str:list){
            System.out.println(str);
        }
    }
        public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

            List<String> list = new ArrayList<>();

            if(nums==null || nums.length==0){
                if(lower==upper){
                    list.add(String.valueOf(lower));
                }
                else{
                    list.add(lower+"->"+upper);
                }
                return list;
            }

            if(nums[0]!=lower && lower<nums[0]){
                list.add(lower+"->"+(nums[0]-1));
            }

            for(int i=1;i<nums.length;i++){
                if(nums[i]-nums[i-1]!=1){
                    int lowerRange = nums[i-1]+1;
                    int higherRange = nums[i]-1;
                    if(lowerRange==higherRange){
                        list.add(String.valueOf(lowerRange));
                    }
                    else{
                        list.add(lowerRange+"->"+higherRange);
                    }
                }
            }

            if(nums[nums.length-1]!=upper && upper>nums[nums.length-1]){
                list.add(nums[nums.length-1]+1+"->"+upper);
            }

            return list;
        }
}
