package code.top100;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public static void main(String args[]){
        int nums1[] = {1,2}, nums2[] = {-2,-1}, nums3[] = {-1,2}, nums4[] = {0,2};

        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int a:nums1){
            for(int b:nums2){
                map.put(a+b,map.getOrDefault(a+b,0)+1);
            }
        }

        int count = 0;

        for(int c:nums3){
            for(int d:nums4){
                count+=map.getOrDefault(-(c+d),0);
            }
        }

        return count;
    }
}
