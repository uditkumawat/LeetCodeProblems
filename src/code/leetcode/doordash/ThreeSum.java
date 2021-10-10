package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC - O(n*2)

public class ThreeSum {

    public static void main(String args[]){

        int arr[]={-1,0,1,2,-1,-4};

        System.out.println(threeSum2(arr));
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++){
            if(i==0 || i>0 && nums[i]!=nums[i-1]){
                int low = i+1;
                int high = nums.length-1;
                while(low<high){

                    int sum = nums[i] + nums[low]+ nums[high];
                    if(sum==0){
                        list.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        low++;
                        high--;

                        while(low<high && nums[low]==nums[low+1]){
                            low++;
                        }


                        while(low<high && nums[high-1]==nums[high]) {
                            high--;
                        }
                    }
                    else if(sum>0){
                        high--;
                    }
                    else{
                        low++;
                    }
                }
            }
        }

        return list;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> result = new ArrayList();

        if(nums==null || nums.length==0){
            return result;
        }

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            if(i==0 || i>0 && nums[i-1]!=nums[i]){

                int left = i+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[left]+nums[right];
                    if(sum==0){
                        result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right--;

                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }


                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                    }
                    else if(sum>0){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }

        return result;
    }
}

