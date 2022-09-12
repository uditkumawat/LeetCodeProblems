package code.salesforce;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        if(nums==null || nums.length==0){
            return null;
        }

        String strs[] = new String[nums.length];

        for(int i=0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(x, y)->{
            String xy = x+y;
            String yx = y+x;

            return yx.compareTo(xy);
        });

        if(strs[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String num:strs){
            sb.append(num);
        }

        return sb.toString();
    }
}
