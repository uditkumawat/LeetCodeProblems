package code.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC - O(n*2)

public class ThreeSum {

    public static void main(String args[]){

        int arr[]={0};

        System.out.println(threeSum(arr));
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
}
